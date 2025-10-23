package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 클래스 이름: Cars
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-23
 */
public class Cars {
    private static List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveAllCars(RandomGenerator randomGenerator) {
        for (Car car : cars) {
            int number = randomGenerator.getRandomNumber();
            if (number >= 4) {
                car.move();
            }
        }
    }
}
