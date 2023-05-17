package ro.sci.ticketservice.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ro.sci.ticketservice.model.Worker;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface WorkerMapper {

    Worker map(WorkerRequest request);

    @Mapping(target = "policeStructureId", source = "worker.policeStructure.id")
    @Mapping(target = "departmentId", source = "worker.department.id")
    WorkerResponse map(Worker worker);

    List<WorkerResponse> map(List<Worker> workers);
}

