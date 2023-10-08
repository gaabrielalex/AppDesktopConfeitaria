/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import edu.ifmt.confeitaria.layers.views.data_management.ClienteView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class ClienteController extends SuperController {
    private final ClienteView clienteView;
    
    public ClienteController(JFrame previousView) {
        this.clienteView = new ClienteView(this, new DatabaseAccessComponentManager(),previousView);
    }
    
    @Override
    public void displayView() {
        this.clienteView.setVisible(true);
    }
    
    public void displayViewForLookUp() {
        //Configurações obrigatórias
        this.clienteView.setTitle("Pesquisa de Clientes");
        this.clienteView.setResizable(false);
        this.clienteView.setSize(this.clienteView.getWidth(), 360);

        //Exibe a view
        this.displayView();
    }

    @Override
    public List<?> select() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<?> remakeLastSelect() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean insert(Object modelObject) {
        // TODO Auto-generated method stub
        return false;
    }

}
