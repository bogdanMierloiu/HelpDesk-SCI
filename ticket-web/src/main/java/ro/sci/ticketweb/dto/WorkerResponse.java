package ro.sci.ticketweb.dto;

import lombok.*;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class WorkerResponse {

    private Long id;

    private String name;

    private Long policeStructureId;

    private Long departmentId;

}
