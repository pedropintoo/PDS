/*
 * Created on Mon Feb 26 2024
 *
 * Copyright (c) 2024 - Pedro Pinto (pmap@ua.pt) ; Guilherme Santos (gui.santos91@ua.pt)
 */
package utils;

public class Vector {

    private Point root;
    private WSDirection direction;
    private int size;

    public Vector(Point root, WSDirection direction, int size) {
        this.root = root;
        this.direction = direction;
        this.size = size;
    }

    @Override
    public String toString() {
        return size + " " + root + " " + direction;
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