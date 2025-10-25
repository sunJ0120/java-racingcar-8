package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

/**
 * 클래스 이름: InputParserTest
 * <p>
 * 버전 정보:
 * <p>
 * 날짜: 2025-10-25
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputParserTest {
    private String inputMessage;
    private InputParser inputParser;

    @BeforeEach
    public void 준비() {
        inputParser = new InputParser();
    }

    @Test
    void 정상_파싱_테스트() {
        //given
        inputMessage = "아현,라미,아사,치키타,로라,파리타,루카";
        //when
        List<String> carNames = inputParser.parseCarName(inputMessage);
        //then
        assertSimpleTest(() -> {
            assertEquals(7, carNames.size());
        });
    }

    @Test
    void 아무것도_입력_안하면_예외() {
        //given
        inputMessage = "";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백");
        });
    }

    @Test
    void 공백_입력하면_예외() {
        //given
        inputMessage = "       ";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백");
        });
    }

    @Test
    void 입력_없으면_예외() {
        //given
        inputMessage = ",,,,,,,";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("차 이름을 입력해주세요");
        });
    }

    @Test
    void 공백_일경우_예외() {
        //given
        inputMessage = "    ,  ,  ,    , ,  ,  ,";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백");
        });
    }

    @Test
    void 공백이_섞여있을_경우_예외() {
        //given
        inputMessage = "아현,라미,,    , ,  ,로라,아사";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("공백");
        });
    }

    @Test
    void 중복_예외() {
        //given
        inputMessage = "아현,라미,로라,아현,파리타,라미";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("중복");
        });
    }

    @Test
    void 이름이_5자_초과면_예외() {
        //given
        inputMessage = "아현아현아현";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("차 이름은 5자보다 길 수 없습니다.");
        });
    }

    @Test
    void 여러_이름_중_하나가_5자_초과면_예외() {
        //given
        inputMessage = "아현,라미,우테코프리코스아자아자,파리타";
        //when & then
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> inputParser.parseCarName(inputMessage))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("차 이름은 5자보다 길 수 없습니다.");
        });
    }

    @Test
    void 이름이_5자면_통과() {
        //given
        inputMessage = "@@@@@,*****";
        //when
        List<String> carNames = inputParser.parseCarName(inputMessage);
        //then
        assertSimpleTest(() -> {
            assertEquals(2, carNames.size());
        });
    }

    @Test
    void 앞뒤_공백_제거() {
        //given
        inputMessage = "   블랙핑크    ,    엔믹스     ,    뉴진스     ";
        //when
        List<String> carNames = inputParser.parseCarName(inputMessage);
        //then
        assertSimpleTest(() -> {
            assertEquals("블랙핑크", carNames.get(0));
            assertEquals("엔믹스", carNames.get(1));
            assertEquals("뉴진스", carNames.get(2));
        });
    }
}