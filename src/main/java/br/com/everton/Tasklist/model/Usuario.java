package br.com.everton.Tasklist.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author ademilson
 * @since 28/08/2018
 */
@Data
public class Usuario implements Serializable{
    private Long id;
    private String usuario;
    private String senha;
}
