package br.com.projetoMM.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;


@Entity// não preciso definir o ID pq ele já erda da classe pessoa
public class Cliente extends Pessoa {
    
    @Column(nullable = false , length = 15, updatable = false)
    private String CPF;
    
    @JsonBackReference
    @ManyToMany(mappedBy = "clientes")
    private List<Advogado> advogados = new ArrayList<>();


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
