package med.vol.api.patient;

import jakarta.validation.constraints.NotNull;
import med.vol.api.address.DataAddress;

public record DataUpdatePatient(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DataAddress address

) {
}
