package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 클래스 이름: InputParser
 * <p>
 * 버전 정보: 1.1
 * <p>
 * 날짜: 2025-10-26
 */
public class InputParser {
    private static final String CAR_NAME_DELIMITER = ",";
    private static final String ERROR_EMPTY_CAR_NAMES = "차 이름을 입력해주세요.";
    private static final String ERROR_BLANK_CAR_NAME = "차 이름은 공백일 수 없습니다.";
    private static final String ERROR_CAR_NAME_TOO_LONG = "차 이름은 5자보다 길 수 없습니다.";
    private static final String ERROR_DUPLICATE_CAR_NAME = "이름이 중복됩니다. : %s";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public List<String> parseCarNames(String inputText) {
        List<String> carNames = Arrays.stream(inputText.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .toList();
        validate(carNames);
        return carNames;
    }

    private void validate(List<String> carNames) {
        validateListNotEmpty(carNames);
        validateEachCarName(carNames);
        validateDuplicateNames(carNames);
    }

    private void validateListNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_CAR_NAMES);
        }
    }

    private void validateEachCarName(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameNotBlank(carName);
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameNotBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_CAR_NAME);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG);
        }
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> checkNames = new HashSet<>();
        for (String carName : carNames) {
            if (!checkNames.add(carName)) {
                throw new IllegalArgumentException(
                        String.format(ERROR_DUPLICATE_CAR_NAME, carName)
                );
            }
        }
    }
}
