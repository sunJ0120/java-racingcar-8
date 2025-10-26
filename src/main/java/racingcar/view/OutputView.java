package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

/**
 * 클래스 이름: OutputView
 * <p>
 * 버전 정보: 1.1
 * <p>
 * 날짜: 2025-10-26
 */
public class OutputView {
    private static final String POSITION_ICON = "-";
    private static final String NAME_POSITION_DELIMITER = " : ";
    private static final String WINNER_DELIMITER = ", ";
    private static final String RESULT_HEADER = "실행 결과";
    private static final String WINNER_PREFIX = "최종 우승자 : %s";

    public void printRacingStart() {
        System.out.println();
        System.out.println(RESULT_HEADER);
    }

    public void printRoundResult(Cars cars) {
        for (Car car : cars) {
            printCarStatus(car);
        }
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.println(car.getName() + NAME_POSITION_DELIMITER +
                POSITION_ICON.repeat(car.getPosition()));
    }

    public void printWinners(List<Car> winners) {
        String names = formatWinnerNames(winners);
        System.out.println(String.format(WINNER_PREFIX, names));
    }

    private String formatWinnerNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
