package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Cars {
    private final List<Car> racingCars;

    public Cars(String names) {
        this.racingCars = makeCarList(names);
    }

    public static Cars makeCarsByNames(String names) {
        return new Cars(names);
    }

    private List<Car> makeCarList(String inputNames) {
        List<String> names = splitNames(inputNames);
        validateDuplication(names);
        return names.stream()
                .map(Car::makeCarByName)
                .collect(Collectors.toList());
    }

    private List<String> splitNames(String inputNames) {
        return Arrays.asList(inputNames.split(","));
    }

    private void validateDuplication(List<String> inputList) {
        boolean duplicated = inputList.stream()
                .distinct()
                .count() != inputList.size();
        if(duplicated) {
            throw new RuntimeException("중복된 자동차 이름은 입력할 수 없습니다.");
        }
    }

    public void setRacingCarsSpeed(List<Integer> speeds) {
        IntStream.range(0, racingCars.size())
                        .forEach(i -> {
                            Car car = racingCars.get(i);
                            car.setCarSpeed(speeds.get(i));
                        });
    }

    public void forwardRacingCars() {
        racingCars.stream().forEach(Car::forwardCar);
    }

    public List<Car> getMaxForwardCars() {
        int maxForwardCount = getMaxForwardCount();
        return racingCars.stream()
                .filter(car -> car.getForwardCount() == maxForwardCount)
                .collect(Collectors.toList());
    }

    private int getMaxForwardCount() {
        return racingCars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }

    public Car findByCarName(String name) {
        return racingCars.stream()
                .filter(car -> car.equalsName(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("이름에 해당하는 자동차가 없습니다."));
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }

}
