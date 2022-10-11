 package br.com.projetoMM.service;

import br.com.projetoMM.model.Cliente;
import br.com.projetoMM.model.Pessoa;
import br.com.projetoMM.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repo;
    
    public List<Cliente> findAll(int page, int size){
        Pageable p = PageRequest.of(page, size);
        return repo.findAll(p).toList();
    }
    
    public List<Cliente> findAll(){
        return repo.findAll();
    }
    
    public Cliente findById(long id){
        Optional <Cliente> result = repo.findById(id);
        if(result.isEmpty()){
            throw new RuntimeException("Cliente não encontrado.");
        }
        return result.get();
    }
    
    public Cliente save(Cliente c){
        
        verificaNomeEmailCadastrado(c.getNome(), c.getEmail());
        try{
            return repo.save(c);
        }catch(Exception e){
            throw new RuntimeException("Falha ao salvar o cliente.");
        }        
    }
    
    public Cliente update(Cliente c){
        Cliente obj = findById(c.getID());
        
        try{
            return repo.save(c);
        }catch(Exception e){
            throw new RuntimeException("falha ao atualizar o cliente.");
        }
    }
    
    public void delete(Long id){
        Cliente obj = findById(id);
        verificaExclusaoCliente(obj);
        
        try{
            repo.delete(obj);
        }catch(Exception e){
            throw new RuntimeException("falha ao excluir cliente.");
        }
        
    }
    
    private void verificaNomeEmailCadastrado(String Nome, String Email){
        
        List<Pessoa> result = repo.findByNomeOrEmail(Nome, Email);
        if(!result.isEmpty()){
            throw new RuntimeException("Nome ou Email já cadastrados!");
        }
    }
    
    private void verificaExclusaoCliente(Cliente c){
        if(!c.getAdvogados().isEmpty()){
            throw new RuntimeException("Cliente ainda possui um advogado da empresa. Não pode ser excluído.");
        }
    }
}
