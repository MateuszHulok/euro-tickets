package euro.tickets.service.mapper;


import euro.tickets.domain.Guest;
import euro.tickets.service.dto.GuestCreateDTO;
import euro.tickets.service.dto.GuestDTO;
import euro.tickets.service.dto.GuestUpdateDTO;
import org.mapstruct.Mapper;

/**
 * Mapper for the entity {@link Guest} and its DTO {@link GuestDTO}.
 */
@Mapper(componentModel = "spring", uses = {TicketMapper.class, PromotorMapper.class, TicketTypeMapper.class})
public interface GuestMapper extends EntityMapper<GuestDTO, Guest> {
    GuestDTO toDto(Guest guest);

    Guest toEntity(GuestDTO guestDTO);

    GuestDTO toDto(GuestCreateDTO guestCreateDTO);

    default GuestDTO update(GuestDTO guestDTO, GuestUpdateDTO guestUpdateDTO) {
        guestDTO.setName(guestUpdateDTO.getName());
        guestDTO.setLastName(guestUpdateDTO.getLastName());
        guestDTO.setEmail(guestUpdateDTO.getEmail());
        guestDTO.setPhoneNumber(guestUpdateDTO.getPhoneNumber());
        guestDTO.setNotes(guestUpdateDTO.getNotes());

        return guestDTO;
    }

    default Guest fromId(Long id) {
        if (id == null) {
            return null;
        }
        Guest guest = new Guest();
        guest.setId(id);
        return guest;
    }
}
