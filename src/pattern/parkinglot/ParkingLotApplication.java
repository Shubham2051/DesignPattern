package pattern.parkinglot;

import pattern.parkinglot.controllers.TicketController;
import pattern.parkinglot.models.Gate;
import pattern.parkinglot.models.VehicleType;
import pattern.parkinglot.models.parkingLots;
import pattern.parkinglot.models.parkingSpot;
import pattern.parkinglot.repositories.GateRepository;
import pattern.parkinglot.repositories.ParkingLotRepository;
import pattern.parkinglot.repositories.TicketRepository;
import pattern.parkinglot.repositories.VehicleRepository;
import pattern.parkinglot.services.TicketService;
import pattern.parkinglot.strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy;
import pattern.parkinglot.strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Optional;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository =new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository =new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();
        TicketService ticketService = new TicketService(
                gateRepository,
                vehicleRepository,
                spotAssignmentStrategy,
                ticketRepository,
                parkingLotRepository
        );
        TicketController ticketController = new TicketController(ticketService);
        System.out.println("Application has started on port: 8080");

    }
}
