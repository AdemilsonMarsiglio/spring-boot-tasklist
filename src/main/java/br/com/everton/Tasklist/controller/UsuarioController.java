package br.com.everton.Tasklist.controller;

import br.com.everton.Tasklist.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ademilson
 * @since 28/08/2018
 */
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    private List<Usuario> listaUsuario = new ArrayList();
    
    
    @GetMapping
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("usuario/usuario");
        modelAndView.addObject("usuarios", listaUsuario);
        
        return modelAndView;
    } 
    
    
    @GetMapping("/novo")
    public ModelAndView novoUsuario() {
        ModelAndView modelAndView = new ModelAndView("usuario/form");
        modelAndView.addObject("usuario", new Usuario());
        return modelAndView;
    }
    
    @PostMapping("/gravar")
    public ModelAndView gravarUsuario(Usuario usuario) {
        
        usuario.setId(listaUsuario.size() + 1L);
        
        listaUsuario.add(usuario);
        return new ModelAndView("redirect:/usuario");
    }  
    
    @GetMapping("/editar/{id}")
    public ModelAndView novoUsuario(@PathVariable Long id) {
        
        Usuario usuarioAlterar = null;
        
        for (Usuario usuario : listaUsuario) {
            if (id.equals(usuario.getId())) {
                usuarioAlterar = usuario;
                break;
            }
        }
        
        
        if (usuarioAlterar != null) {
            ModelAndView modelAndView = new ModelAndView("usuario/form");
            modelAndView.addObject("usuario", usuarioAlterar);
            return modelAndView;
        } else {
            return new ModelAndView("redirect:/usuario/novo");
        }
    }
    
    
//    @GetMapping("/all")
//    public ResponseEntity<List<Usuario>> home() {
//        return ResponseEntity.ok(listaUsuario);
//    } 
    
    
    
//    @GetMapping("/all")
//    public ResponseEntity<List<Usuario>> listarTodosUsuarios() {
//        return ResponseEntity.ok(listaUsuario);
//    }  
//    
//    @DeleteMapping("{id}")
//    public ResponseEntity<String> removerUsuario(@PathVariable Long id) {
//        return ResponseEntity.ok("Usuário Removido com sucesso! " + id);
//    }  
}

