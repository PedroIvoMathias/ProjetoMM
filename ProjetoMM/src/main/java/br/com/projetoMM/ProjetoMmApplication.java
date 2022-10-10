package br.com.projetoMM;

import br.com.projetoMM.model.Advogado;
import br.com.projetoMM.model.Cliente;
import br.com.projetoMM.model.Endereco;
import br.com.projetoMM.model.Processo;
import br.com.projetoMM.repository.AdvogadoRepository;
import br.com.projetoMM.repository.ClienteRepository;
import br.com.projetoMM.repository.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoMmApplication implements CommandLineRunner{
    @Autowired
        private ClienteRepository clienteRepo;
    @Autowired
        private AdvogadoRepository advogadoRepo;
    @Autowired
        private ProcessoRepository processoRepo;
    
    

	public static void main(String[] args) {
		SpringApplication.run(ProjetoMmApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        
        
        //Cliente
        Cliente c1 = new Cliente();
        c1.setNome("Jose Lucas");
        c1.setCPF("915.848.480-90");
        c1.setEmail("joselucas@gmail.com");
        c1.setTelefone("(22)99999-8867");
        
        Endereco end = new Endereco();
        end.setBairro("Floral");
        end.setCEP("28000-000");
        end.setCidade("Campos");
        end.setNumero(123);
        end.setRua("Rua das flores");
        
        c1.setEndereco(end);
        clienteRepo.save(c1);
        
        
        Cliente c2 = new Cliente();
        c2.setNome("Eden");
        c2.setCPF("915.848.480-90");
        c2.setEmail("eden@gmail.com");
        c2.setTelefone("(22)99339-8867");
        
        Endereco end3 = new Endereco();
        end3.setBairro("Caju");
        end3.setCEP("28000-000");
        end3.setCidade("Campos");
        end3.setNumero(123);
        end3.setRua("Rua rocha leão");
        
        c2.setEndereco(end3);
        clienteRepo.save(c2);
        
        
        
        
        
        
        //Advogados
        Advogado adv = new Advogado();
        
        adv.setNome("Phill");
        adv.setTelefone("(22)99976-9956");
        adv.setSalario(5000.00f);
        adv.setEmail("phill@gmail.com");
        adv.setBonus(1500.00f);
        adv.setCarteiraOAB("01234567");
        adv.addCliente(c1);
        adv.addCliente(c2);
        
        Endereco end2 = new Endereco();
        end2.setBairro("Guatemala 2");
        end2.setCEP("14040-000");
        end2.setCidade("Campos");
        end2.setNumero(321);
        end2.setRua("Rua da guatemala");
        
        adv.setEndereco(end2);
        advogadoRepo.save(adv);
        
        
        
        Advogado adv2 = new Advogado();
        
        adv2.setNome("Esmeralda");
        adv2.setTelefone("(22)96976-9956");
        adv2.setSalario(6000.00f);
        adv2.setEmail("esmeralda@gmail.com");
        adv2.setBonus(2500.00f);
        adv2.setCarteiraOAB("01464567");
        //adv2.addCliente(c1);
        //adv2.addCliente(c2);
        
        Endereco end4 = new Endereco();
        end4.setBairro("Eucaristo");
        end4.setCEP("90872-000");
        end4.setCidade("Macaé");
        end4.setNumero(142);
        end4.setRua("Tabuão da 7");
        
        
        adv2.setEndereco(end4);
        advogadoRepo.save(adv2);
        
        
        
        
        
        
        //processos
        Processo processo = new Processo();
        processo.setValor(1500.00f);
        processo.setTipoProcesso("Juridico");
        processo.setDescricao("Alguma descrição que não consegui bolar no momento");
        processoRepo.save(processo);
        
        adv.adicionar(processo);
        advogadoRepo.save(adv);
                
        //c1.adicionar(processo);
        //clienteRepo.save(c1);
        
        
        //testar colocando a classe processo ligada em Advogado com um campo cliente
        //tirar a lista de cliente e jogar para adv e colocar um atributo do tipo lista em processos de clientes
        //testar para ver no que dá
        
        
        
        
        
        
       
        
        
        
        
        
        
        
    }

}
