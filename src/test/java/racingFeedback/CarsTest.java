package racingFeedback;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private Cars actualCars;

    @BeforeEach
    void actualCars() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car popo = new Car("popo");
        actualCars = new Cars(Arrays.asList(pobi, crong, popo));
    }

    @Test
    void makeCars() {
        Cars cars = Cars.makeCarsByNames("pobi, crong, popo");
        assertThat(cars.equals(actualCars)).isTrue();
    }

    @Test
    void winner() {
        Car pobi = new Car("pobi", 4);
        Car crong = new Car("crong", 4);

        assertThat(actualCars.getWinners()).containsExactly(pobi, crong);
    }
}
