package racingcar.service;

import static racingcar.constants.Regex.ROUND_INPUT;
import static racingcar.constants.RoundInputException.OVERFLOW_ERROR;
import static racingcar.constants.RoundInputException.ROUND_INPUT_EMPTY_ERROR;
import static racingcar.constants.RoundInputException.ROUND_INPUT_FORMAT_ERROR;

import java.math.BigInteger;

public class RoundValidService {
    public int roundInputValid(String inputRound) {
        roundInputEmptyValid(inputRound);
        roundInputFormatValid(inputRound);
        return overFlowValidation(inputRound);
    }

    private void roundInputEmptyValid(String inputRound) {
        if (inputRound == null || inputRound.isBlank()) {
            throw new IllegalArgumentException(ROUND_INPUT_EMPTY_ERROR.getMessage());
        }
    }

    private void roundInputFormatValid(String inputRound) {
        if (!inputRound.matches(ROUND_INPUT.getRegex())) {
            throw new IllegalArgumentException(ROUND_INPUT_FORMAT_ERROR.getMessage());
        }
    }

    private int overFlowValidation(String inputRound) {
        BigInteger bigInteger = new BigInteger(inputRound);
        BigInteger maxInt = BigInteger.valueOf(Integer.MAX_VALUE);

        if (bigInteger.compareTo(maxInt) > 0) {
            throw new IllegalArgumentException(OVERFLOW_ERROR.getMessage());
        }
        return Integer.parseInt(inputRound);
    }
}
