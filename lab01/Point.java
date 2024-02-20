package lab01;

// Class to Support Puzzle
public class Point {

    // Only Positive coordinates
    private final int x;
    private final int y;
    private final int limit;

    Point(int x, int y, int limit) {
        this.x = x;
        this.y = y;
        this.limit = limit;
    }

    // Only for Debugging
    @Override
    public String toString() {
        return "Point [x=" + x + ", y=" + y + ", limit=" + limit + "]";
    }

    // Get the points (if valid) in a direction
    // Using this conditions:
    //      UP-CONDITION -> y <= 0
    //      RIGHT-CONDITION -> x >= limit-1
    //      DOWN-CONDITION -> y >= limit-1
    //      LEFT-CONDITION -> x <= 0
    public Point getPointInDirection(WSDirection direction) {
        Point point = null;
        
        switch (direction) {
            case UP: 
                if (y <= 0) break;                            // UP-CONDITION
                point =  new Point(x,(y-1)%limit,limit); break;         
            case RIGHT_UP: 
                if (y <= 0) break;                            // UP-CONDITION
                if (x >= limit-1) break;                      // RIGHT-CONDITION
                point = new Point((x+1)%limit,(y-1)%limit,limit); break;
            case RIGHT:
                if (x >= limit-1) break;                      // RIGHT-CONDITION
                point = new Point((x+1)%limit,y,limit); break;
            case RIGHT_DOWN:
                if (x >= limit-1) break;                      // RIGHT-CONDITION
                if (y >= limit-1) break;                      // DOWN-CONDITION 
                point = new Point((x+1)%limit,(y+1)%limit,limit); break;               
            case DOWN:
                if (y >= limit-1) break;                      // DOWN-CONDITION 
                point = new Point(x,(y+1)%limit,limit); break;  
            case LEFT_DOWN:
                if (x <= 0) break;                            // LEFT-CONDITION
                if (y >= limit-1) break;                      // DOWN-CONDITION     
                point = new Point((x-1)%limit,(y+1)%limit,limit); break;
            case LEFT:
                if (x <= 0) break;                            // LEFT-CONDITION
                point = new Point((x-1)%limit,y,limit); break;
            case LEFT_UP:
                if (x <= 0) break;                            // LEFT-CONDITION
                if (y <= 0) break;                            // UP-CONDITION
                point = new Point((x-1)%limit,(y-1)%limit,limit); break; 
        }

        return point;
    }

    // Getters

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    
}
