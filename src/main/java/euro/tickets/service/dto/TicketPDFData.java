package euro.tickets.service.dto;

import euro.tickets.domain.Guest;
import euro.tickets.domain.Promotor;
import euro.tickets.domain.TicketType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TicketPDFData {
    private final String uuid;
    private final byte[] qrFile;
    private final String qrFileContentType;
    private final TicketType ticketType;
    private final Guest guest;
    private final Promotor promotor;
}
