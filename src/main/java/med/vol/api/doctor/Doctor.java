package med.vol.api.doctor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.address.Address;

@Table(name = "doctors")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Boolean ativo;
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty especialidade;
    @Embedded
    private Address address;

    public Doctor(RegisterDataDoctor data) {
        this.ativo              = true;
        this.nome               = data.nome();
        this.email              = data.email();
        this.telefone           = data.telefone();
        this.crm                = data.crm();
        this.especialidade      = data.especialidade();
        this.address            = new Address(data.endereco());
    }

    public void updateData(DataUpdate data) {
        this.nome       = data.nome() != null ? data.nome() : this.nome;
        this.telefone   = data.telefone() != null ? data.telefone() : this.telefone;
        this.address.updateInfoAddress(data.address());
    }

    public void inactivateDoctor() {
        this.ativo = false;
    }
}
