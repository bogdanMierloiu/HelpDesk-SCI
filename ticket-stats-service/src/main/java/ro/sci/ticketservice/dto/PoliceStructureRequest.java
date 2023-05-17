package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class PoliceStructureRequest {

    private Long id;

    @NonNull
    private String name;



}
