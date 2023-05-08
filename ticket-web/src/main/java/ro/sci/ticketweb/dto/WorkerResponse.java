package ro.sci.ticketweb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkerResponse {

    private Long id;

    private String name;

    private Long policeStructureId;

    private Long departmentId;

}
