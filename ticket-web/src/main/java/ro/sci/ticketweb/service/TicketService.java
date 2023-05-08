package ro.sci.ticketweb.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ro.sci.ticketweb.dto.TicketResponse;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final WebClient.Builder webClientBuilder;

    public TicketResponse[] getAllTickets() {
        return webClientBuilder.build().get()
                .uri("http://localhost:8081/ticket/all-tickets")
                .retrieve()
                .bodyToMono(TicketResponse[].class)
                .block();
    }
}
