package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class CarsTest {
    @DisplayName("입력한_자동차_이름들로_cars_생성하고_이름들이_맞는지")
    @Test
    void create_cars_by_names(){
        //given
        Cars cars = Cars.makeCarsByNames("pobi,crong,honux");
        //when
        List<String> nameList =  cars.getRacingCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        //then
        assertThat(nameList).contains("pobi", "crong", "honux");
    }

    @DisplayName("자동차_이름은_5자를_초과하면_예외_발생")
    @Test
    void cars_names_length() {
        String errMsg = String.format("자동차 이름은 %d자를 초과할 수 없습니다.", Car.MAX_NAME_LENGTH);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    Cars.makeCarsByNames("pobi, pobicrong");
                }).withMessageMatching(errMsg);
    }

    @DisplayName("자동차_이름은_중복될_수_없다")
    @Test
    void cars_names_duplication() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    Cars.makeCarsByNames("pobi, pobi");
                }).withMessageMatching("중복된 자동차 이름은 입력할 수 없습니다.");
    }

    @DisplayName("자동차_속도는_0~9_사이_벗어나면_예외_발생")
    @ParameterizedTest
    @MethodSource("speedRangeArgs")
    void cars_speeds_range(List<Integer> integers) {
        Cars cars = Cars.makeCarsByNames("pobi,crong,honux");

        String errMsg = String.format("자동차 속도는 %d~%d사이여야합니다.", CarSpeed.MIN_SPEED, CarSpeed.MAX_SPEED);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    cars.forwardBySpeeds(integers);
                }).withMessageMatching(errMsg);
    }

    static Stream<Arguments> speedRangeArgs() {
        return Stream.of(
                Arguments.arguments(Arrays.asList(-1, 2, 3)),
                Arguments.arguments(Arrays.asList(1, -1, 3)),
                Arguments.arguments(Arrays.asList(2, 0, -1)),
                Arguments.arguments(Arrays.asList(-1, -1, -1)),
                Arguments.arguments(Arrays.asList(10, 9, 5)),
                Arguments.arguments(Arrays.asList(9, 10, 5)),
                Arguments.arguments(Arrays.asList(0, 9, 10))
        );
    }

    @DisplayName("속도가_4이상일_때_1전진")
    @Test
    void forward() {
        //given
        Cars cars = Cars.makeCarsByNames("pobi,crong,honux");
        cars.forwardBySpeeds(Arrays.asList(5, 4, 3));
        //when
        List<Car> racingCars = cars.getRacingCars();
        //then
        assertAll("speed 4 or more is 1 forward",
                () -> assertThat(racingCars.get(0).getForwardCount()).isEqualTo(1),
                () -> assertThat(racingCars.get(1).getForwardCount()).isEqualTo(1),
                () -> assertThat(racingCars.get(2).getForwardCount()).isEqualTo(0)
        );
    }

    @DisplayName("최대_전진수를_지닌_자동차")
    @Test
    void winners() {
        //given
        Cars cars = Cars.makeCarsByNames("pobi,crong,honux");
        //when
        cars.forwardBySpeeds(Arrays.asList(5, 4, 3));
        cars.forwardBySpeeds(Arrays.asList(4, 5, 3));
        //then
        List<Car> winners = cars.getWinnerCars();
        List<String> names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        assertThat(names).contains("pobi","crong");
    }
}
