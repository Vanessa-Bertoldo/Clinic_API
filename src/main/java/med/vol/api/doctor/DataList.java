package med.vol.api.doctor;

import med.vol.api.patient.Patient;

public record DataList(String nome, String email, String crm, Specialty especialidade) {
    public DataList(Doctor doctor){
        this(doctor.getNome(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialidade());
    }


}
