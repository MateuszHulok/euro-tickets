package euro.tickets.service;

import com.google.zxing.WriterException;
import euro.tickets.domain.Guest;
import euro.tickets.service.dto.GuestCreateDTO;
import euro.tickets.service.dto.GuestDTO;
import euro.tickets.service.dto.GuestUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.Optional;

/**
 * Service Interface for managing {@link Guest}.
 */
public interface GuestService {

    /**
     * Save a guest.
     *
     * @param guestDTO the entity to save.
     * @return the persisted entity.
     */
    GuestDTO save(GuestCreateDTO guestDTO) throws IOException, WriterException;

    /**
     * Update a guest.
     *
     * @param guestDTO the entity to save.
     * @return the persisted entity.
     */
    GuestDTO save(GuestUpdateDTO guestDTO);

    /**
     * Get all the guests.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<GuestDTO> findAll(Pageable pageable);


    /**
     * Get the "id" guest.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<GuestDTO> findOne(Long id);

    /**
     * Get guest by email
     *
     * @param email Email addresss
     * @return
     */
    Optional<GuestDTO> findByEmail(String email);

    /**
     * Delete the "id" guest.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
