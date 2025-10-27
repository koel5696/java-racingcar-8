package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MAX_DISTANCE = 5;
    private static final int MOVING_FORWARD = 4;

    @Test
    void 전진_횟수_증가_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("benz");
            car.goOrStop();
            assertThat(car.toString()).isEqualTo("benz : -");
        }, MOVING_FORWARD);
    }

    @Test
    void 우승자_확인_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Car car = new Car("benz");

            for (int i = 0; i < MAX_DISTANCE; i++) {
                car.goOrStop();
            }

            Optional<String> winner = car.saveWinners(MAX_DISTANCE);

            assertThat(winner).hasValue("benz");
        }, MOVING_FORWARD);
    }

}
