package racing;

public class Car {
    private final String name;
    private int speed;

    private Car(String name) {
        this.name = name;
    }

    public static Car makeCarByName(String name) {
        return new Car(name);
    }

    public String getName() {
        return name;
    }

    public void resetSpeed(int speed) {
        this.speed = (int) (Math.random() * 10);
    }
}
