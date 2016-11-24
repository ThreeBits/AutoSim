import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ashvinlohiya on 15-11-2016.
 */
public class Driver {
    Car car;
    double deltaX, deltaAcc;

    public Driver(Car car) {
        this.car = car;
        this.deltaX = 0;
        this.deltaAcc = 0;
    }

    public boolean calculate(int time) {

        ArrayList<Obstacle> view = car.getView();
        displayInformation(view);
        userInput();
        return updateCar();

    }

    public void displayInformation(ArrayList<Obstacle> view) {
        System.out.println("x = " + car.x + "\t y = " + car.y);
        System.out.println("Speed = " + car.speed + "\t Acceleration = " + car.acceleration);
        System.out.println("AccLimit = " + car.accelerationLimit + "\t DeAccLimit = " + car.deAccelerationLimit);
        int viewLength = view.size();
        for (int i = 0; i < viewLength; i++) {
            System.out.println("Obstacle " + (i+1) + " x = " + view.get(i).x + " y = " + view.get(i).y);
        }
    }

    public void userInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter delta x");
        this.deltaX = in.nextDouble();
        System.out.println("Enter delta Acc");
        this.deltaAcc = in.nextDouble();

    }

    public boolean updateCar() {
        return car.update(deltaX, deltaAcc);
    }
}
