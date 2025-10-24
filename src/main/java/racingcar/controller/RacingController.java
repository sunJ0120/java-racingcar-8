package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RandomGenerator;

/**
 * 클래스 이름: RacingController
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-22
 */
public class RacingController {
    private final RandomGenerator randomGenerator;

    public RacingController(RandomGenerator randomGenerator) {
        this.randomGenerator = randomGenerator;

    }

    public void race(Cars cars) {
        cars.moveAllCars(randomGenerator);
    }
}
