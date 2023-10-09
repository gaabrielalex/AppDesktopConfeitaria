/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class PedidoController extends SuperController {
    private final PedidoView pedidoView;
    
    public PedidoController(JFrame previousView) {
        this.pedidoView = new PedidoView(this, new ItemPedidoController(), new DatabaseAccessComponentManager(), new DatabaseAccessComponentManager(), previousView);
    }

    @Override
    public void displayView() {
        this.pedidoView.setVisible(true);
    }
    
    public void requestDisplayClienteViewForLookUp() {
        new ClienteController(this.pedidoView).displayViewForLookUp();
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

    @Override
    public boolean update(Object object, Object originalObject) {
        // TODO Auto-generated method stub
        return false;
    }
}
