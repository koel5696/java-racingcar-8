package racingcar.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RoundValidServiceTest {

    @Test
    void 라운드_입력_오버플로우_예외_테스트() {
        RoundValidService roundValidService = new RoundValidService();
        assertThatThrownBy(() -> roundValidService.roundInputValid("2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수가 너무 많습니다.");
    }

    @Test
    void 라운드_입력_형식_예외_테스트() {
        RoundValidService roundValidService = new RoundValidService();
        assertThatThrownBy(() -> roundValidService.roundInputValid("숫자"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수는 자연수(공백 없이)로 입력해주세요.");
    }

    @Test
    void 라운드_입력_음수_예외_테스트() {
        RoundValidService roundValidService = new RoundValidService();
        assertThatThrownBy(() -> roundValidService.roundInputValid("-10"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 수는 자연수(공백 없이)로 입력해주세요.");
    }

    @Test
    void 라운드_입력_빈_값_예외_테스트() {
        RoundValidService roundValidService = new RoundValidService();
        assertThatThrownBy(() -> roundValidService.roundInputValid(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("라운드 입력이 빈 값(공백 포함)으로 들어왔습니다.");
    }
}
