package racingcar;

import java.util.List;
import racingcar.controller.RacingController;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

/**
 * 클래스 이름: RacingGameManager
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-22
 */
public class RacingGameManager {
    private final InputView inputView;
    private final RacingController racingController;
    private final OutputView outputView;

    public RacingGameManager(InputView inputView,
                             RacingController racingController,
                             OutputView outputView
    ) {
        this.inputView = inputView;
        this.racingController = racingController;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = prepareCars();
        int attemptCount = inputView.readAttemptCount();
        outputView.printRacingStart();
        playRacing(cars, attemptCount);
        List<Car> winners = cars.findWinners();
        outputView.printWinners(winners);
    }

    private Cars prepareCars() {
        List<String> parseCarName = inputView.readAndParseCarNames();
        Cars cars = new Cars(parseCarName);
        return cars;
    }

    private void playRacing(Cars cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            racingController.race(cars);
            outputView.printRoundResult(cars);
        }
    }
}
