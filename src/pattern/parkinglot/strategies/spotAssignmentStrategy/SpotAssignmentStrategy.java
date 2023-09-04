package pattern.parkinglot.strategies.spotAssignmentStrategy;

import pattern.parkinglot.models.Gate;
import pattern.parkinglot.models.VehicleType;
import pattern.parkinglot.models.parkingLots;
import pattern.parkinglot.models.parkingSpot;

import java.util.Optional;

public interface SpotAssignmentStrategy {

       Optional<parkingSpot> findSpot(VehicleType vehicleType, parkingLots parkingLot, Gate gate);
}
