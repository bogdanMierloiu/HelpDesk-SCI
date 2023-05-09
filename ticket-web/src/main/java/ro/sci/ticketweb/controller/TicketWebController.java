package ro.sci.ticketweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sci.ticketweb.dto.AssignTicketRequest;
import ro.sci.ticketweb.dto.TicketResponse;
import ro.sci.ticketweb.service.TicketService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/ticket")
public class TicketWebController {

    private final TicketService ticketService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "index";
    }

    @PostMapping("/view-ticket")
    public String viewTicket(@RequestParam("id") Long ticketId, Model model) {
        TicketResponse ticketResponse = ticketService.getTicketById(ticketId);
        model.addAttribute("ticket", ticketResponse);
        return "ticket";
    }

    @PostMapping("/assign-ticket")
    public String assignTicket(@RequestParam("id") Long ticketId, Model model) {
        AssignTicketRequest request = AssignTicketRequest.builder()
                .ticketId(ticketId)
                .itSpecialistsId(List.of(1L))
                .build();
        ticketService.assignTicket(request);
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "index";
    }


}
