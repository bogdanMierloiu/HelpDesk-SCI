package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sci.ticketservice.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
