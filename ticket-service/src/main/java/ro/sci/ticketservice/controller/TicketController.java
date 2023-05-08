package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAll() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }
}
