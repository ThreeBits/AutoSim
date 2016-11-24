import java.util.ArrayList;

/**
 * Created by ashvinlohiya on 14-11-2016.
 */
public class Car {
    double speed, acceleration;
    double x, y;
    double yOffset;
    int length, breadth;
    double accelerationLimit, deAccelerationLimit;
    double time;
    ArrayList<Obstacle> view;
    Road road;


    public Car(int length, int breadth, double accelerationLimit, double deAccelerationLimit, Road road) {

        this.speed = 0;
        this.acceleration = 0;
        this.x = 20;
        this.y = 0;
        this.yOffset = 200;
        this.length = length;
        this.breadth = breadth;
        this.accelerationLimit = accelerationLimit;
        this.deAccelerationLimit = -deAccelerationLimit;
        this.time = 0;
        this.view = new ArrayList<Obstacle>();
        this.road = road;
    }

    public void updateView() {
        double viewY = this.y + this.yOffset;
        int obstacleLength = this.road.obstacles.size();
        for (int i = 0; i < obstacleLength; i++) {
            if (road.obstacles.get(0).y <= viewY) {
                view.add(road.obstacles.get(0));
                road.obstacles.remove(0);
                //road.obstacleSize--;
            } else {
                break;
            }
        }


        int viewLength = this.view.size();
        for (int i = 0; i < viewLength; i++) {
            if (view.get(0).y < this.y) {

                view.remove(0);
            } else {
                break;
            }
        }
    }



    public ArrayList<Obstacle> getView() {
        this.updateView();
        return this.view;
    }

    public boolean steerCar(double deltaX) {
        if (this.x + deltaX < 0 || this.x + deltaX > road.WIDTH) {
            return false;
        } else {
            this.x += deltaX;
            return true;
        }
    }
    public boolean accelerateCar(double deltaAcc) {
        if (deltaAcc + acceleration > accelerationLimit || deltaAcc + acceleration < deAccelerationLimit) {
            return false;
        } else {
            this.acceleration += deltaAcc;
            this.y += this.speed + (this.acceleration/2.0);
            this.speed = this.speed + this.acceleration;
            return true;
        }
    }

    public boolean update(double deltaX, double deltaAcc) {
        double initialX = this.x;
        double initialY = this.y;
        return steerCar(deltaX) && accelerateCar(deltaAcc) && !checkCollision(initialX, initialY);
    }

    public boolean checkCollision(double initialX, double initialY) {
        int viewLength = this.view.size();
        for (int i = 0; i < viewLength; i++) {
            if (this.view.get(0).y + this.view.get(0).length/2 <= this.y - this.length/2) {
                double xSlope = (this.view.get(0).x - initialX)/(initialX - this.x);
                double ySlope = (this.view.get(0).y - initialY)/(initialY - this.y);
                if (Math.abs(xSlope-ySlope) <= 0.75) {
                    return true;
                }
                this.view.remove(0);
            } else {
                break;
            }
        }
        return false;
    }



}
