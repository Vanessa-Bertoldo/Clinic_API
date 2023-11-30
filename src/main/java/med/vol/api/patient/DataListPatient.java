package med.vol.api.patient;

public record DataListPatient(Long id, String nome, String email, String telefone) {
    public DataListPatient(Patient patient){
        this(patient.getId(), patient.getNome(), patient.getEmail(), patient.getTelefone());
    }
}
