package battleShips.elements;


public class Ship {
    private int id;
    private Direction direction = Direction.HORIZONTAL;
    private int size;

    public Ship(int id) {
        this.id = id;
        switch (id) {
            case 0 -> this.size = 5;
            case 1 -> this.size = 4;
            case 2, 3 -> this.size = 3;
            case 4 -> this.size = 2;
        }
    }

    public void rotate() {
        if (direction == Direction.HORIZONTAL)
            direction = Direction.VERTICAL;
        else
            direction = Direction.HORIZONTAL;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getSize() {
        return size;
    }
}

