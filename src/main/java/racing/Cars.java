package racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(String names) {
        this.carList = makeCarList(names);
    }

    public static Cars makeCarsByNames(String names) {
        return new Cars(names);
    }

    private List<Car> makeCarList(String names) {
       return splitName(names).stream()
                .map(Car::makeCarByName)
                .collect(Collectors.toList());
    }

    private List<String> splitName(String names) {
        return Arrays.asList(names.split(","));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
