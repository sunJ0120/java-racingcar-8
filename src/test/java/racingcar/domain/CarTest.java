package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * 클래스 이름: CarTest
 * <p>
 * 버전 정보:
 * <p>
 * 날짜: 2025-10-25
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {
    private Car car;

    @BeforeEach
    public void 준비() {
        String carName = "testCar";
        car = new Car(carName);
    }

    @Test
    void move시_위치_증가_테스트() {
        //given

        //when
        car.move();

        //then
        Assertions.assertEquals(car.getPosition(),1);
    }

    @Test
    void 위치_초기값_테스트() {
        //then
        Assertions.assertEquals(car.getPosition(),0);
    }

    @Test
    void 여러번_이동시_테스트() {
        //given

        //when
        car.move();
        car.move();
        car.move();

        //then
        Assertions.assertEquals(car.getPosition(),3);
    }
}