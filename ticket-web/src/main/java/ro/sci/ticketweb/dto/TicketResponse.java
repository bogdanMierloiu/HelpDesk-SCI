package ro.sci.ticketweb.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class TicketResponse {

    private Long id;

    private WorkerResponse worker;

    private CategoryResponse category;

    private String description;

    private LocalDateTime createdAt;

    private TicketStatus status;

}
