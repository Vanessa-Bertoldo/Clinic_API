package med.vol.api.patient;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.address.Address;

@Getter //faz com que seja gerado automaticamente métodos getters para os campos
@EqualsAndHashCode //gera automaticamente os métodos 'equals()' e 'hasCode()'
@NoArgsConstructor //gera um construtor sem argumentos
@AllArgsConstructor //gera um construtor com todos os argumentos
@Entity(name = "Pacient")
@Table(name = "patient")
public class Patient {
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Boolean ativo;
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded //usado para especificar que esse atributo representa um tipo incorporável
    private Address endereco;


    public Patient(RegisterDataPatient data) {
        this.ativo              = true;
        this.nome               = data.nome();
        this.email              = data.email();
        this.telefone           = data.telefone();
        this.cpf                = data.cpf();
        this.endereco           = new Address(data.endereco());
    }

    public void updateData(DataUpdatePatient data) {
        this.nome           = data.nome() != null ? data.nome() : this.nome;
        this.email          = data.email() != null ? data.email() : this.email;
        this.telefone       = data.telefone() != null ? data.telefone() : this.telefone;
        this.endereco.updateInfoAddress(data.address());
    }

    public void inactivatePatient() {
        this.ativo = false;
    }
}
