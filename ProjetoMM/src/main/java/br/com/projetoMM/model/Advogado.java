package br.com.projetoMM.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Advogado extends Pessoa{
    
    @Column(nullable = false, length = 20, updatable = false)
    private String CarteiraOAB;
    
    @Column(nullable = false)
    private Float Salario, Bonus;
    
    @JsonManagedReference
    @ManyToMany//dono
    private List<Cliente> clientes = new ArrayList<>();

    public Advogado() {
    }

    public Advogado(String CarteiraOAB, Float Salario, Float Bonus, long ID, String Nome, String Email, String Telefone) {
        super(ID, Nome, Email, Telefone);
        this.CarteiraOAB = CarteiraOAB;
        this.Salario = Salario;
        this.Bonus = Bonus;
    }

    

    public String getCarteiraOAB() {
        return CarteiraOAB;
    }

    public void setCarteiraOAB(String CarteiraOAB) {
        this.CarteiraOAB = CarteiraOAB;
    }

    public Float getSalario() {
        return Salario;
    }

    public void setSalario(Float Salario) {
        this.Salario = Salario;
    }

    public Float getBonus() {
        return Bonus;
    }

    public void setBonus(Float Bonus) {
        this.Bonus = Bonus;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void removeCliente(Cliente cliente){
        clientes.remove(cliente);
    }
    
    
    
}
