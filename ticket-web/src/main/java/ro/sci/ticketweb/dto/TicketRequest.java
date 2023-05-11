package ro.sci.ticketweb.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor(force = true)
@AllArgsConstructor
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
