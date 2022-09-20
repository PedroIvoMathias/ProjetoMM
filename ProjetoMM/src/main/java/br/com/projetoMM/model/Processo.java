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
    private long NProcesso;
    
    @Column(nullable = false)
    //@NotBlank(message = "Dado obrigatorio")
    private Float valor;
    
    @Column(length = 300, nullable = false)
    @NotBlank(message = "Dado obrigatório.")
    @Length(max = 300, message = "No máximo 300 caracteres")
    private String TipoProcesso, Descricao;

    public Processo() {
    }
    

    public Processo(long NProcesso, Float valor, String TipoProcesso, String Descricao) {
        this.NProcesso = NProcesso;
        this.valor = valor;
        this.TipoProcesso = TipoProcesso;
        this.Descricao = Descricao;
    }

    public long getNProcesso() {
        return NProcesso;
    }

    public void setNProcesso(long NProcesso) {
        this.NProcesso = NProcesso;
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
        hash = 13 * hash + (int) (this.NProcesso ^ (this.NProcesso >>> 32));
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
        return this.NProcesso == other.NProcesso;
    }
    
    
    
    
    
    
    
}
