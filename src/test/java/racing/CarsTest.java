package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    void winner() {
        Car pobi = new Car("pobi", 4);
        Car crong = new Car("crong", 4);
        Car popo = new Car("popo", 3);
        Cars cars = new Cars(Arrays.asList(pobi, crong, popo));

        assertThat(cars.getWinners()).containsExactly(pobi, crong);
    }
}
