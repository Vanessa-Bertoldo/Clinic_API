package med.vol.api.doctor;

import med.vol.api.address.DataAddress;

public record RegisterDataDoctor(String nome, String email, String crm, Specialty especialidade, DataAddress endereco) {
}
