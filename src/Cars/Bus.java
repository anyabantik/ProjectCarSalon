package Cars;

import Enums.*;
import Enums.BusEnums.*;
import Enums.CarInterfaces.CarColors;
import Enums.CarInterfaces.CarWheels;
import Exceptions.CarParameterException;

public class Bus extends Car {

    private final int seatsNumber;

    public Bus(BusColors color, BusModels model, int year, BusWheels wheelSize, BusEngines engineVol, Options[] options, BusSeats seatsNumber) {
        super(color, model, year, wheelSize, engineVol, options);
        this.seatsNumber = seatsNumber.getSeatsNumber();
    }

    public Bus(BusColors color, BusModels model, int year, BusWheels wheelSize, BusEngines engineVol, int seatsNumber) {
        super(color, model, year, wheelSize, engineVol);
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    @Override
    public void setColor(CarColors color) throws CarParameterException {

        if (color instanceof BusColors) {
            this.color = color;
        } else {
            throw new CarParameterException();
        }
    }

    @Override
    public void setWheelSize(CarWheels wheelSize) throws CarParameterException {
        if (wheelSize instanceof BusWheels) {
            this.wheelSize = wheelSize;
        } else {
            throw new CarParameterException();
        }
    }

    @Override
    public String toString() {
        return "Bus{" +
                "color=" + color +
                ", model=" + model +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVol=" + engineVol +
                ", options=" + options +
                ", seatsNumber=" + seatsNumber +
                '}';
    }
}