/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_template.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;
import view.TelaUsuario;

/**
 *
 * @author DHEYSON
 */
public class AppController implements ActionListener{

   private final TelaUsuario usuario;

    public AppController(TelaUsuario usuario) {
        this.usuario = usuario;
        this.usuario.getjBotaoAdd().addActionListener(this);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
   
}
