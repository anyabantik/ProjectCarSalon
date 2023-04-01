package Service;

import Cars.Car;
import Enums.CarInterfaces.CarColors;
import Exceptions.CarParameterException;


public class ColorService implements Serviceable<Car, CarColors> {

    @Override
    public void makeOperation(Car car, CarColors color) throws CarParameterException {

        if (car == null
                || color == null) {
            throw new NullPointerException();
        }

        if (!car.getColor().equals(color)) {
            car.setColor(color);
        }
    }
}