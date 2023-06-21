package designpattern.GoF.builderpattern;

import designpattern.GoF.builderpattern.builder.CarBuilder;
import designpattern.GoF.builderpattern.builder.CarManualBuilder;
import designpattern.GoF.builderpattern.car.Car;
import designpattern.GoF.builderpattern.car.Manual;
import designpattern.GoF.builderpattern.director.Director;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        CarBuilder builder = new CarBuilder();
        director.constructSportsCar(builder);

        Car car = builder.getResult();
        System.out.println("Car built:\n" + car.getCarType());


        CarManualBuilder manualBuilder = new CarManualBuilder();

        director.constructSportsCar(manualBuilder);
        Manual carManual = manualBuilder.getResult();
        System.out.println("\nCar manual built:\n" + carManual.print());
    }
}
