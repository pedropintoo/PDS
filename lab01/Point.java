package lab01;

import java.util.ArrayList;

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

    // Function that returns the nearby points
    public ArrayList<Point> touchingPoints(){
        
        ArrayList<Point> nearbyPoints = new ArrayList<>();

        for (WSDirection direction : WSDirection.values()) {
            Point point = getPointInDirection(direction);
            if (point != null) nearbyPoints.add(point);  
        }

        return null;
    }

    // Function that returns the near point in a specific direction
    public Point touchingPointInDirection(WSDirection direction){
        return getPointInDirection(direction);
    }

    // Get the points (if valid) in a direction
    // Using this conditions:
    //      UP-CONDITION -> y <= 0
    //      RIGHT-CONDITION -> x >= limit-1
    //      DOWN-CONDITION -> y >= limit-1
    //      LEFT-CONDITION -> x <= 0
    private Point getPointInDirection(WSDirection direction) {
        Point point = null;
        
        switch (direction) {
            case UP: 
                if (y <= 0) break;                            // UP-CONDITION
                point =  new Point(x,(y-1)%limit,limit);         
            case RIGHT_UP: 
                if (y <= 0) break;                            // UP-CONDITION
                if (x >= limit-1) break;                      // RIGHT-CONDITION
                point = new Point((x+1)%limit,(y-1)%limit,limit);
            case RIGHT:
                if (x >= limit-1) break;                      // RIGHT-CONDITION
                point = new Point((x+1)%limit,y,limit);
            case RIGHT_DOWN:
                if (x >= limit-1) break;                      // RIGHT-CONDITION
                if (y >= limit-1) break;                      // DOWN-CONDITION 
                point = new Point((x+1)%limit,(y+1)%limit,limit);                
            case DOWN:
                if (y >= limit-1) break;                      // DOWN-CONDITION 
                point = new Point(x,(y+1)%limit,limit);  
            case LEFT_DOWN:
                if (x <= 0) break;                            // LEFT-CONDITION
                if (y >= limit-1) break;                      // DOWN-CONDITION     
                point = new Point((x+1)%limit,(y+1)%limit,limit);
            case LEFT:
                if (x <= 0) break;                            // LEFT-CONDITION
                point = new Point((x-1)%limit,y,limit);
            case LEFT_UP:
                if (x <= 0) break;                            // LEFT-CONDITION
                if (y <= 0) break;                            // UP-CONDITION
                point = new Point((x-1)%limit,(y-1)%limit,limit); 
        }

        return point;
    }

}
