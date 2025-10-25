package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 클래스 이름: Cars
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-23
 */
public class Cars implements Iterable<Car> {
    private final List<Car> cars = new ArrayList<>();

    public Cars(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public void moveAllCars() {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (number >= 4) {
                car.move();
            }
        }
    }

    public List<Car> findWinners() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    @Override
    public Iterator<Car> iterator() {
        return cars.iterator();
    }
}
