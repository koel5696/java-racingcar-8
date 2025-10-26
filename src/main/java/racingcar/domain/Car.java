package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.Optional;

public class Car {
    private final String carName;
    private int forwardCount;

    public Car(String inputName) {
        carName = inputName;
        forwardCount = 0;
    }

    public void goOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            forwardCount++;
        }
    }

    public Optional<String> announceIfWinner(int maxDistance) {
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
        return carName + " : " + "-".repeat(forwardCount);
    }

}
