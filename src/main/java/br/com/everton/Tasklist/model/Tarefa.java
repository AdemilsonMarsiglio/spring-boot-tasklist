package br.com.everton.Tasklist.model;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author ademilson
 * @since 28/08/2018
 */
@Data
public class Tarefa implements Serializable {

    private Long id;
    private String titulo;
    private Status status = Status.NOVO;
    
    private Usuario usuario;
    
    public static enum Status {
        NOVO,
        FAZENDO,
        CONCLUIDO
    }
}
