package br.com.projetoMM.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
public class Processo implements Serializable {
    private static  final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(nullable = false)
    //@NotBlank(message = "Dado obrigatorio")
    private Float valor;
    
    @Column(length = 300, nullable = false)
    @NotBlank(message = "Dado obrigatório.")
    @Length(max = 300, message = "No máximo 300 caracteres")
    private String TipoProcesso, Descricao;
        
    public Processo() {
    }
    

    public Processo(long id, Float valor, String TipoProcesso, String Descricao) {
        this.id = id;
        this.valor = valor;
        this.TipoProcesso = TipoProcesso;
        this.Descricao = Descricao;
    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTipoProcesso() {
        return TipoProcesso;
    }

    public void setTipoProcesso(String TipoProcesso) {
        this.TipoProcesso = TipoProcesso;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Processo other = (Processo) obj;
        return this.id == other.id;
    }
    
    
    
    
    
    
    
}
