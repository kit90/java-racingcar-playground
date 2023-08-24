package racing;

public class Rounds {
    public static final int MAX_ROUND = 10;
    public static final int MIN_ROUND = 1;
    private final int totalRounds;
    private int remainingRounds;

    public static Rounds of(String inputRounds) {
        return new Rounds(inputRounds);
    }

    private Rounds(String inputRounds){
        int totalRounds = parseTotalRounds(inputRounds);
        validateTotalRoundsSize(totalRounds);
        this.totalRounds = totalRounds;
        this.remainingRounds = totalRounds;
    }

    private int parseTotalRounds (String inputRounds) {
        return Integer.parseInt(inputRounds);
    }

    private void validateTotalRoundsSize (int totalRounds) {
        if(totalRounds < MIN_ROUND || totalRounds > MAX_ROUND) {
            String sizeErrorMsg = String.format("라운드 횟수는 %d~%d회만 가능합니다.", MIN_ROUND, MAX_ROUND);
            throw new RuntimeException(sizeErrorMsg);
        }
    }

    public void minusRound(){
        remainingRounds -= 1;
    }

    public boolean hasRemainingRound() {
        return remainingRounds > 0;
    }

    public int getRemainingRounds() {
        return remainingRounds;
    }
    public int getTotalRounds() {
        return totalRounds;
    }
}