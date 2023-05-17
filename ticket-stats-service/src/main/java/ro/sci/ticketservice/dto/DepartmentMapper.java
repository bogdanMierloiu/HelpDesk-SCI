package ro.sci.ticketservice.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ro.sci.ticketservice.model.Department;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DepartmentMapper {


    Department map(DepartmentRequest departmentRequest);

    DepartmentResponse map(Department department);

    List<DepartmentResponse> map(List<Department> departments);
}
