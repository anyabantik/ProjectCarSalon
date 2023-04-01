package Service;


import Cars.Car;
import Enums.Options;

public class DeleteOptionService implements Serviceable<Car, Options> {

    @Override
    public void makeOperation(Car car, Options option) {

        if (car == null
                || option == null) {
            throw new NullPointerException();
        }

        if (car.getOptions().contains(option)) {
            car.removeOption((Options) option);
        }
    }
}