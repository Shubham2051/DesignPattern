package pattern.parkinglot.models;

import java.util.List;

public class parkingFloor extends BaseModel{

    private List<parkingSpot> parkingSpots;

    private int floorNumber;

    public List<parkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<parkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }
}
