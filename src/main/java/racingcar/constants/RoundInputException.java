package racingcar.constants;

public enum RoundInputException {
    ROUND_INPUT_EMPTY_ERROR("라운드 입력이 빈 값(공백 포함)으로 들어왔습니다."),
    ROUND_INPUT_FORMAT_ERROR("라운드 수는 자연수(공백 없이)로 입력해주세요."),
    OVERFLOW_ERROR("라운드 수가 너무 많습니다.");

    private final String message;

    RoundInputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
