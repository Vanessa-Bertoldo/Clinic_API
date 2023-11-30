package med.vol.api.doctor;

import jakarta.validation.constraints.NotNull;
import med.vol.api.address.DataAddress;

public record DataUpdate(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DataAddress address

) {
}
