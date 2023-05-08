package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.sci.ticketservice.dto.AssignTicketRequest;
import ro.sci.ticketservice.dto.TicketRequest;
import ro.sci.ticketservice.dto.TicketResponse;
import ro.sci.ticketservice.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody TicketRequest ticketRequest) {
        ticketService.add(ticketRequest);
        return ResponseEntity.ok("Added successfully");
    }

    @GetMapping("/all-tickets")
    public ResponseEntity<List<TicketResponse>> getAll() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/all-open-tickets")
    public ResponseEntity<List<TicketResponse>> getAllOpen() {
        return ResponseEntity.ok(ticketService.getAllTicketsOpen());
    }

    @GetMapping("/all-in-progress-tickets")
    public ResponseEntity<List<TicketResponse>> getAllInProgress() {
        return ResponseEntity.ok(ticketService.getAllTicketsInProgress());
    }

    @GetMapping("/all-closed-tickets")
    public ResponseEntity<List<TicketResponse>> getAllClosed() {
        return ResponseEntity.ok(ticketService.getAllTicketsClosed());
    }

    @PostMapping("/assign")
    public ResponseEntity<String> assignTicket(@RequestBody AssignTicketRequest request) {
        if (request.getTicketId() == null || request.getItSpecialistsId() == null) {
            return ResponseEntity.badRequest().body("Invalid request body");
        }
        ticketService.assignTicket(request);
        return ResponseEntity.ok("Ticket assigned successfully");
    }


}
