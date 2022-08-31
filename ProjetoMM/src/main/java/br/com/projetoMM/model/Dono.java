package br.com.projetoMM.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dono implements Serializable {
    private static  final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Login;
    
    @Column(length = 10, updatable = true, nullable = false)
    private String Senha;
    
    // @Embedded com isso ele foi pro meu Banco de dados
    private Advogado advogado;
    // @Embedded com isso ele foi pro meu Banco de dados
    private Cliente cliente;

    public Dono() {
    }

    public Dono(String Login, String Senha, Advogado advogado, Cliente cliente) {
        this.Login = Login;
        this.Senha = Senha;
        this.advogado = advogado;
        this.cliente = cliente;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public void setAdvogado(Advogado advogado) {
        this.advogado = advogado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.Login);
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
        final Dono other = (Dono) obj;
        return Objects.equals(this.Login, other.Login);
    }
    
    
}
