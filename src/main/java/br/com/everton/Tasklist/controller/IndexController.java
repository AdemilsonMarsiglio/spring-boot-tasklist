package br.com.everton.Tasklist.controller;

import br.com.everton.Tasklist.model.Tarefa;
import br.com.everton.Tasklist.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ademilson
 * @since 28/08/2018
 */
@Controller
@RequestMapping({"/", "/tarefa"})
public class IndexController {
   
    
    private List<Tarefa> listaTarefa = new ArrayList();
    
    
    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("tarefa/index");
        modelAndView.addObject("tarefa", listaTarefa);
        return modelAndView;
    } 
    
    
    @GetMapping("/novo")
    public ModelAndView novoUsuario() {
        ModelAndView modelAndView = new ModelAndView("tarefa/form");
        modelAndView.addObject("tarefa", new Tarefa());
        return modelAndView;
    }
    
    @PostMapping("/gravar")
    public ModelAndView gravarUsuario(Tarefa tarefa) {
        
        if (tarefa.getId() == null) {
            tarefa.setId(listaTarefa.size() + 1L);
            listaTarefa.add(tarefa);
        } else {
            for (int i = 0; i < listaTarefa.size(); i++) {
                Tarefa t = listaTarefa.get(i);
                if (tarefa.getId().equals(t.getId())) {
                    listaTarefa.set(i, tarefa);
                    break;
                }
            }
        }
        
        
        
        return new ModelAndView("redirect:/tarefa");
    }  
    
    @GetMapping("/editar/{id}")
    public ModelAndView novoUsuario(@PathVariable Long id) {
        
        Tarefa tarefaAlterar = null;
        
        for (Tarefa tarefa : listaTarefa) {
            if (id.equals(tarefa.getId())) {
                tarefaAlterar = tarefa;
                break;
            }
        }
        
        
        if (tarefaAlterar != null) {
            ModelAndView modelAndView = new ModelAndView("tarefa/form");
            modelAndView.addObject("tarefa", tarefaAlterar);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/tarefa/novo");
        }
    }
}

