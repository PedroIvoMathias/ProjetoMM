 package br.com.projetoMM.model;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.Valid;
import org.hibernate.validator.constraints.br.CPF;


@Entity// não preciso definir o ID pq ele já erda da classe pessoa
public class Cliente extends Pessoa {
    
    @Column(nullable = false , length = 15, updatable = false)
    @CPF(message = "CPF Inválido.")
    private String CPF;
    
    //@JsonBackReference da ruim pra mapear listas.
    @JsonIgnore
    @ManyToMany(mappedBy = "clientes")
    @Valid
    private List<Advogado> advogados = new ArrayList<>();


    public Cliente() {
    }
    public Cliente(String CPF, long ID, String Nome, String Email, String Telefone) {
        super(ID, Nome, Email, Telefone);
        this.CPF = CPF;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public List<Advogado> getAdvogados() {
        return advogados;
    }

    public void addAdvogado(Advogado adv){
        advogados.add(adv);
    }
    
    public void removeAdvogado(Advogado adv){
        advogados.remove(adv);
    }
    
    
}
