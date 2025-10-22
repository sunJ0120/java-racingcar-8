package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 클래스 이름: InputView
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-22
 */
public class InputView {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public String readCarName() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    public String readAttemptCount() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
        return Console.readLine();
    }
}
