package ro.sci.ticketweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ro.sci.ticketweb.service.TicketService;

@Controller
@RequiredArgsConstructor
public class TicketWebController {

    private final TicketService ticketService;

    @GetMapping("/")
    public String indexPage(Model model) {
        model.addAttribute("tickets", ticketService.getAllTickets());
        return "index";
    }

}
