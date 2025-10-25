package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * 클래스 이름: CarsTest
 * <p>
 * 버전 정보:
 * <p>
 * 날짜: 2025-10-25
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarsTest {
    private Cars cars;

    @BeforeEach
    public void 준비() {
        String[] carNamesList = {"아현", "라미", "아사", "치키타", "로라", "파리타", "루카"};
        List<String> carNames = new ArrayList<>(
                List.of(carNamesList)
        );
        cars = new Cars(carNames);
    }

    @Test
    void 값이_4보다_작으면_모든차가_움직이지_않는다() {
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAllCars();
                    for (Car car : cars) {
                        assertEquals(car.getPosition(), 0);
                    }
                },
                3, 2, 1, 3, 3, 2, 1
        );
    }

    @Test
    void 값이_4보다_크면_모든차가_움직인다() {
        //then
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAllCars();
                    for (Car car : cars) {
                        assertEquals(car.getPosition(), 1);
                    }
                },
                4, 4, 5, 5, 9, 9, 8
        );
    }

    @Test
    void 가장_많이_이동한_차가_우승자다() {
        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAllCars();    // 아현만 전진
                    List<Car> winners = cars.findWinners();

                    assertSimpleTest(() -> {
                        assertEquals("아현", winners.get(0).getName());    // expected, actual 순서
                    });
                },
                4, 1, 1, 1, 2, 2, 3
        );
    }

    @Test
    void 우승자가_한_명_이상() {
        // when & then
        assertRandomNumberInRangeTest(
                () -> {
                    cars.moveAllCars();    // 3명만 전진
                    List<Car> winners = cars.findWinners();
                    assertSimpleTest(() -> {
                        assertEquals(3, winners.size());
                    });
                },
                1, 1, 4, 9, 2, 2, 5
        );
    }
}