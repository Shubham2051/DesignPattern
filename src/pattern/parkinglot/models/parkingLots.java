package pattern.parkinglot.models;

import java.util.List;

public class parkingLots extends BaseModel {

    private List<parkingFloor> parkingFloors;
    private List<Gate> gates;
    private int capacity;

    public List<parkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<parkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
