package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {
    private Cars cars;

    @BeforeEach
    void gameSetting() {
        String carNames = "pobi,crong,honux";
        cars = Cars.makeCarsByNames(carNames);
    }

    @Test
    void make_game_by_input_value_test() {
        String carNames = "pobi,crong,honux";
        String inputRounds = "5";
        RacingGame game = RacingGame.makeGame(carNames, inputRounds);
        List<String> nameList =  game.getCars().getCarList()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        Rounds rounds = game.getRounds();
        //then
        assertAll("make racing game test",
                () -> assertThat(nameList).contains("pobi", "crong", "honux"),
                () -> assertThat(rounds.getTotalRounds()).isEqualTo(5)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "11"})
    @DisplayName("라운드_1~10회가_아닐시_예외_발생")
    void rounds_size_test(String inputRounds) {
        String errMsg = String.format("라운드 횟수는 %d~%d회만 가능합니다.", Rounds.MIN_ROUND, Rounds.MAX_ROUND);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    RacingGame.makeGame(cars, inputRounds);
                }).withMessageMatching(errMsg);
    }
}
