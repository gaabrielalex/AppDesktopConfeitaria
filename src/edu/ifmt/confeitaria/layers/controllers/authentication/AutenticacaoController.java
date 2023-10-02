/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.authentication;

import edu.ifmt.confeitaria.layers.controllers.main.MainController;
import edu.ifmt.confeitaria.layers.views.authentication.AutenticacaoView;

/** 
 *
 * @author Gabriel
 */
public class AutenticacaoController {
    //Atributos
    private final AutenticacaoView autenticacaoView;
   
    //Constructors
    public AutenticacaoController() {
        this.autenticacaoView = new AutenticacaoView(this);
    }

    //Getters e Setters  
 
    //Métodos
    public void displayView(){ 
        this.autenticacaoView.setVisible(true);
    }
    
    public void signIn() {
        this.autenticacaoView.dispose();
        new MainController().displayView();
    }
}
