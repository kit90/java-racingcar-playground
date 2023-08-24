package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @DisplayName("입력한_자동차_이름들로_cars_생성하고_이름들이_맞는지")
    @Test
    void create_cars_by_names(){
        //given
        Cars cars = Cars.makeCarsByNames("pobi,crong,honux");
        //when
        List<String> nameList =  cars.getCarList()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        //then
        assertThat(nameList).contains("pobi", "crong", "honux");
    }

    @DisplayName("자동차_이름은_5자를_초과하면_예외_발생")
    @Test
    void car_name_length() {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(()->{
                    Car.makeCarByName("pobipo");
                }).withMessageMatching("자동차 이름은 "+Car.MAX_NAME_LENGTH+"자를 초과할 수 없습니다.");
    }
}
