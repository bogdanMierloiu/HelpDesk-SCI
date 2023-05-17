package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sci.ticketservice.model.ITSpecialist;

public interface ITSpecialistRepository extends JpaRepository<ITSpecialist, Long> {
}
