package CarInfo;

import Enums.RegularCar.RegularCarType;

public class RegularCarInfo extends CarInfo {

    private final RegularCarType regularCarType;

    public RegularCarInfo(RegularCarType regularCarType) {
        this.regularCarType = regularCarType;
    }

    public RegularCarType getCarDoors() {
        return regularCarType;
    }
}