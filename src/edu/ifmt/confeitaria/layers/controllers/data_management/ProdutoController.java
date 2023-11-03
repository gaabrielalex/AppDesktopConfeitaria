/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoService;
import edu.ifmt.confeitaria.layers.views.data_management.ProdutoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

public class ProdutoController extends SuperController<Produto> {
    private final ProdutoView produtoView;
    private final ProdutoService produtoService;
    private DatabaseAccessComponentManager<Produto> produtoDBCManager;
    
    public ProdutoController(JFrame previousView, ProdutoService produtoService, DatabaseAccessComponentManager<Produto> produtoDBCManager) {
        //Injeção de dependências
        this.produtoDBCManager = produtoDBCManager;
        this.produtoService = produtoService;

        //Instancia a View e define esta instância como seu controlador
        this.produtoView = new ProdutoView(this, previousView);

        //Configurando o DatabaseAccessComponentManager
        List<Component> fields = Arrays.asList(produtoView.getEdtDescricao(), produtoView.getEdtObs(), 
            produtoView.getEdtVlrUnt(), produtoView.getCmbTipoChoc());
        this.produtoDBCManager.setFields(fields);
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

   public void partialSearch(String descricao, String tipoChocolate) {
        this.produtoDBCManager.setTemporaryTDataList(this.produtoService.partialSearch(descricao, tipoChocolate));
    }

    @Override
    public Object[] modelToTableRow(Produto produto) {
        return new Object[]{
            produto.getID(),
            produto.getDescricao(),
            produto.getTipoChocolate(),
            produto.getVlrUnitario(),
            produto.getObservacoes()
        };
    }

    @Override
    public void modelToFields(Produto produto) {
        this.produtoView.getEdtDescricao().setText(produto.getDescricao());
        this.produtoView.getEdtObs().setText(produto.getObservacoes());
        this.produtoView.getEdtVlrUnt().setText(produto.getVlrUnitario().toString());
        this.produtoView.getCmbTipoChoc().setSelectedItem(produto.getTipoChocolate());
    }

    @Override
    public Produto fieldsToModel() {
        return new Produto(
            null,
            this.produtoView.getEdtDescricao().getText(),
            new BigDecimal(this.produtoView.getEdtVlrUnt().getText()),
            this.produtoView.getEdtObs().getText(),
            this.produtoView.getCmbTipoChoc().getSelectedItem().toString()
        );
    }

}
