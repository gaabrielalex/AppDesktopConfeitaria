/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.ifmt.confeitaria;

import edu.ifmt.confeitaria.layers.controllers.authentication.AutenticacaoController;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

/**
 *
 * @author Gabriel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Definindo o tema da aplicação
        NimbusTheme.setTheme();
        
        //Iniciando a interface de start da aplicação: interface de login
        new AutenticacaoController().displayView();
     
    }
}
