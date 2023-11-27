package med.vol.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private  String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Address(DataAddress endereco) {
        this.logradouro     = endereco.logradouro();
        this.bairro         = endereco.bairro();
        this.cep            = endereco.cep();
        this.uf             = endereco.uf();
        this.cidade         = endereco.cidade();
        this.numero         = endereco.cidade();
        this.complemento    = endereco.complemento();
    }
}
