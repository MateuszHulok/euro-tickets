package euro.tickets.service.dto;

import euro.tickets.domain.Promotor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

/**
 * A Create(save) DTO for the {@link Promotor} entity.
 */
@Data
public class PromotorUpdateDTO implements Serializable {
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    private String email;

    private String phoneNumber;

    @Size(max = 500)
    private String notes;

    private Set<String> newPromoCodes;
}
