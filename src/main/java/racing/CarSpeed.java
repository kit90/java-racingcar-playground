package racing;

public class CarSpeed {
    public static final int MIN_SPEED = 0;
    public static final int MAX_SPEED = 9;
    public static final int FORWARD_SPEED = 4;
    private int speed;

    public CarSpeed(int speed) {
        this.speed = speed;
    }

    void setSpeed(int speed) {
        validateSpeedRange(speed);
        this.speed = speed;
    }

   static void validateSpeedRange(int speed) {
        if(speed > 9 || speed < 0) {
            throw new RuntimeException(String.format("자동차 속도는 %d~%d사이여야합니다.", MIN_SPEED, MAX_SPEED));
        }
    }

    boolean isForwardSpeedOrMore() {
        return this.speed >= FORWARD_SPEED;
    }

}
