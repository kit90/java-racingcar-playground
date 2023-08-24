package racing;

import java.util.Scanner;

public class RunGame {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String carNames = getCarNames();
        Cars cars = Cars.makeCarsByNames(carNames);
        String inputRounds = getInputRounds();
        RacingGame game = RacingGame.makeGame(cars, inputRounds);
        Rounds rounds = game.getRounds();
        RaceResultView view = null;

        System.out.println("실행결과");
        while (rounds.hasRemainingRound()) {
            game.play();
            view = RaceResultView.makeView(game);
            view.printRoundResult();
        }
        view.printWinner();
    }

    private static String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    private static String getInputRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return scanner.nextLine();
    }
}
