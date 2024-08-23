package euro.tickets.service.mapper;


import euro.tickets.domain.PromoCode;
import euro.tickets.domain.Promotor;
import euro.tickets.service.dto.PromoCodeDTO;
import euro.tickets.service.dto.PromotorDTO;
import euro.tickets.service.dto.PromotorUpdateDTO;
import org.mapstruct.Mapper;

import java.util.Set;

/**
 * Mapper for the entity {@link Promotor} and its DTO {@link PromotorDTO}.
 */
@Mapper(componentModel = "spring", uses = {
    PromoCodeMapper.class
})
public interface PromotorMapper extends EntityMapper<PromotorDTO, Promotor> {
    Promotor toEntity(PromotorDTO promotorDTO);

    Promotor toEntity(PromotorUpdateDTO promotorDTO);

    Set<PromoCodeDTO> map(Set<PromoCode> promoCodes);

    default Promotor fromId(Long id) {
        if (id == null) {
            return null;
        }
        Promotor promotor = new Promotor();
        promotor.setId(id);
        return promotor;
    }
}
