package racingcar.service;

import static racingcar.constants.NameInputException.NAME_EMPTY_ERROR;
import static racingcar.constants.NameInputException.NAME_FORMAT_FORMAT_ERROR;
import static racingcar.constants.NameInputException.NAME_INPUT_EMPTY_ERROR;
import static racingcar.constants.NameInputException.NAME_LENGTH_ERROR;
import static racingcar.constants.NameInputException.NAME_UNIQUE_ERROR;
import static racingcar.constants.NameInputException.UNDERSTAFFED_ERROR;
import static racingcar.constants.Regex.NAME_INPUT;
import static racingcar.constants.Regex.NAME_SPLIT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NameValidService {
    private final static int MINIMUM_NUMBER_OF_PARTICIPANTS = 2;
    private final static int MAXIMUM_NAME_LENGTH = 5;

    public void nameInputValid(String inputName) {
        inputNameEmptyValid(inputName);
        String[] names = splitNameValid(inputName);
        numberParticipantsValid(names);
        for (String name : names) {
            nameEmptyValid(name);
            inputFormatValid(name);
            nameLengthValid(name);
        }
        sameNameValid(names);
    }

    private void inputNameEmptyValid(String inputName) {
        if (inputName.isBlank()) {
            throw new IllegalArgumentException(NAME_INPUT_EMPTY_ERROR.getMessage());
        }
    }

    private String[] splitNameValid(String inputName) {
        return inputName.split(NAME_SPLIT.getRegex(), -1);
    }

    private void numberParticipantsValid(String[] names) {
        if (names.length < MINIMUM_NUMBER_OF_PARTICIPANTS) {
            throw new IllegalArgumentException(UNDERSTAFFED_ERROR.getMessage());
        }
    }

    private void nameEmptyValid(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException(NAME_EMPTY_ERROR.getMessage());
        }
    }

    private void inputFormatValid(String name) {
        if (!name.matches(NAME_INPUT.getRegex())) {
            throw new IllegalArgumentException(NAME_FORMAT_FORMAT_ERROR.getMessage());
        }
    }

    private void nameLengthValid(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR.getMessage());
        }
    }

    private void sameNameValid(String[] names) {
        Set<String> uniqueNames = new HashSet<>(Arrays.asList(names));
        if (uniqueNames.size() != names.length) {
            throw new IllegalArgumentException(NAME_UNIQUE_ERROR.getMessage());
        }
    }
}
