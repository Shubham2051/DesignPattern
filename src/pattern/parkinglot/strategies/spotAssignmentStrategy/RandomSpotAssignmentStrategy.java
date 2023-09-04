package pattern.parkinglot.strategies.spotAssignmentStrategy;

import pattern.parkinglot.models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    @Override
    public Optional<parkingSpot> findSpot(VehicleType vehicleType, parkingLots parkingLot, Gate gate) {
        for (parkingFloor parkingFloor : parkingLot.getParkingFloors()){
            for (parkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getSpotStatus().equals(SpotStatus.AVAILABLE)
                        && parkingSpot.getVehicleTypes().contains(vehicleType)){
                    return Optional.of(parkingSpot);
                }
            }
        }
        return Optional.empty();
    }
}
