/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.views.data_management.ProdutoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

/**
 *
 * @author Gabriel
 */
public class ProdutoController extends SuperController {
    private final ProdutoView produtoView;
    private DatabaseAccessComponentManager produtoDBCManager;
    
    public ProdutoController(JFrame previousView, DatabaseAccessComponentManager produtoDBCManager) {
        //Injeção de dependências
        this.produtoDBCManager = produtoDBCManager;

        //Instancia a View e define esta instância como seu controlador
        this.produtoView = new ProdutoView(this, previousView);

        //Configurando o DatabaseAccessComponentManager
        this.produtoDBCManager.configureComponents(null, this, null, produtoView.getBtnInsert(),
            produtoView.getBtnUpdate(), produtoView.getBtnDelete(), produtoView.getBtnPost(),
            produtoView.getBtnCancel(), produtoView.getBtnRefresh(), produtoView.getTblProduto());
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
    public Object[] modelToTableRow(Object object) {
        // TODO Auto-generated method stub
       return null;
    }

    @Override
    public void modelToFields(Object object) {
        // TODO Auto-generated method stub
    }

    @Override
    public Object fieldsToModel() {
        // TODO Auto-generated method stub
        return null;
    }

}
