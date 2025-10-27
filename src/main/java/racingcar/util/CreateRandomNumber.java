package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class CreateRandomNumber {
    public static final int RANDOM_DIGIT_MIN = 0;
    public static final int RANDOM_DIGIT_MAX = 9;

    private CreateRandomNumber() {
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_DIGIT_MIN, RANDOM_DIGIT_MAX);
    }
}
