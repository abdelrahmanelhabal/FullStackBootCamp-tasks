package com.vehiclesSystem;

import com.vehiclesSystem.config.Config;
import com.vehiclesSystem.controller.BikeController;
import com.vehiclesSystem.controller.CarController;
import com.vehiclesSystem.controller.PlaneController;
import com.vehiclesSystem.models.Bike;
import com.vehiclesSystem.models.Car;
import com.vehiclesSystem.models.Plane;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        // car
        Car car =  (Car) context.getBean("car");
        car.setType("car");
        car.setBrand("BMW");
        CarController carController = (CarController) context.getBean("carController");
        carController.save(car);

        //plane
        Plane plane = (Plane) context.getBean("plane");
        plane.setType("plane");
        plane.setBrand("Ford");
        PlaneController planeController = (PlaneController) context.getBean("planeController");
        planeController.save(plane);

        // bike
        Bike bike = (Bike) context.getBean("bike");
        bike.setType("bike");
        bike.setBrand("Ford");
        BikeController bikeController = (BikeController) context.getBean("bikeController");
        bikeController.save(bike);

        carController.getAll().forEach(System.out::println);
        context.close();
    }
}
