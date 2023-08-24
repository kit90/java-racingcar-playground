package racing;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final Cars cars;
    private final Rounds rounds;

    private RacingGame(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

/*    public static RacingGame makeGame(String carNames, String inputRounds) {
        Cars cars = Cars.makeCarsByNames(carNames);
        Rounds rounds = Rounds.of(inputRounds);
        return new RacingGame(cars, rounds);
    }*/

    public static RacingGame makeGame(Cars cars, String inputRounds) {
        Rounds rounds = Rounds.of(inputRounds);
        return new RacingGame(cars, rounds);
    }

    private static int getTotalRound(String inputRounds) {
        return Integer.parseInt(inputRounds);
    }

    public void play() {
        rounds.minusRound();
        List<Integer> speeds = SpeedGenerator.generateSpeeds(cars.getRacingCars().size());
        cars.setRacingCarsSpeed(speeds);
        cars.forwardRacingCars();
    }

    public List<String> getWinnerNames() {
        return cars.getMaxForwardCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public Cars getCars() {
        return cars;
    }
    public Rounds getRounds() {
        return rounds;
    }
}
