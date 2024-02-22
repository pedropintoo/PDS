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

    @Override
    public String toString() {
        return "Vector [root=" + root + ", direction=" + direction + ", size=" + size + "]";
    }

    public Point getRoot() {
        return root;
    }

    public WSDirection getDirection() {
        return direction;
    }

    public int getSize() {
        return size;
    }
    
}