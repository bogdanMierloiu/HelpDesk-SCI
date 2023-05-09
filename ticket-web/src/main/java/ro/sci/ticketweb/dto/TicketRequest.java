package ro.sci.ticketweb.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

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
