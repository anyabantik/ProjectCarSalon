package Cars;

import Enums.CarInterfaces.CarColors;
import Enums.CarInterfaces.CarWheels;
import Enums.Options;
import Enums.TruckEnums.*;
import Exceptions.CarParameterException;

public class Truck extends Car {

    private final TruckTonnage tonnage;

    public Truck(TruckColors color, TruckModels model, int year, TruckWheels wheelSize, TruckEngines engineVol, Options[] options, TruckTonnage tonnage) {
        super(color, model, year, wheelSize, engineVol, options);
        this.tonnage = tonnage;
    }

    public Truck(TruckColors color, TruckModels model, int year, TruckWheels wheelSize, TruckEngines engineVol, TruckTonnage tonnage) {
        super(color, model, year, wheelSize, engineVol);
        this.tonnage = tonnage;
    }

    public TruckTonnage getTonnage() {
        return tonnage;
    }

    @Override
    public void setColor(CarColors color) throws CarParameterException {
        if (color instanceof TruckColors) {
            this.color = color;
        } else {
            throw new CarParameterException();
        }
    }

    @Override
    public void setWheelSize(CarWheels wheelSize) throws CarParameterException {
        if (wheelSize instanceof TruckWheels) {
            this.wheelSize = wheelSize;
        } else {
            throw new CarParameterException();
        }
    }

    @Override
    public String toString() {
        return "Truck{" +
                "color=" + color +
                ", model=" + model +
                ", year=" + year +
                ", wheelSize=" + wheelSize +
                ", engineVol=" + engineVol +
                ", options=" + options +
                ", tonnage=" + tonnage +
                '}';
    }
}