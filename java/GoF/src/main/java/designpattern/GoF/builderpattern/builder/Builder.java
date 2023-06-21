package designpattern.GoF.builderpattern.builder;

import designpattern.GoF.builderpattern.car.CarType;
import designpattern.GoF.builderpattern.components.Engine;
import designpattern.GoF.builderpattern.components.GPSNavigator;
import designpattern.GoF.builderpattern.components.Transmission;
import designpattern.GoF.builderpattern.components.TripComputer;

public interface Builder {
    void setCarType(CarType type);
    void setSeats(int seats);
    void setEngine(Engine engine);
    void setTransmission(Transmission transmission);
    void setTripComputer(TripComputer tripComputer);
    void setGPSNavigator(GPSNavigator gpsNavigator);
}
