package ro.sci.ticketservice.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class CategoryRequest {

    private Long id;

    @NonNull
    private String name;


}
