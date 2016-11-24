/**
 * Created by ashvinlohiya on 15-11-2016.
 */
public class UserClient {
    public static void main(String[] args) {
        Road road = new Road();
        road.obstacleSize = 10;
        for (int i = 0; i < 10; i++) {
            Obstacle obstacle = new Obstacle(10, 10, (25 + 2*i), (50 + 30*i));
            road.obstacles.add(obstacle);
        }

        Car car = new Car(5, 5, 10, 10, road);
        Driver driver = new Driver(car);
        int time = 0;

        while (true) {
            if (!driver.calculate(time)) {
                System.out.println("Crashed!");
                System.exit(1);
            }
            time++;
        }

    }
}
