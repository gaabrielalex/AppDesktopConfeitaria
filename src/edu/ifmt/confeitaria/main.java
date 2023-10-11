package edu.ifmt.confeitaria;

import edu.ifmt.confeitaria.layers.controllers.authentication.AutenticacaoController;
import edu.ifmt.confeitaria.util.themes.NimbusTheme;

public class Main {

    public static void main(String[] args) {
        //Definindo o tema da aplicação
        NimbusTheme.setTheme();
        
        //Iniciando a interface de start da aplicação: interface de login
        AutenticacaoController.getInstance().displayView();
    }
}
