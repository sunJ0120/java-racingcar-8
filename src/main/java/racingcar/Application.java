package racingcar;

import racingcar.controller.RacingController;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputParser inputParser = new InputParser();
        InputView inputView = new InputView(inputParser);
        RacingController racingController = new RacingController();
        OutputView outputView = new OutputView();
        RacingGameManager racingGameManager = new RacingGameManager(inputView, racingController, outputView);
        racingGameManager.run();
    }
}
