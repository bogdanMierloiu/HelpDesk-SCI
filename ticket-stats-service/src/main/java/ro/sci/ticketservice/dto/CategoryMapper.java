package ro.sci.ticketservice.dto;

import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ro.sci.ticketservice.model.Category;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CategoryMapper {


    Category map(CategoryRequest request);

    CategoryResponse map(Category category);

    List<CategoryResponse> map(List<Category> categories);
}
