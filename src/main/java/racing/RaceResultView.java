package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceResultView {
    private RacingGame game;

    public static RaceResultView makeView (RacingGame game) {
        return new RaceResultView(game);
    }

    private RaceResultView(RacingGame game) {
        this.game = game;
    }

    public void printRoundResult() {
        List<String> resultView = getRoundResultView();
        resultView.stream()
                .forEach(System.out::println);
        System.out.print("\n");
    }

    private List<String> getRoundResultView() {
        List<Car> racingCars = game.getCars().getRacingCars();
        List<String> results = new ArrayList<>();
        for (Car racingCar : racingCars) {
            String result = racingCar.getName() + ":";
            result += "-".repeat(racingCar.getForwardCount());
            results.add(result);
        }
        return results;
    }

    public void printWinner() {
        String winnerNamesView = getWinnerNamesView();
        System.out.println(winnerNamesView);
    }

    private String getWinnerNamesView() {
        List<String> winnerNames = game.getWinnerNames();
        String names = winnerNames.stream()
                .collect(Collectors.joining(", "));
        names += "가 최종 우승했습니다.";
        return names;
    }
}
