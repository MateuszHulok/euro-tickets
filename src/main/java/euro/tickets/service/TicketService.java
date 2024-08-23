package euro.tickets.service;

import com.google.zxing.WriterException;
import com.lowagie.text.DocumentException;
import euro.tickets.domain.Ticket;
import euro.tickets.service.dto.TicketCreateDTO;
import euro.tickets.service.dto.TicketDTO;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Ticket}.
 */
public interface TicketService {

    /**
     * Save a ticket.
     *
     * @param ticketDTO the entity to save.
     * @return the persisted entity.
     */
    TicketDTO create(TicketCreateDTO ticketDTO) throws WriterException, IOException, DocumentException;

    /**
     * Get all the tickets.
     *
     * @return the list of entities.
     */
    List<TicketDTO> findAll();

    /**
     * Get all the TicketDTO where Guest is {@code null}.
     *
     * @return the {@link List} of entities.
     */
    List<TicketDTO> findAllWhereGuestIsNull();

    /**
     * Get Ticket by Guest id, ticket type id and order id
     *
     * @param guestId      Guest id
     * @param ticketTypeId Ticket type id
     * @param orderId      Order id - string from WooComerce
     * @return Ticket Dto
     */
    Optional<TicketDTO> findByGuestIdTicketTypeAndOrderId(Long guestId, Long ticketTypeId, String orderId);

    /**
     * Get the "id" ticket.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<TicketDTO> findOne(Long id);

    /**
     * Get the ticket by UUID number
     *
     * @param uuid UUID number
     * @return
     */
    Optional<TicketDTO> findByUUID(String uuid);

    /**
     * Regenerates Ticket PDF
     *
     * @param id
     * @return
     */
    Optional<TicketDTO> regenerateTicketPdf(Long id) throws DocumentException, IOException;

    /**
     * Validate ticket
     *
     * @param id Ticket id
     * @return
     */
    void validateTicket(Long id);

    /**
     * Delete the "id" ticket.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
