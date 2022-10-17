package br.com.projetoMM.controller.view;

import br.com.projetoMM.model.Advogado;
import br.com.projetoMM.service.AdvogadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/advogados")
public class AdvogadoViewController {
    @Autowired
    private AdvogadoService service;
    
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("advogados",service.findAll());
        return "advogados";
    }

    @GetMapping(path = "/advogado")
    public String cadastro(Model model){
        model.addAttribute("advogados",new Advogado());
        return "FormAdvogado";
    }
    
}
