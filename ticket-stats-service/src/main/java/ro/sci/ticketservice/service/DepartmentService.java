package ro.sci.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sci.ticketservice.dto.DepartmentRequest;
import ro.sci.ticketservice.model.Department;
import ro.sci.ticketservice.repository.DepartmentRepository;
import ro.sci.ticketservice.repository.PoliceStructureRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final PoliceStructureRepository policeStructureRepository;

    @Transactional
    public void add(DepartmentRequest departmentRequest) {
        Department departmentToSave = new Department();
        departmentToSave.setName(departmentRequest.getName());
        departmentToSave.setPoliceStructure(
                policeStructureRepository.findById(
                        departmentRequest.getPoliceStructureId()).orElseThrow());
        departmentRepository.save(departmentToSave);
    }
}
