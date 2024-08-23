package euro.tickets.service.dto;

import euro.tickets.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A DTO for the {@link Ticket} entity.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketCreateDTO implements Serializable {
    @NotNull
    private Long ticketTypeId;

    private Long promoCodeId;

    @NotNull
    private Long guestId;
    private Long promotorId;

    @NotNull
    private String orderId;

    private String ticketPrice;
}
