package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.service.NameValidService;
import racingcar.service.RoundValidService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final NameValidService nameValidService = new NameValidService();
    private final RoundValidService roundValidService = new RoundValidService();

    public void run() {
        String word = InputView.nameInput();
        List<String> validNames = nameValidService.nameInputValid(word);
        Cars cars = new Cars(validNames);

        int round = roundValidService.roundInputValid(InputView.roundInput());
        RacingGame racingGame = new RacingGame(cars);
        racingGame.startRace(round);
        OutputView.outputRacingResult(racingGame);
        OutputView.outputWinner(racingGame, cars);
    }
}