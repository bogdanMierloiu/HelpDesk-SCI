package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.sci.ticketservice.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t order by t.createdAt desc")
    List<Ticket> findAllOrderByDate();

    @Query("SELECT t FROM Ticket t where t.status = 'OPEN' order by t.createdAt desc")
    List<Ticket> findAllByStatusOpen();

    @Query("SELECT t FROM Ticket t where t.status = 'IN_PROGRESS' order by t.createdAt desc")
    List<Ticket> findAllByStatusInProgress();

    @Query("SELECT t FROM Ticket t where t.status = 'CLOSED' order by t.createdAt desc")
    List<Ticket> findAllByStatusIsClosed();
}
