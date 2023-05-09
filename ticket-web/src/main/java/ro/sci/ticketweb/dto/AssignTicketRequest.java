package ro.sci.ticketweb.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AssignTicketRequest {

    private Long ticketId;

    private List<Long> itSpecialistsId;
}
