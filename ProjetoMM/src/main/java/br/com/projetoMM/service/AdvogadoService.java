package br.com.projetoMM.service;

import br.com.projetoMM.model.Advogado;
import br.com.projetoMM.model.Cliente;
import br.com.projetoMM.repository.AdvogadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AdvogadoService {
    @Autowired
    
    private AdvogadoRepository repo;
    
    public List<Advogado> findAll (int page, int size){

        Pageable p = PageRequest.of(page, size);
        return repo.findAll(p).toList();
    }
    public List<Advogado> findAll (){
        return repo.findAll();
    }
    
    public Advogado findById(Long id){
        Optional<Advogado> result = repo.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException ("Advogado não encontrado");
        }
        return result.get();
    }
    
    public Advogado save(Advogado a){
        try{
            return repo.save(a);
            
        }catch(Exception e){
            throw new RuntimeException ("falha ao salvar o Advogado.");
        }
    }
    
    public Advogado update (Advogado a){
        Advogado obj = findById(a.getID());
        
        List<Cliente> clientesAtuais = obj.getClientes();
        clientesAtuais.removeAll(a.getClientes());
        //obj.getClientes().removeAll(a.getClientes());
        verificaExclusaoDoAdvComClientes(obj);
        try{
            return repo.save(a);    
        }catch(Exception e){
            throw new RuntimeException("Falha ao atualizar o Advogado.");
        }    
    }
    
    public void delete(Long id){
        Advogado obj = findById(id);
        verificaExclusaoDoAdvComClientes(obj);
        try{
            repo.save(obj);    
        }catch(Exception e){
            throw new RuntimeException("Falha ao deletar o Advogado.");
        }    
    }
    
    private void verificaExclusaoDoAdvComClientes(Advogado adv){
//        for(Advogado a : adv){
//            if(!a.getClientes().isEmpty()){
//                throw new RuntimeException("Não é possível excluir advogado que contenham clientes.");
//            }
//        }
    if(!adv.getClientes().isEmpty()){
            throw new RuntimeException("Não é possível excluir um advogado que contenha um cliente.");
        }
    }
}
