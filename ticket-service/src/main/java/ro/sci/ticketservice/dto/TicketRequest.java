package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;
import ro.sci.ticketservice.model.TicketStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class TicketRequest {

    private Long id;

    private Long workerId;

    private Long categoryId;

    private String description;

    private LocalDateTime createdAt;

    private TicketStatus status;


}
