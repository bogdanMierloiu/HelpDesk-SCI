package ro.sci.ticketservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Worker worker;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @Column(length = 1000, nullable = false)
    private String description;

    private LocalDateTime createdAt;

    @Column(columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToMany
    @JoinTable(name = "itspecialist_tickets",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "itspecialist_id")
    )
    private List<ITSpecialist> workers = new ArrayList<>();


}
