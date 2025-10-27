package racingcar.domain;

import static racingcar.constants.GameGuideMessage.PRINT_GAME_WINNERS_MESSAGE;
import static racingcar.constants.Regex.WINNERS_NAME_SPLIT;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final List<List<String>> raceHistory = new ArrayList<>();

    public RacingGame(Cars cars) {
        this.cars = cars;
    }

    public void startRace(int round) {
        for (int i = 0; i < round; i++) {
            cars.moveCars();
            raceHistory.add(cars.toStringCarsList());
        }
    }

    public void raceResultPrint() {
        for (List<String> round : raceHistory) {
            round.forEach(System.out::println);
            System.out.println();
        }
    }

    public void WinnersPrint(Cars cars) {
        List<String> winners = cars.findWinners();
        String result = String.join(WINNERS_NAME_SPLIT.getRegex(), winners);
        System.out.println(PRINT_GAME_WINNERS_MESSAGE.getMessage() + result);
    }


}

