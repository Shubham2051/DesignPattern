package pattern.parkinglot.repositories;

import pattern.parkinglot.models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

/*
All crud update will belong here
 */
public class GateRepository {
    private Map<Long,Gate> gatesMap = new TreeMap<>();

    public Optional<Gate> findGateById(Long gateId){
        if(gatesMap.containsKey(gateId)){
            return Optional.of(gatesMap.get(gateId));
        }
        return Optional.empty();

    }
}
