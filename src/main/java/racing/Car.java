package racing;

public class Car {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private CarSpeed carSpeed;
    private int forwardCount;

    private Car(String name, CarSpeed carSpeed) {
        this.name = name;
        this.carSpeed = carSpeed;
    }

    public static Car makeCarByName(String name) {
        validateNameLength(name);
        return new Car(name, new CarSpeed(0));
    }

    private static void validateNameLength(String name) {
        if(name.length() > MAX_NAME_LENGTH) {
            String sizeErrorMsg = String.format("자동차 이름은 %d자를 초과할 수 없습니다.", MAX_NAME_LENGTH);
            throw  new RuntimeException(sizeErrorMsg);
        }
    }

    public void setCarSpeed(int carSpeed) {
        this.carSpeed.setSpeed(carSpeed);
    }

    public void forward() {
        if(carSpeed.isForwardSpeedOrMore()) {
            forwardCount += 1;
        }
    }

    public boolean equalsName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }
    public int getForwardCount() {
        return forwardCount;
    }
    public CarSpeed getCarSpeed() {
        return carSpeed;
    }
}
