package Service;


import Cars.Car;
import Enums.CarInterfaces.CarWheels;
import Exceptions.CarParameterException;


public class WheelService implements Serviceable<Car, CarWheels> {

    @Override
    public void makeOperation(Car car, CarWheels e) throws CarParameterException {

        if (car == null
                || e == null) {
            throw new NullPointerException();
        }

        if (!car.getWheelSize().equals(e)) {
            car.setWheelSize(e);
        }
    }

}