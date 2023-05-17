package ro.sci.ticketservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("ticket")
    private Worker worker;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("ticket")
    private Category category;

    @Column(length = 1000, nullable = false)
    private String description;

    private LocalDateTime createdAt;


    @Column(columnDefinition = "VARCHAR(16)")
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @ManyToMany
    @JsonIgnoreProperties("tickets")
    @JoinTable(name = "itspecialist_tickets",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "itspecialist_id")
    )
    private List<ITSpecialist> itSpecialists = new ArrayList<>();


}
