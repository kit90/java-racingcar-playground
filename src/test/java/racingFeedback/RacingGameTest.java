package racingFeedback;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RacingGameTest {
    @DisplayName("라운드_횟수를_입력_안했거나_1~10이_아니면_예외_발생")
    @ParameterizedTest
    @MethodSource("roundSizeArgs")
    void car_name_length(String roundNum, String errMsg) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    new Round(roundNum);
                }).withMessageMatching(errMsg);
    }

    static Stream<Arguments> roundSizeArgs() {
        String blankErrMsg = "라운드는 비어있을 수 없습니다";
        String sizeErrMsg = String.format("자동차 이름은 %d회~%d회여야합니다.",
                Round.MIN_ROUND_NUM, Round.MAX_ROUND_NUM);
        return Stream.of(
                Arguments.arguments("-1", sizeErrMsg),
                Arguments.arguments("0", sizeErrMsg),
                Arguments.arguments("11", sizeErrMsg),
                Arguments.arguments(null,  blankErrMsg),
                Arguments.arguments("",  blankErrMsg),
                Arguments.arguments(" ",  blankErrMsg)
        );
    }
}
