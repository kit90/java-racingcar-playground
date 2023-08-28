package racingFeedback;

public class RacingGame {
    private final Round round;

    public RacingGame(String number) {
        this.round = new Round(number);
    }
}
