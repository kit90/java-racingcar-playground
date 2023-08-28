package racingFeedback;

import java.util.Random;

public class RandomMovingStrategy implements MovingStrategy{
    private final static int MAX_BOUND = 10;
    public final static int FORWARD_NUM = 4;

    @Override
    public boolean movable() {
        return getRandomSpeed() >= FORWARD_NUM;
    }

    private int getRandomSpeed() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }
}
