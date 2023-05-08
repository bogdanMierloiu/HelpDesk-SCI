package ro.sci.ticketservice.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sci.ticketservice.dto.AssignTicketRequest;
import ro.sci.ticketservice.dto.TicketMapper;
import ro.sci.ticketservice.dto.TicketRequest;
import ro.sci.ticketservice.dto.TicketResponse;
import ro.sci.ticketservice.exception.NotFoundException;
import ro.sci.ticketservice.model.ITSpecialist;
import ro.sci.ticketservice.model.Ticket;
import ro.sci.ticketservice.model.TicketStatus;
import ro.sci.ticketservice.repository.CategoryRepository;
import ro.sci.ticketservice.repository.ITSpecialistRepository;
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
    private final ITSpecialistRepository itSpecialistRepository;

    private final TicketMapper ticketMapper;

    @Transactional
    public void add(TicketRequest ticketRequest) {
        Ticket ticket = Ticket.builder()
                .worker(workerRepository.findById(ticketRequest.getWorkerId()).orElseThrow())
                .category(categoryRepository.findById(ticketRequest.getCategoryId()).orElseThrow())
                .description(ticketRequest.getDescription())
                .createdAt(LocalDateTime.now())
                .status(TicketStatus.OPEN)
                .build();
        ticketRepository.save(ticket);
    }

    public List<TicketResponse> getAllTickets() {
        return ticketMapper.map(ticketRepository.findAllOrderByDate());
    }

    public List<TicketResponse> getAllTicketsOpen() {
        return ticketMapper.map(ticketRepository.findAllByStatusOpen());
    }

    public List<TicketResponse> getAllTicketsInProgress() {
        return ticketMapper.map(ticketRepository.findAllByStatusInProgress());
    }

    public List<TicketResponse> getAllTicketsClosed() {
        return ticketMapper.map(ticketRepository.findAllByStatusIsClosed());
    }

    @Transactional
    public void assignTicket(AssignTicketRequest request) {
        validateInput(request.getTicketId(), request.getItSpecialistsId());
        Ticket ticket = getTicketById(request.getTicketId());
        List<ITSpecialist> itSpecialists = getItSpecialistById(request.getItSpecialistsId());
        assignItSpecialistsToTicket(ticket, itSpecialists);
        updateTicketStatus(ticket, TicketStatus.IN_PROGRESS);
        ticketRepository.save(ticket);
    }


    // Private methods
    private void validateInput(Long ticketId, List<Long> itSpecialistId) {
        if (ticketId == null) {
            throw new IllegalArgumentException("Ticket ID cannot be null");
        }
        if (itSpecialistId == null || itSpecialistId.isEmpty()) {
            throw new IllegalArgumentException("IT Specialist Ids cannot be null or empty");
        }
    }

    private Ticket getTicketById(Long ticketId) {
        return ticketRepository.findById(ticketId).orElseThrow(() ->
                new NotFoundException("The ticket with id:" + ticketId + " not exists")
        );
    }

    private List<ITSpecialist> getItSpecialistById(List<Long> itSpecialistsId) {
        return itSpecialistRepository.findAllById(itSpecialistsId);
    }

    private void updateTicketStatus(Ticket ticket, TicketStatus status) {
        ticket.setStatus(status);
    }

    private void assignItSpecialistsToTicket(Ticket ticket, List<ITSpecialist> itSpecialists) {
        ticket.getItSpecialists().addAll(itSpecialists);
    }


}
