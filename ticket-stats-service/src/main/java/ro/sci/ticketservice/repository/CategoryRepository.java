package ro.sci.ticketservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sci.ticketservice.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
