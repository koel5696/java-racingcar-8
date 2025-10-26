package racingcar.constants;

public enum GameGuideMessage {
    PRINT_NAME_GUIDE_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    PRINT_ROUND_GUIDE_MESSAGE("시도할 횟수는 몇 회인가요?"),
    PRINT_GAME_RESULT_MESSAGE("실행 결과"),
    PRINT_GAME_WINNERS_MESSAGE("최종 우승자 : ");

    private final String message;

    GameGuideMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
