package racing;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @Test
    void create_car_by_name() {
        Car car = Car.makeCarByName("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

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
}
