import java.util.ArrayList;

/**
 * Created by ashvinlohiya on 14-11-2016.
 */
public class Road {
    ArrayList<Obstacle> obstacles;
    final double WIDTH = 100;
    int obstacleSize;

    public Road() {
        this.obstacles = new ArrayList<Obstacle>();
        this.obstacleSize = 0;
    }

    public int getObstacleSize() {
        return this.obstacleSize;
    }
}
