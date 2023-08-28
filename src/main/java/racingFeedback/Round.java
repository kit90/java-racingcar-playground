package racingFeedback;

import org.apache.commons.lang3.StringUtils;

public class Round {
    public static final int MAX_ROUND_NUM = 10;
    public static final int MIN_ROUND_NUM = 10;
    private final int roundNum;

    public Round(String number) {
        validateRoundNumber(number);
        this.roundNum =  Integer.parseInt(number);
    }

    private static void validateRoundNumber(String number) {
        if(StringUtils.isBlank(number)) {
            throw new RuntimeException("라운드는 비어있을 수 없습니다");
        }
        int roundNum = Integer.parseInt(number);
        if(roundNum < 0 || roundNum > MAX_ROUND_NUM) {
            String sizeErrorMsg = String.format("자동차 이름은 %d회~%d회여야합니다.", MIN_ROUND_NUM, MAX_ROUND_NUM);
            throw new RuntimeException(sizeErrorMsg);
        }
    }
}
