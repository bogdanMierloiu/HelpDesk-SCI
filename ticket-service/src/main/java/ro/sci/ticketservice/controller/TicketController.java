package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.ticketservice.dto.TicketRequest;
import ro.sci.ticketservice.service.TicketService;

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
}
