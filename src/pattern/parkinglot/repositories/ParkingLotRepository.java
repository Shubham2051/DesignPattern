package pattern.parkinglot.repositories;

import pattern.parkinglot.models.Gate;
import pattern.parkinglot.models.parkingLots;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    private Map<Long, parkingLots> parkingLotsMap = new TreeMap<>();

    public Optional<parkingLots> getParkingLotsOfGate(Gate gate){
        for (parkingLots parkingLots: parkingLotsMap.values()){
            if(parkingLots.getGates().contains(gate)){
                return Optional.of(parkingLots);
            }
        }
        return Optional.empty();

    }
}
