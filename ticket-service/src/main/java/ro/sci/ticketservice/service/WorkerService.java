package ro.sci.ticketservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.sci.ticketservice.dto.WorkerRequest;
import ro.sci.ticketservice.model.PoliceStructure;
import ro.sci.ticketservice.model.Worker;
import ro.sci.ticketservice.model.Department;
import ro.sci.ticketservice.repository.PoliceStructureRepository;
import ro.sci.ticketservice.repository.WorkerRepository;
import ro.sci.ticketservice.repository.DepartmentRepository;

@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final DepartmentRepository departmentRepository;
    private final PoliceStructureRepository policeStructureRepository;


    public void add(WorkerRequest workerRequest) {
        Worker worker = new Worker();
        worker.setName(workerRequest.getName());
        PoliceStructure policeStructure = policeStructureRepository.findById(workerRequest.getPoliceStructureId()).orElseThrow();
        Department department = departmentRepository.findById(workerRequest.getDepartmentId()).orElseThrow();
        worker.setPoliceStructure(policeStructure);
        worker.setDepartment(department);
        workerRepository.save(worker);
    }
}
