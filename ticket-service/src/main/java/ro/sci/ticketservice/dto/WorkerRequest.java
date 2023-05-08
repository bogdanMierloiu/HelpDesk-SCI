package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class WorkerRequest {

    private Long id;

    @NonNull
    private String name;

    private Long policeStructureId;

    private Long departmentId;

}
