package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PoliceStructureResponse {

    private Long id;

    private String name;

}
