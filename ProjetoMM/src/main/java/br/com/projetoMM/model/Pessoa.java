package br.com.projetoMM.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity // tratar essa classe como entidade e o JPA pode gerenciar ela
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
    private static  final long serialVersionUID = 1L;
    
    @Id// informa que o atributo ID é o id dessa classe, logo toda a declaração fica em cima do atributo
    @GeneratedValue(strategy = GenerationType.IDENTITY)// normalmente se usa o AUTO para poder generalizar a funcionalidade nos bancos, mas nesse caso eu vou usar o identity que é o auto incremente no BD
    private long ID;
    
    @Column(nullable = false, length = 150)// nullabe = pode ser nulo?(not null)
    private String Nome, Email, Telefone;
    
    @Embedded
    private Endereco endereco;
    
    //@ElementCollection(fetch = FetchType.EAGER)
    @OneToMany
    private List<Processo> processos = new ArrayList<>();

   

    public Pessoa() {
        
    }
    
    public Pessoa(long ID, String Nome, String Email, String Telefone) {
        this.ID = ID;
        this.Nome = Nome;
        this.Email = Email;
        this.Telefone = Telefone;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public List<Processo> getProcessos() {
        return processos;
    }
    
    public void adicionar (Processo processo){
        processos.add(processo);
    }
    
    public void remove (Processo processo){
        processos.remove(processo);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.ID ^ (this.ID >>> 32));
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
        final Pessoa other = (Pessoa) obj;
        return this.ID == other.ID;
    }

    
    
    
}
