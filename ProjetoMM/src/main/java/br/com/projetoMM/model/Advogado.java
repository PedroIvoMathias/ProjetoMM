package br.com.projetoMM.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Entity
public class Advogado extends Pessoa{
    
    @Column(nullable = false, length = 20, updatable = false)
    @NotBlank(message = "Carteira OAB obrigatória.")
    private String CarteiraOAB;
    
    @Column(nullable = false)
    private Float Salario, Bonus;
    
    //@JsonManagedReference
    @ManyToMany//dono, na verdade não acho que seja 100% dono, vou ter que ver depois novamente essa notação.
    @Valid
    private List<Cliente> clientes = new ArrayList<>();
    
    //foi o que eu coloquei para testar os processos nessa classe no lugar da classe Pessoa.
    @OneToMany
    @Valid
    private List<Processo> processos = new ArrayList<>();

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
    
    public List<Processo> getProcessos() {
        return processos;
    }
    
    public void adicionar (Processo processo){
        processos.add(processo);
    }
    
    public void remove (Processo processo){
        processos.remove(processo);
    }
    
}
