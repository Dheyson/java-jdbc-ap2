/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc_template.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;
import view.TelaAssociado;
import view.TelaEsporte;
import view.TelaPrincipal;
import view.TelaTecnico;
import view.TelaUsuario;


public class AppController implements ActionListener{

   private final TelaUsuario usuario;
   private final Login login;
   private final TelaPrincipal principal;
   private final TelaAssociado associado;
   private final TelaEsporte esporte;
   private final TelaTecnico tecnico;

    public AppController(TelaUsuario usuario, Login login, TelaPrincipal principal, TelaAssociado associado, TelaEsporte esporte, TelaTecnico tecnico) {
        this.usuario = usuario;
        this.login = login;
        this.principal = principal;
        this.associado = associado;
        this.esporte = esporte;
        this.tecnico = tecnico;
    }
    
       
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getjBotaoLogin()) {
            
        }
    }
    
   
}
