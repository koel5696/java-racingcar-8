package racingcar.view;


import static racingcar.constants.GameGuideMessage.PRINT_GAME_RESULT_MESSAGE;

import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class OutputView {

    public static void outputRacingResult(RacingGame racingGame) {
        System.out.println(PRINT_GAME_RESULT_MESSAGE.getMessage());
        racingGame.raceResultPrint();
    }

    public static void outputWinner(RacingGame racingGame, Cars cars) {
        racingGame.WinnersPrint(cars);
    }

}
