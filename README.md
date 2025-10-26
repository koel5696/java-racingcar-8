# 자동차 경주

---

## 개요

초간단 자동차 경주 게임을 구현한다.

**🛠 구현할 문제**
---

1. 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
2. 각 자동차에 이름을 부여하여 전진하는 자동차를 출력할 때 이름도 출력한다.
3. 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
4. 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
5. 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
6. 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
7. 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
8. 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

✅ **검증 사항**
---

1. 아래에 해당하는 입력이 들어오면 `IllegalArgumentException`을 발생시킨 후 종료시킨다.
    1. 자동차 이름 입력에 대한 검증
        - 자동차 이름이 5글자를 초과.
        - 자동차 이름에 한글과 영어를 제외한 다른 입력
        - 빈입력이나 공백문자가 포함된 입력
        - 경주를 진행할 인원이 1명인 경우(1명이서 경주하는 경우는 현실적으로 존재x)
        - 참여자 이름이 중복되어 들어올 경우

    2. 경주를 진행할 횟수 입력에 대한 검증
        - int범위를 넘어서는 경주 횟수 입력
        - 숫자가 아닌 입력(문자, 공백 문자, 빈 입력)
        - 자연수가 아닌 입력

    ```jsx
    // 아래의 코드와 일맥상통하는 입력은 모두의 예외를 발생시킨다.
    
    //name
    overFiveLetter,name ⇒ error
    num123,name ⇒ error
    same,same ⇒ error
    one ⇒ error
    space, ,space ⇒ error
    
    //roundCount
    2147483648 ⇒ error
    -5 ⇒ error
    1.53 ⇒ error
    12 3 ⇒ error
    00005 ⇒ error
    String ⇒ error
    ```

**상세 기능 구현 방향**
---

1. **사용자 입출력 기능**
    - `InputView` : 사용자에게 경주를 진행할 자동차 이름과 진행 횟수를 입력받는다.
    - `OutputView` : 경주 결과와 최종 우승자를 출력한다.

1. 입력 검증 Service
    - `NameValidService` : 자동차 이름 입력을 검증한다.
    - `RoundValidService`: 라운드 횟수 입력을 검증한다.

2. 게임 총괄 domain
    - `Car` : 입력된 각 자동차의 이름과 전진 유무를 저장하고 관리할 클래스.
    - `Cars` : 경주를 진행할 자동차들을 관리하는 일급 컬렉션.
    - `RacingGame` : 게임을 실행하고 결과를 관리하는 클래스.

1. 게임 진행 Controller
    - `RacingGameController` : 프로그램을 실행하여 전체 흐름을 관리하는 클래스.
        - view와 domian, sevice를 오가며 게임 진행을 맡음.

2. 전제 상수 관리 enum
    - `GameGuideMessage` : 게임 진행 I/O 안내 메시지 상수.
    - `NameInputException` : 자동차 이름 입력 예외 메시지 상수.
    - `RoundInputException`: 진행 횟수 입력 예외 메시지 상수.
    - `Regex` : 게임 형식 규정에 대한 정규식 상수.

```jsx
src / main / java /
└── racingcar /
│
├── constants /
│   ├── GameGuideMessage.java
│   ├── NameInputException.java
│   ├── Regex.java
│   └── RoundInputException.java
│
├── controller /
│   └── RacingGameController.java
│
├── domain /
│   ├── Car.java
│   ├── Cars.java
│   └── RacingGame.java
│
├── service /
│   ├── NameValidService.java
│   └── RoundValidService.java
│
├── view /
│   ├── InputView.java
│   └── OutputView.java
│
└── Application.java
:
10240407
: **
상세
기능
구현
방향 **
```

**테스트 사항**
---

1. 게임 진행 로직 테스트
    - CarTest : 랜덤값을 임의로 지정해 전진 유무를 체크하고 우승자를 확인함.
    - CarsTest: 자동차 전체 전진 로직을 확인하고, 우승자를 최종적으로 찾아서 저장하는지 확인함.

2. 입력 검증 테스트
    - NameValidServiceTest : 이름 입력에 대한 예외 테스트를 진행함.
    - RoundValidServiceTest : 진행 횟수 입력에 대한 예외 테스트를 진행함.

3. 전체 로직 테스트
    - ApplicationTest : 입력값에 대한 올바른 출력을 확인함.