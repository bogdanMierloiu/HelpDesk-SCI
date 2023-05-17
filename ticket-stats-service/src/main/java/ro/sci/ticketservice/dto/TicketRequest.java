package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import ro.sci.ticketservice.model.TicketStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class TicketRequest {

    private Long id;

    @NonNull
    private Long workerId;

    @NonNull
    private Long categoryId;

    @NonNull
    private String description;

    private LocalDateTime createdAt;


    private TicketStatus status;


}
