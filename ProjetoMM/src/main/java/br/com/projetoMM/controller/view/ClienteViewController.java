package br.com.projetoMM.controller.view;

import br.com.projetoMM.model.Cliente;
import br.com.projetoMM.service.ClienteService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path="/clientes")
public class ClienteViewController {
    @Autowired
    private ClienteService service;
    
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("clientes",service.findAll());
        return "clientes";
    }
    
    @GetMapping(path="/cliente")
    public String cadastro(Model model){
        model.addAttribute("clientes",new Cliente());
        return "FormCliente";
    }
    
//    @GetMapping(path="/cliente")
//    public String salvar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model){
//        if(result.hasErrors()){
//            model.addAttribute("msgErrors",result.getAllErrors());
//            return "FormCliente";
//        }
//        
//        try{
//            service.save(cliente);
//            model.addAttribute("msgSucesso","Cliente cadastrado com sucesso");
//            model.addAttribute("cliente",new Cliente());
//        }catch(Exception e){
//            model.addAttribute("msgErros",new ObjectError("cliente",e.getMessage()));
//        }
//        
//    }
}
