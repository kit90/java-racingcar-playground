package racingFeedback;

import java.util.Objects;

public class Car{
    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    //for test
    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void move(MovingStrategy movingStrategy) {
        if(movingStrategy.movable()) {
            position = position.move();
        }
    }

    public Position getMaxPosition(Position position) {
        if(this.position.moreThan(position)) {
            return this.position;
        }
        return position;
    }

    public boolean isWinner(Position maxPosition) {
       return position.equals(maxPosition);
    }

    public Name getName() {
        return name;
    }
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
