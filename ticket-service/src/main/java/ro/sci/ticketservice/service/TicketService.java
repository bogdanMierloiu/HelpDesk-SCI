package ro.sci.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sci.ticketservice.dto.TicketMapper;
import ro.sci.ticketservice.dto.TicketRequest;
import ro.sci.ticketservice.dto.TicketResponse;
import ro.sci.ticketservice.model.Ticket;
import ro.sci.ticketservice.model.TicketStatus;
import ro.sci.ticketservice.repository.CategoryRepository;
import ro.sci.ticketservice.repository.TicketRepository;
import ro.sci.ticketservice.repository.WorkerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;
    private final WorkerRepository workerRepository;
    private final CategoryRepository categoryRepository;

    private final TicketMapper ticketMapper;

    @Transactional
    public void add(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setWorker(workerRepository.findById(ticketRequest.getWorkerId()).orElseThrow());
        ticket.setCategory(categoryRepository.findById(ticketRequest.getCategoryId()).orElseThrow());
        ticket.setDescription(ticketRequest.getDescription());
        ticket.setCreatedAt(LocalDateTime.now());
        ticket.setStatus(TicketStatus.OPEN);

        ticketRepository.save(ticket);
    }

    public List<TicketResponse> getAllTickets() {
        return ticketMapper.map(ticketRepository.findAll());
    }


}
