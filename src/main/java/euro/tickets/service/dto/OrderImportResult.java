package euro.tickets.service.dto;

import euro.tickets.service.ValidationResult;
import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class OrderImportResult implements Serializable {
    private GuestDTO guest;
    private TicketDTO ticket;

    private OrderRecord orderRecord;
    private ValidationResult validation;

    private boolean processed;
    private Set<String> messages = new HashSet<>();

    public boolean success() {
        return processed && validation.valid();
    }
    public boolean failed() {
        return !success();
    }

    public void addMessage(String message) {
        messages.add(message);
    }
}
