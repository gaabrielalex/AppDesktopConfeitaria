/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.main;

import edu.ifmt.confeitaria.layers.views.main.MainView;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

/**
 *
 * @author Gabriel
 */
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
    
}
