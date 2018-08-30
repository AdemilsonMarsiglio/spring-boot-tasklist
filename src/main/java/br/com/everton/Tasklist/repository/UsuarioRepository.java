package br.com.everton.Tasklist.repository;

import br.com.everton.Tasklist.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ademilson
 * @since 29/08/2018
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
//    public List<Usuario> findByNomeStartingWith(String nome);
    
    public Usuario findByNomeAndSenha(String name, String senha);
}
