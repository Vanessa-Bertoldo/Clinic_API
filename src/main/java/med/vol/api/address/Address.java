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

    public void updateInfoAddress(DataAddress address) {
        if(address != null){
            this.logradouro     = address.logradouro() != null ? address.logradouro() : this.logradouro;
            this.bairro         = address.bairro() != null ? address.bairro() : this.bairro;
            this.cep            = address.cep() != null ? address.cep() : this.cep;
            this.uf             = address.uf() != null ? address.uf() : this.uf;
            this.cidade         = address.cidade() != null ? address.cidade() : this.cidade;
            this.numero         = address.cidade() != null ? address.numero() : this.numero;
            this.complemento    = address.complemento() != null ? address.complemento() : this.complemento;
        }

    }
}
