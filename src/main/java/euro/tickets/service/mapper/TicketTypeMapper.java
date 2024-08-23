package euro.tickets.service.mapper;


import euro.tickets.domain.TicketType;
import euro.tickets.service.dto.TicketTypeDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link TicketType} and its DTO {@link TicketTypeDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TicketTypeMapper extends EntityMapper<TicketTypeDTO, TicketType> {
    TicketType toEntity(TicketTypeDTO ticketTypeDTO);

    default TicketType fromId(Long id) {
        if (id == null) {
            return null;
        }
        TicketType ticketType = new TicketType();
        ticketType.setId(id);
        return ticketType;
    }
}
