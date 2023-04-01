package Service;


import Cars.Car;
import Enums.CarInterfaces.CarParameter;
import Exceptions.CarParameterException;


public interface Serviceable<T extends Car, V extends CarParameter> {
    void makeOperation(T car, V e) throws CarParameterException;
}