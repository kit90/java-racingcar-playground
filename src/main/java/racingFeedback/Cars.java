package racingFeedback;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private Cars(String names) {
        String[] split = names.split(",");
        List<Car> tempCars = new ArrayList<>();
        for (String name : split) {
            tempCars.add(new Car(name.trim()));
        }
        this.cars = tempCars;
    }

    public static Cars makeCarsByNames(String names) {
       return new Cars(names);
    }

    public List<Car> getWinners() {
       return findWinners(getMaxPosition());
    }

    public List<Car> findWinners(Position maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if(car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.getMaxPosition(maxPosition);
        }
        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }
}
