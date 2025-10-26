package racingcar.domain;

import static racingcar.constants.Regex.NAME_SPLIT;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String inputName) {
        this.cars = Arrays.stream(inputName.split(NAME_SPLIT.getRegex()))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(Car::goOrStop);
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .map(car -> car.announceIfWinner(maxDistance))
                .flatMap(Optional::stream)
                .toList();
    }

    public List<String> toStringAll() {
        return cars.stream()
                .map(Car::toString)
                .toList();
    }

    private int findMaxDistance() {
        int max = 0;
        for (Car car : cars) {
            max = car.compareToMaxDistance(max);
        }
        return max;
    }

}
