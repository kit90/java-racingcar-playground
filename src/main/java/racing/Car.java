package racing;

public class Car {
    public static final int FORWARD_SPEED = 4;
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int speed;

    private Car(String name) {
        this.name = name;
    }

    public static Car makeCarByName(String name) {
        validateNameLength(name);
        return new Car(name);
    }

    private static void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            throw  new RuntimeException("자동차 이름은 "+MAX_NAME_LENGTH+"자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public void resetSpeed(int speed) {
        this.speed = (int) (Math.random() * 10);
    }

    public boolean isForwardSpeedOrMore() {
        return this.speed >= FORWARD_SPEED;
    }
}
