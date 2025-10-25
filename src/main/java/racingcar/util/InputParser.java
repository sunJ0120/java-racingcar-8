package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 클래스 이름: InputParser
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-24
 */
public class InputParser {
    private static final String CAR_NAME_DELIMITER = ",";

    public List<String> parseCarName(String inputText) {
        List<String> parseCarNames = Arrays.stream(inputText.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        validate(parseCarNames);
        return parseCarNames;
    }

    private void validate(List<String> carNames) {
        validateListNotEmpty(carNames);
        validateEachCarName(carNames);
        validateDuplicateNames(carNames);
    }

    private void validateListNotEmpty(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("차 이름을 입력해주세요");
        }
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> checkNames = new HashSet<>();
        for (String carName : carNames) {
            if (!checkNames.add(carName)) {
                throw new IllegalArgumentException("이름이 중복됩니다. : " + carName);
            }
        }
    }

    private void validateEachCarName(List<String> carNames) {
        for (String carName : carNames) {
            validateCarNameIsEmpty(carName);
            validateCarNameLength(carName);
        }
    }

    private void validateCarNameIsEmpty(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException("차 이름은 공백일 수 없습니다.");
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("차 이름은 5자보다 길 수 없습니다.");
        }
    }
}
