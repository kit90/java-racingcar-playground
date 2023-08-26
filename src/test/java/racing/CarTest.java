package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("pobi");
    }

    @DisplayName("입력한_자동차_이름으로_car_생성하고_이름이_맞는지")
    @Test
    void car_name() {
        assertThat(car.getName()).isEqualTo(new Name("pobi"));
    }

    @DisplayName("자동차_이름이_없거나_5자를_초과하면_예외_발생")
    @ParameterizedTest
    @MethodSource("nameSizeArgs")
    void car_name_length(String name, String errMsg) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    new Car(name);
                }).withMessageMatching(errMsg);
    }

     static Stream<Arguments> nameSizeArgs() {
        String blankErrMsg = "자동차 이름은 비어있을 수 없습니다.";
        String overMaxErrMsg = String.format("자동차 이름은 %d자 이하여야합니다.", Name.MAX_NAME_LENGTH);
        return Stream.of(
                Arguments.arguments("p".repeat(Name.MAX_NAME_LENGTH+1), overMaxErrMsg),
                Arguments.arguments(null,  blankErrMsg),
                Arguments.arguments("",  blankErrMsg),
                Arguments.arguments(" ",  blankErrMsg)
        );
    }

    @DisplayName("자동차_최초_생성시에_position이_0인지")
    @Test
    void car_position() {
        assertThat(car.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    void car_move() {
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}
