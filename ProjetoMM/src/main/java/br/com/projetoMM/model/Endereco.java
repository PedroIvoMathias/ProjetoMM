package br.com.projetoMM.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Embeddable
public class Endereco implements Serializable {
    private static  final long serialVersionUID = 1L;
    
    @Column(nullable = false, length = 70)
    @NotBlank(message = "Dado obrigatório.")
    @Length(max = 70, message = "Dado deve ter no máximo 70 caracteres")
    private String Rua, Bairro, Cidade;
    
    @Column(nullable = false, length = 9)
    @NotBlank(message = "Dado obrigatório.")
    @Length(max = 9,min = 9, message = "Dado deve ter exatamente 9 caracteres (Ex: 99999-999).")
    private String CEP;
    
    @Column(nullable = false)
    @Digits (integer = 4, fraction = 0, message = "Número deve ser inteiro e ter até 4 digitos.")
    private int Numero;

    public Endereco() {
    
    }

    
    public Endereco(String Rua, String Bairro, String Cidade, String CEP, int Numero) {
        this.Rua = Rua;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.CEP = CEP;
        this.Numero = Numero;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.Rua);
        hash = 97 * hash + Objects.hashCode(this.Bairro);
        hash = 97 * hash + Objects.hashCode(this.Cidade);
        hash = 97 * hash + Objects.hashCode(this.CEP);
        hash = 97 * hash + this.Numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Endereco other = (Endereco) obj;
        if (this.Numero != other.Numero) {
            return false;
        }
        if (!Objects.equals(this.Rua, other.Rua)) {
            return false;
        }
        if (!Objects.equals(this.Bairro, other.Bairro)) {
            return false;
        }
        if (!Objects.equals(this.Cidade, other.Cidade)) {
            return false;
        }
        return Objects.equals(this.CEP, other.CEP);
    }
    
    
}
