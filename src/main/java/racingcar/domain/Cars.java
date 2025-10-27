package racingcar.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.util.CreateRandomNumber;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> cars) {
        this.cars = cars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveCars() {
        cars.forEach(car -> car.goOrStop(CreateRandomNumber.createRandomNumber()));
    }

    public List<String> findWinners() {
        int maxDistance = findMaxDistance();
        return cars.stream()
                .map(car -> car.saveWinner(maxDistance))
                .flatMap(Optional::stream)
                .toList();
    }

    public List<String> toStringCarsList() {
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
