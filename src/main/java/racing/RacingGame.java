package racing;

public class RacingGame {
    private Cars cars;
    private Rounds rounds;

    private RacingGame(Cars cars, Rounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public static RacingGame makeGame(String carNames, String inputRounds) {
        Cars cars = Cars.makeCarsByNames(carNames);
        Rounds rounds = Rounds.of(inputRounds);
        return new RacingGame(cars, rounds);
    }

    public static RacingGame makeGame(Cars cars, String inputRounds) {
        Rounds rounds = Rounds.of(inputRounds);
        return new RacingGame(cars, rounds);
    }

    private static int getTotalRound(String inputRounds) {
        return Integer.parseInt(inputRounds);
    }

    public Cars getCars() {
        return cars;
    }
    public Rounds getRounds() {
        return rounds;
    }
}
