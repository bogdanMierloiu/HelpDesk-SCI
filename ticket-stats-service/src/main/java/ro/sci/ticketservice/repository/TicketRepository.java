package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ro.sci.ticketservice.model.Ticket;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t order by t.createdAt desc")
    List<Ticket> findAllOrderByDate();

    @Query("SELECT t FROM Ticket t where t.status = 'OPEN' order by t.createdAt desc")
    List<Ticket> findAllByStatusOpen();

    @Query("SELECT t FROM Ticket t where t.status = 'IN_PROGRESS' order by t.createdAt desc")
    List<Ticket> findAllByStatusInProgress();

    @Query("SELECT t FROM Ticket t where t.status = 'RESOLVED' order by t.createdAt desc")
    List<Ticket> findAllByStatusIsClosed();

    @Query("SELECT t FROM Ticket t where t.status != 'RESOLVED' order by t.createdAt desc")
    List<Ticket> findAllByStatusIsNotClosed();

    @Query("SELECT t FROM Ticket t JOIN t.itSpecialists i WHERE i.id = :itSpecialistId " +
            "AND t.id IN (SELECT tt.id FROM Ticket tt JOIN tt.itSpecialists ii WHERE ii.id = :itSpecialistId)")
    List<Ticket> findAllByItSpecialistId(@Param("itSpecialistId") Long itSpecialistId);


}
