package lab01;

public class Vector {

    private Point root;
    private WSDirection direction;
    private int size;

    Vector(Point root, WSDirection direction, int size) {
        this.root = root;
        this.direction = direction;
        this.size = size;
    }
}