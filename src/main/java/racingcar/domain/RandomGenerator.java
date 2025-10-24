package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

/**
 * 클래스 이름: RandomGenerator
 * <p>
 * 버전 정보: 1.0
 * <p>
 * 날짜: 2025-10-22
 */
public class RandomGenerator {
    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
