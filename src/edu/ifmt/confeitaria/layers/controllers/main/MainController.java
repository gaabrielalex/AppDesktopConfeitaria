package edu.ifmt.confeitaria.layers.controllers.main;

import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.layers.views.main.MainView;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

public class MainController {
    private final MainView mainView; 
    
    public MainController() {
        this.mainView = new MainView(this);
    }
    
    public void displayView(){
        this.mainView.setVisible(true);
    }
    
    public void requestDisplayMenuItemView(SuperController<?> viewController) {  
        /*Solicita ao controller para que ele exiba a sua view */
        viewController.displayView();
    }

    public void requestUserSignOut() {
        UsuarioService.getInstance().signOut();
    }
    
}
