package pattern.parkinglot.models;

import java.util.Date;

public class Ticket extends BaseModel {
    private parkingSpot parkingSpot;
    private Date entryTime;
    private Vehicle vehicle;
    private Gate gate;
    private Operator operator;

    public pattern.parkinglot.models.parkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(pattern.parkinglot.models.parkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
