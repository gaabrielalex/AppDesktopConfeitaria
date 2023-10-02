/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import edu.ifmt.confeitaria.layers.views.data_management.ProdutoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class ProdutoController extends SuperController {
    private final ProdutoView produtoView;
    
    public ProdutoController(JFrame previousView) {
        this.produtoView = new ProdutoView(this, new DatabaseAccessComponentManager(), previousView);
    }

    @Override
    public void displayView() {
        this.produtoView.setVisible(true);
    }
    
    public void displayViewForLookUp() {
        //Configurações obrigatórias
        this.produtoView.setTitle("Pesquisa de Produtos");
        this.produtoView.setResizable(false);
        this.produtoView.setSize(this.produtoView.getWidth(), 360);

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
    public Object[] modelToTableRow(Object model) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
