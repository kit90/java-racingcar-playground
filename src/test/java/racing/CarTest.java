package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {
    @DisplayName("입력한_자동차_이름으로_car_생성하고_이름이_맞는지")
    @Test
    void create_car_by_name() {
        Car car = Car.makeCarByName("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }


    @DisplayName("자동차_이름은_5자를_초과하면_예외_발생")
    @Test
    void car_name_length() {
        String errMsg = String.format("자동차 이름은 %d자를 초과할 수 없습니다.", Car.MAX_NAME_LENGTH);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    Car.makeCarByName("pobipo");
                }).withMessageMatching(errMsg);
    }

    @DisplayName("자동차_속도는_0~9_사이_벗어나면_예외_발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 10})
    void car_speed_range(int speed) {
        Car car = Car.makeCarByName("pobi");

        String errMsg = String.format("자동차 속도는 %d~%d사이여야합니다.", CarSpeed.MIN_SPEED, CarSpeed.MAX_SPEED);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    car.setCarSpeed(speed);
                }).withMessageMatching(errMsg);
    }

    @DisplayName("속도가_4이상일_때_1전진")
    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "3:0", "2:0"}, delimiter = ':')
    void forward(int speed, int expected) {
        //given
        Car car = Car.makeCarByName("pobi");
        car.setCarSpeed(speed);
        //when
        car.forwardCar();
        //then
        assertThat(car.getForwardCount()).isEqualTo(expected);
    }
}
