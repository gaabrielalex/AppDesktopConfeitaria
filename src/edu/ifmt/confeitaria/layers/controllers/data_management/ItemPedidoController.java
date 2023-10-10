/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

/**
 *
 * @author Gabriel
 */
public class ItemPedidoController extends SuperController {
    private final PedidoView pedidoView;
    private DatabaseAccessComponentManager itemPedidoDBCManager;

    public ItemPedidoController(PedidoView pedidoView, DatabaseAccessComponentManager itemPedidoDBCManager) {
        //Injeção de dependências
        this.pedidoView = pedidoView;
        this.itemPedidoDBCManager = itemPedidoDBCManager;

        //Configurando o DatabaseAccessComponentManager
        this.itemPedidoDBCManager.configureComponents(null, this, null, pedidoView.getBtnInsertItemPedido(),
            pedidoView.getBtnUpdateItemPedido(), pedidoView.getBtnDeleteItemPedido(), pedidoView.getBtnPostItemPedido(),
            pedidoView.getBtnCancelItemPedido(), pedidoView.getBtnRefreshItemPedido(), pedidoView.getTblItemPedido());
    }

    /* O método displey view não faz nada, pois a view em que a entidade do sistema
    'item pedido' está inserida, é a view do pedido (por se tratar de um mestre detalhe),
    logo, quem é resposável por exibir a interface do pedido, é a controller da entidade
    principal desta view, a controller do 'pedido'*/
    @Override
    public void displayView() {}
    
    public void requestDisplayProdutoViewForLookUp(JFrame current) {
        new ProdutoController(current, new DatabaseAccessComponentManager()).displayViewForLookUp();
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
