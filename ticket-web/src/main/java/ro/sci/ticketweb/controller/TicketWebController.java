package ro.sci.ticketweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.sci.ticketweb.dto.AssignTicketRequest;
import ro.sci.ticketweb.dto.TicketRequest;
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
        model.addAttribute("tickets", ticketService.getAllTicketsNotResolved());
        return "index";
    }

    @GetMapping("/add-ticket-form")
    public String ticketForm(Model model) {
        return "add-ticket";
    }

    @PostMapping("/add")
    public String addTicket(@ModelAttribute TicketRequest request, Model model) {
        ticketService.addTicket(request);
        model.addAttribute("tickets", ticketService.getAllTicketsNotResolved());
        return "index";
    }

    @PostMapping("/view-ticket")
    public String viewTicket(@RequestParam("id") Long ticketId, Model model) {
        TicketResponse ticketResponse = ticketService.getTicketById(ticketId);
        model.addAttribute("ticket", ticketResponse);
        return "ticket";
    }

    @GetMapping("/view-tickets-for-it-specialist")
    public String viewTicketsForItSpecialist(@RequestParam("id") Long itSpecialistId, Model model) {
        model.addAttribute("tickets", ticketService.getTicketsByItSpecialistId(itSpecialistId));
        return "tickets-for-itSpecialist";
    }

    @PostMapping("/assign-ticket")
    public String assignTicket(@RequestParam("id") Long ticketId, Model model) {
        AssignTicketRequest request = AssignTicketRequest.builder()
                .ticketId(ticketId)
                .itSpecialistsId(List.of(1L))
                .build();
        ticketService.assignTicket(request);
        model.addAttribute("tickets", ticketService.getAllTicketsNotResolved());
        return "index";
    }


}
