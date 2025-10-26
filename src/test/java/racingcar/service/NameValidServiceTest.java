package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class NameValidServiceTest {

    @Test
    void 이름_5글자_초과_예외_테스트() {
        NameValidService nameValidService = new NameValidService();
        assertThatThrownBy(() -> nameValidService.nameInputValid("genesis,benz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("허용된 이름 길이는 1~5글자 입니다.");
    }

    @Test
    void 이름_빈_입력_예외_테스트() {
        NameValidService nameValidService = new NameValidService();
        assertThatThrownBy(() -> nameValidService.nameInputValid("lay,,benz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름이 빈 값(공백 포함)일 수는 없습니다.");
    }

    @Test
    void 입력_자체_빈_입력_예외_테스트() {
        NameValidService nameValidService = new NameValidService();
        assertThatThrownBy(() -> nameValidService.nameInputValid(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 입력이 빈 값으로(공백 포함) 들어왔습니다.");
    }

    @Test
    void 이름_형식_예외_테스트() {
        NameValidService nameValidService = new NameValidService();
        assertThatThrownBy(() -> nameValidService.nameInputValid("g80,k2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 한글(온전한 형식)과 알파벳으로만 띄어쓰기 없이 입력해야 합니다.");
    }

    @Test
    void 참여자_최소_2명_예외_테스트() {
        NameValidService nameValidService = new NameValidService();
        assertThatThrownBy(() -> nameValidService.nameInputValid("benz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("경주를 진행하려면 최소 2명을 쉼표로 구분해서 입력하세요.");
    }

    @Test
    void 이름_중복_예외_테스트() {
        NameValidService nameValidService = new NameValidService();
        assertThatThrownBy(() -> nameValidService.nameInputValid("benz,benz"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참여자 이름은 유일해야 합니다.");
    }
}
