package racingcar.domain;


import static racingcar.constants.Regex.FORWARD_EXPRESS;
import static racingcar.constants.Regex.NAME_SEPARATOR;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Optional;

public class Car {
    public static final int RANDOM_DIGIT_MIN = 0;
    public static final int RANDOM_DIGIT_MAX = 9;
    public static final int MOVING_FORWARD = 4;

    private final String carName;
    private int forwardCount;

    public Car(String inputName) {
        carName = inputName;
        forwardCount = 0;
    }

    public void goOrStop() {
        if (Randoms.pickNumberInRange(RANDOM_DIGIT_MIN, RANDOM_DIGIT_MAX) >= MOVING_FORWARD) {
            forwardCount++;
        }
    }

    public Optional<String> saveWinners(int maxDistance) {
        if (forwardCount == maxDistance) {
            return Optional.of(carName);
        }
        return Optional.empty();
    }

    public int compareToMaxDistance(int currentMaxDistance) {
        if (forwardCount > currentMaxDistance) {
            currentMaxDistance = forwardCount;
        }
        return currentMaxDistance;
    }

    @Override
    public String toString() {
        return carName + NAME_SEPARATOR.getRegex() + FORWARD_EXPRESS.getRegex().repeat(forwardCount);
    }

}
