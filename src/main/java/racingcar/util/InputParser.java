package racingcar.util;

import java.util.Arrays;
import java.util.List;
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
        return Arrays.stream(inputText.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }
}
