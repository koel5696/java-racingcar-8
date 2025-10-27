package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MAX_DISTANCE = 5;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_횟수_증가_테스트() {
        Car car = new Car("benz");
        for (int i = 0; i < 5; i++) {
            car.goOrStop(MOVING_FORWARD);
        }
        assertThat(car.toString()).isEqualTo("benz : -----");

    }

    @Test
    void 멈춤_테스트() {
        Car car = new Car("benz");
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                car.goOrStop(STOP);
                continue;
            }
            car.goOrStop(MOVING_FORWARD);
        }
        assertThat(car.toString()).isEqualTo("benz : ----");

    }

    @Test
    void 우승자_목록_최종_저장_테스트() {
        Car car = new Car("benz");

        for (int i = 0; i < MAX_DISTANCE; i++) {
            car.goOrStop(MOVING_FORWARD);
        }

        Optional<String> winner = car.saveWinner(MAX_DISTANCE);
        assertThat(winner).hasValue("benz");

    }
}
