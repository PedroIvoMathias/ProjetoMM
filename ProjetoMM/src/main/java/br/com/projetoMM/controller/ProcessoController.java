package br.com.projetoMM.controller;

import br.com.projetoMM.model.Cliente;
import br.com.projetoMM.model.Processo;
import br.com.projetoMM.service.ClienteService;
import br.com.projetoMM.service.ProcessoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/apirest/processo")
public class ProcessoController {
    
    @Autowired
    private ProcessoService service;
    
    
    @GetMapping
    public ResponseEntity getAll(@RequestParam(name = "page",defaultValue = "0", required = false) int page, 
                                 @RequestParam(name = "size",defaultValue = "10", required = false) int size){
        
        return ResponseEntity.ok(service.findAll(page, size));
    }
    
    
    @GetMapping(path = "/{id}")
    public ResponseEntity getOne(@PathVariable("id") Long id){
        //service.findById(id);
        return ResponseEntity.ok(service.findById(id));
    }
    
    @PostMapping
    public ResponseEntity save(@Valid @RequestBody Processo processo){
        //advogado.setID(null);
        service.save(processo);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(processo);
    }
    
    
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id")Long id, @Valid @RequestBody Processo processo){
        processo.setid(id);
        service.update(processo);
        
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
    
    @DeleteMapping(path = "/{id}")
    public ResponseEntity delete(@PathVariable ("id") Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
}
