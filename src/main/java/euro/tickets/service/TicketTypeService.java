package euro.tickets.service;

import euro.tickets.domain.TicketType;
import euro.tickets.service.dto.TicketTypeDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link TicketType}.
 */
public interface TicketTypeService {

    /**
     * Save a ticketType.
     *
     * @param ticketTypeDTO the entity to save.
     * @return the persisted entity.
     */
    TicketTypeDTO save(TicketTypeDTO ticketTypeDTO);

    /**
     * Get all the ticketTypes.
     *
     * @return the list of entities.
     */
    List<TicketTypeDTO> findAll();

    /**
     * Get the "id" ticketType.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TicketTypeDTO> findOne(Long id);

    /**
     * Get ticket type by defined product id (registered id in woocomerce)
     *
     * @param productId
     * @return
     */
    Optional<TicketTypeDTO> findOneByProductId(String productId);

    /**
     * Delete the "id" ticketType.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
