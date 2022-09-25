package br.com.projetoMM.service;

import br.com.projetoMM.model.Pessoa;
import br.com.projetoMM.model.Processo;
import br.com.projetoMM.repository.ProcessoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProcessoService {

    @Autowired
    private ProcessoRepository repo;
    
    
    public List<Processo> findAll(int page, int size){
        Pageable p = PageRequest.of(page, size);
        return repo.findAll(p).toList();
    }
    
    public List<Processo> findAll(){
        return repo.findAll();
    }
    
    public Processo findById(Long id){
        Optional<Processo> result = repo.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException("Processo não encontrado.");
        }
        return result.get();
    }
    
    public Processo save(Processo p){
        
        try{
            return repo.save(p);
        }catch (Exception e){
            throw new RuntimeException("falha ao salvar o processo.");
        }
    }
    
    public Processo update(Processo p){
        Processo obj = findById(p.getNProcesso());
         
        try{
            return repo.save(p);
        }catch (Exception e){
            throw new RuntimeException("falha ao atualizar o processo.");
        }
    }
    
    
    public void delete(Long id){
        Processo obj = findById(id);
        
       try{
            repo.delete(obj);
        }catch (Exception e){
            throw new RuntimeException("falha ao deletar o processo.");
        }
        
    }
    

}
