package racing;

import java.util.Objects;

public class Car{
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            position = position.move();
        }
    }

    public Name getName() {
        return name;
    }
    public Position getPosition() {
        return position;
    }
}
