package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DepartmentResponse {

    private Long id;

    private String name;

    private Long policeStructureId;
}
