package CarInfo;


import Enums.BusEnums.BusSeats;

public class BusInfo extends CarInfo{

    private final BusSeats seatsInfo;

    public BusInfo(BusSeats seatsNumber) {
        this.seatsInfo = seatsNumber;
    }

    public BusSeats getSeatsInfo() {
        return seatsInfo;
    }
}