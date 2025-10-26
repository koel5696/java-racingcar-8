package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final int MAX_DISTANCE = 5;
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전체_자동차_전진_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = new Cars("benz,urus,ray");
            cars.moveCars();

            List<String> expected = Arrays.asList("benz : -", "urus : -", "ray : -");
            assertThat(cars.toStringAll()).isEqualTo(expected);
        }, MOVING_FORWARD);
    }

    @Test
    void 우승자_찾기_테스트() {
        assertRandomNumberInRangeTest(() -> {
            Cars cars = new Cars("benz,urus,ray");
            for (int i = 0; i < MAX_DISTANCE; i++) {
                cars.moveCars();
            }
            List<String> expected = Arrays.asList("benz", "ray");
            assertThat(cars.findWinners()).isEqualTo(expected);
        }, MOVING_FORWARD, STOP, MOVING_FORWARD);
    }
}
