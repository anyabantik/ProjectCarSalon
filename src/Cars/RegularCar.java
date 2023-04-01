package Cars;

import Enums.*;
import Enums.CarInterfaces.CarColors;
import Enums.CarInterfaces.CarWheels;
import Enums.RegularCar.*;
import Exceptions.CarParameterException;

public class RegularCar extends Car {

    private final RegularCarType regularCarType;

    public RegularCar(RegularCarColors color, RegularCarModels model, int year, RegularCarWheels wheelSize, RegularCarEngines engineVol, Options[] options, RegularCarType regularCarType) {
        super(color, model, year, wheelSize, engineVol, options);
        this.regularCarType = regularCarType;
    }

    public RegularCar(RegularCarColors color, RegularCarModels model, int year, RegularCarWheels wheelSize, RegularCarEngines engineVol, RegularCarType regularCarType) {
        super(color, model, year, wheelSize, engineVol);
        this.regularCarType = regularCarType;
    }

    @Override
    public void setColor(CarColors color) throws CarParameterException {
        if (color instanceof RegularCarColors) {
            this.color = color;
        } else {
            throw new CarParameterException();
        }
    }

    @Override
    public void setWheelSize(CarWheels wheelSize) throws CarParameterException {
        if (wheelSize instanceof RegularCarWheels) {
            this.wheelSize = wheelSize;
        } else {
            throw new CarParameterException();
        }
    }

    public RegularCarType getCarDoors() {
        return regularCarType;
    }

    @Override
    public String toString() {
        return "RegularCar{" +
                "color=" + color +
                ", model=" + model +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVol=" + engineVol +
                ", options=" + options +
                ", carDoors=" + regularCarType +
                '}';
    }
}
