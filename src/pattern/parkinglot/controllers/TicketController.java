package pattern.parkinglot.controllers;

import pattern.parkinglot.dtos.GenerateTicketRequestDto;
import pattern.parkinglot.dtos.GenerateTicketResponseDto;
import pattern.parkinglot.dtos.ResponseStatus;
import pattern.parkinglot.exceptions.invalidGateException;
import pattern.parkinglot.exceptions.noAvailabeParkingSpotException;
import pattern.parkinglot.models.Ticket;
import pattern.parkinglot.models.VehicleType;
import pattern.parkinglot.services.TicketService;

public class  TicketController  {
    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    public GenerateTicketResponseDto generateTickets(GenerateTicketRequestDto requestDto)  {
         String vehicleNumber = requestDto.getVehicleNumber();
         VehicleType vehicleType = requestDto.getVehicleType();
         Long gateId = requestDto.getGateId();

        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();
        Ticket ticket;
        try {
            ticket = ticketService.generateTicket(gateId,vehicleType,vehicleNumber);
        } catch (invalidGateException e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
            responseDto.setMessage("Gate ID is Invalid");
            return responseDto;
        } catch (noAvailabeParkingSpotException e){
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
            responseDto.setMessage("No Parking Spot Available");
            return responseDto;
        }

        responseDto.setTicketId(ticket.getId());
        responseDto.setOperatorName(ticket.getOperator().getName());
        responseDto.setSpotNumber(ticket.getParkingSpot().getNumber());
        responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        return responseDto;
    }
}
