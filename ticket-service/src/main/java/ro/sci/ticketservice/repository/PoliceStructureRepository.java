package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sci.ticketservice.model.PoliceStructure;

public interface PoliceStructureRepository extends JpaRepository<PoliceStructure, Long> {
}
