package ro.sci.ticketweb.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {

    private Long id;

    private String name;


}
