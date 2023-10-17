package edu.ifmt.confeitaria.layers.controllers.authentication;

import java.awt.Frame;
import java.awt.Window;

import edu.ifmt.confeitaria.layers.controllers.main.MainController;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.layers.views.authentication.AutenticacaoView;

public class AutenticacaoController {
    private static AutenticacaoController instance;
    private AutenticacaoView autenticacaoView;
    private final UsuarioService usuarioService;
   
    private AutenticacaoController(UsuarioService usuarioService) {
        //Injeção de dependências
        this.usuarioService = usuarioService;

        //Instancia a View e define esta instância como seu controlador
        this.autenticacaoView = new AutenticacaoView(this);

        //Toda vez que o usuário for alterado, verifica se ele está logado
        this.usuarioService.getLoggedUser().subscribe(this::requireLogin);
    }

    public static AutenticacaoController getInstance() {
        if(AutenticacaoController.instance == null) {
            AutenticacaoController.instance = new AutenticacaoController(UsuarioService.getInstance());
        }
        return AutenticacaoController.instance;
    }

    public void displayView(){ 
        this.autenticacaoView.setVisible(true);
    }
    
    public void signIn(String login, String senha) {
        if(this.usuarioService.signIn(login, senha)) {
            this.autenticacaoView.dispose();
            new MainController().displayView();
        } else {
            this.autenticacaoView.showErrorMessage();
        }
    }

    public void requireLogin(Usuario usuario) {
        /*Verifica se o usuário está logado, se não estiver, 
        fecha todas as janelas e exibe a tela de login*/
        if(usuario.getID() == null) {
            // Obtém uma lista de todas as janelas abertas
            Window[] janelas = Frame.getFrames();
    
            // Fecha todas as janelas
            for (Window janela : janelas) {
                janela.dispose();
            }
            
            //Cria uma nova instância da tela de login e a exibe
            this.autenticacaoView = new AutenticacaoView(this);
            this.displayView();
        }
    }
}