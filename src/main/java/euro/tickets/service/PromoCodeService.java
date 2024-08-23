package euro.tickets.service;

import euro.tickets.domain.PromoCode;
import euro.tickets.service.dto.PromoCodeDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link PromoCode}.
 */
public interface PromoCodeService {

    /**
     * Save a promoCode.
     *
     * @param promoCodeDTO the entity to save.
     * @return the persisted entity.
     */
    PromoCodeDTO save(PromoCodeDTO promoCodeDTO);

    /**
     * Get all the promoCodes.
     *
     * @return the list of entities.
     */
    List<PromoCodeDTO> findAll();

    /**
     * Get the "id" promoCode.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<PromoCodeDTO> findOne(Long id);

    /**
     * Get the "code" promoCode.
     *
     * @param code the id of the entity.
     * @return the entity.
     */
    Optional<PromoCodeDTO> findOne(String code);

    /**
     * Delete the "id" promoCode.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
