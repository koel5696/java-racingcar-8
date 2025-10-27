package racingcar.constants;

public enum Regex {
    NAME_INPUT("^[a-zA-Z가-힣]+$"),
    ROUND_INPUT("^[1-9]\\d*$"),
    NEWLINE("\n"),
    NAME_SPLIT(","),
    WINNERS_NAME_SPLIT(", "),
    FORWARD_EXPRESS("-"),
    NAME_SEPARATOR(" : ");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
