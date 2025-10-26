package racingcar.view;


import racingcar.domain.Cars;
import racingcar.domain.RacingGame;

public class OutputView {

    public static void outputRacingResult(RacingGame racingGame) {
        System.out.println("실행 결과");
        racingGame.raceResultPrint();
    }

    public static void outputWinner(RacingGame racingGame, Cars cars) {
        racingGame.printWinners(cars);
    }

}
