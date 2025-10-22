package racingcar.domain;

/**
 * 클래스 이름: Car
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-22
 */
public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        position++;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
