/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

/**
 *
 * @author Gabriel
 */
public class PedidoController extends SuperController {
    private final PedidoView pedidoView;
    private DatabaseAccessComponentManager pedidoDBCManager;
    
    public PedidoController(JFrame previousView, DatabaseAccessComponentManager pedidoDBCManager) {
        //Injeção de dependências
        this.pedidoDBCManager = pedidoDBCManager;

        //Instancia a View e define esta instância como seu controlador
        this.pedidoView = new PedidoView(this, null, previousView);

        //Configura corretamente o ItemPedidoController
        this.pedidoView.setItemPedidoController(new ItemPedidoController(this.pedidoView, new DatabaseAccessComponentManager()));

        //Configurando o DatabaseAccessComponentManager
        List<Component> fields = Arrays.asList(pedidoView.getEdtCliente(), pedidoView.getEdtCliente(), 
            pedidoView.getDtChooserDtEntrega(), pedidoView.getDtChooserDtPedido(), pedidoView.getEdtVlrTotalPedido(), pedidoView.getEdtDesconto(),
            pedidoView.getCmbMtdPagto(), pedidoView.getEdtDestinatario(), pedidoView.getCkBRetirada(), pedidoView.getCmbSttsPagto(), pedidoView.getCmbSttsPedido(), pedidoView.getEdtObs()); 
        this.pedidoDBCManager.setFields(fields);
        this.pedidoDBCManager.configureComponents(null, this, null, pedidoView.getBtnInsertPedido(),
            pedidoView.getBtnUpdatePedido(), pedidoView.getBtnDeletePedido(), pedidoView.getBtnPostPedido(),
            pedidoView.getBtnCancelPedido(), pedidoView.getBtnRefreshPedido(), pedidoView.getTblPedido());
    }

    @Override
    public void displayView() {
        this.pedidoView.setVisible(true);
    }
    
    public void requestDisplayClienteViewForLookUp() {
        new ClienteController(this.pedidoView, new DatabaseAccessComponentManager()).displayViewForLookUp();
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
