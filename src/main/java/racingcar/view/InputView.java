package racingcar.view;

import static racingcar.constants.GameGuideMessage.PRINT_NAME_GUIDE_MESSAGE;
import static racingcar.constants.GameGuideMessage.PRINT_ROUND_GUIDE_MESSAGE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String nameInput() {
        System.out.println(PRINT_NAME_GUIDE_MESSAGE.getMessage());
        return Console.readLine();
    }

    public static String roundInput() {
        System.out.println(PRINT_ROUND_GUIDE_MESSAGE.getMessage());
        return Console.readLine();
    }
}
