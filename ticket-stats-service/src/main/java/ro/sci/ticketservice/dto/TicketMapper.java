package ro.sci.ticketservice.dto;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ro.sci.ticketservice.model.Ticket;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TicketMapper {

    Ticket map(TicketRequest ticketRequest);

    @Mapping(target = "worker.policeStructureId", source = "ticket.worker.policeStructure.id")
    @Mapping(target = "worker.departmentId", source = "ticket.worker.department.id")
    TicketResponse map(Ticket ticket);

    List<TicketResponse> map(List<Ticket> tickets);
}
