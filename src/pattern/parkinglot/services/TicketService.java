package pattern.parkinglot.services;

import pattern.parkinglot.exceptions.invalidGateException;
import pattern.parkinglot.exceptions.noAvailabeParkingSpotException;
import pattern.parkinglot.models.*;
import pattern.parkinglot.repositories.GateRepository;
import pattern.parkinglot.repositories.ParkingLotRepository;
import pattern.parkinglot.repositories.TicketRepository;
import pattern.parkinglot.repositories.VehicleRepository;
import pattern.parkinglot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private SpotAssignmentStrategy spotAssignmentStrategy;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository, SpotAssignmentStrategy spotAssignmentStrategy
                         , TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository ) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository=ticketRepository;
        this.parkingLotRepository=parkingLotRepository;
    }

    public Ticket generateTicket(Long gateId, VehicleType vehicleType, String vehicleNumber) throws invalidGateException, noAvailabeParkingSpotException {

        Optional<Gate> gateOptional = gateRepository.findGateById(gateId);

        if (gateOptional.isEmpty()) {
            throw new invalidGateException();
        }

        Gate gate = gateOptional.get();
        Operator operator = gate.getCurrentOperator();
        Vehicle vehicle;
        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        if (vehicleOptional.isEmpty()) {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        } else {
            vehicle = vehicleOptional.get();
        }

        Optional<parkingLots> parkingLotsOptional = parkingLotRepository.getParkingLotsOfGate(gate);
        parkingLots parkingLots = parkingLotsOptional.get();


        Optional<parkingSpot> parkingSpotOptional = spotAssignmentStrategy.findSpot(vehicleType,parkingLots,gate);

        if (parkingSpotOptional.isEmpty()){
            throw new noAvailabeParkingSpotException();
        }

        parkingSpot parkingSpot = parkingSpotOptional.get();


        Ticket ticket =new Ticket();
        ticket.setParkingSpot(parkingSpot);
        ticket.setGate(gate);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setOperator(operator);
        return ticketRepository.save(ticket);

    }
}
