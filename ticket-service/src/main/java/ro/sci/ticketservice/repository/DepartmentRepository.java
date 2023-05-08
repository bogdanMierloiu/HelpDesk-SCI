package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sci.ticketservice.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
