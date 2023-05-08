package ro.sci.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sci.ticketservice.dto.CategoryRequest;
import ro.sci.ticketservice.dto.DepartmentRequest;
import ro.sci.ticketservice.model.Category;
import ro.sci.ticketservice.model.Department;
import ro.sci.ticketservice.repository.CategoryRepository;
import ro.sci.ticketservice.repository.DepartmentRepository;
import ro.sci.ticketservice.repository.PoliceStructureRepository;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public void add(CategoryRequest categoryRequest) {
        Category categoryToSave = new Category();
        categoryToSave.setName(categoryRequest.getName());
        categoryRepository.save(categoryToSave);
    }
}
