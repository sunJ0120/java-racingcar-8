package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.RandomGenerator;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputParser inputParser = new InputParser();
        InputView inputView = new InputView(inputParser);
        RandomGenerator randomGenerator = new RandomGenerator();
        RacingController racingController = new RacingController(randomGenerator);
        OutputView outputView = new OutputView();

        RacingGameManager racingGameManager = new RacingGameManager(inputView, racingController, outputView);
        racingGameManager.run();
    }
}
