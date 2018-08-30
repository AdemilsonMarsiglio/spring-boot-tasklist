/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.everton.Tasklist.util;

import br.com.everton.Tasklist.model.Usuario;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ademilson
 * @since 29/08/2018
 */
public class Util {

    public static Usuario getUsuarioBySession(HttpSession session) {
        return (Usuario) session.getAttribute(Key.LOGIN_SESSION);
    }
    
}
