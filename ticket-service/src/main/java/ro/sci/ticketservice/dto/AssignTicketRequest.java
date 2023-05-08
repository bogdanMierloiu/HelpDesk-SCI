package ro.sci.ticketservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class AssignTicketRequest {

    private Long ticketId;

    private List<Long> itSpecialistsId;
}
