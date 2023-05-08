package ro.sci.ticketweb.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TicketResponse {

    private Long id;

    private WorkerResponse worker;

    private CategoryResponse category;

    private String description;

    private LocalDateTime createdAt;

    private TicketStatus status;

}
