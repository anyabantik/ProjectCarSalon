package Enums.BusEnums;

public enum BusSeats {

    SMALL(15),
    MEDIUM(30),
    LARGE(50);

    private final int seatsNumber;

    BusSeats(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }
}