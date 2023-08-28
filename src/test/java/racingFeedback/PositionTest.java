package racingFeedback;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PositionTest {
    @DisplayName("position은_음수일_때_예외_발생")
    @Test
    void not_negative() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    new Position(-1);
                }).withMessageMatching("position은 음수일 수 없습니다.");
    }
}
