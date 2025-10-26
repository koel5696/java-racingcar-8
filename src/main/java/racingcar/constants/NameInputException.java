package racingcar.constants;

public enum NameInputException {
    NAME_INPUT_EMPTY_ERROR("참여자 입력이 빈 값으로(공백 포함) 들어왔습니다."),
    NAME_EMPTY_ERROR("이름이 빈 값(공백 포함)일 수는 없습니다."),
    NAME_FORMAT_FORMAT_ERROR("이름은 한글(온전한 형식)과 알파벳으로만 띄어쓰기 없이 입력해야 합니다."),
    NAME_LENGTH_ERROR("허용된 이름 길이는 1~5글자 입니다."),
    UNDERSTAFFED_ERROR("경주를 진행하려면 최소 2명을 쉼표로 구분해서 입력하세요."),
    NAME_UNIQUE_ERROR("참여자 이름은 유일해야 합니다.");

    private final String message;

    NameInputException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
