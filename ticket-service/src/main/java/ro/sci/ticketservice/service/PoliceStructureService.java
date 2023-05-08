package ro.sci.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sci.ticketservice.dto.PoliceStructureRequest;
import ro.sci.ticketservice.dto.WorkerRequest;
import ro.sci.ticketservice.model.PoliceStructure;
import ro.sci.ticketservice.model.Worker;
import ro.sci.ticketservice.model.Department;
import ro.sci.ticketservice.repository.PoliceStructureRepository;
import ro.sci.ticketservice.repository.WorkerRepository;
import ro.sci.ticketservice.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
public class PoliceStructureService {

    private final PoliceStructureRepository policeStructureRepository;

    public void add(PoliceStructureRequest policeStructureRequest) {
        PoliceStructure policeStructure = new PoliceStructure();
        policeStructure.setName(policeStructureRequest.getName());
        policeStructureRepository.save(policeStructure);

    }
}
