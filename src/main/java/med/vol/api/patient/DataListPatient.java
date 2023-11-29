package med.vol.api.patient;

public record DataListPatient(String nome, String email, String telefone) {
    public DataListPatient(Patient patient){
        this(patient.getNome(), patient.getEmail(), patient.getTelefone());
    }
}
