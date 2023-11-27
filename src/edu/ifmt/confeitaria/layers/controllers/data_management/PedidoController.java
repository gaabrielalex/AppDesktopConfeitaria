package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteDAO;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteService;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.pedido.PedidoService;
import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

public class PedidoController extends SuperController<Pedido> {
    private final PedidoView pedidoView;
    private final PedidoService pedidoService;
    private DatabaseAccessComponentManager<Pedido> pedidoDBCManager;
    
    public PedidoController(JFrame previousView, PedidoService pedidoService, DatabaseAccessComponentManager<Pedido> pedidoDBCManager) {
        //Injeção de dependências
        this.pedidoDBCManager = pedidoDBCManager;
        this.pedidoService = pedidoService;

        //Instancia a View e define esta instância como seu controlador
        this.pedidoView = new PedidoView(this, null, previousView);

        //Configura corretamente o ItemPedidoController
        this.pedidoView.setItemPedidoController(new ItemPedidoController(this.pedidoView, new DatabaseAccessComponentManager()));

        //Configurando o DatabaseAccessComponentManager
        List<Component> fields = Arrays.asList(pedidoView.getEdtCliente(), pedidoView.getEdtCliente(), 
            pedidoView.getDtChooserDtEntrega(), pedidoView.getDtChooserDtPedido(), pedidoView.getEdtVlrTotalPedido(), pedidoView.getEdtDesconto(),
            pedidoView.getCmbMtdPagto(), pedidoView.getEdtDestinatario(), pedidoView.getCkBRetirada(), pedidoView.getCmbSttsPagto(), pedidoView.getCmbSttsPedido(), pedidoView.getEdtObs()); 
        this.pedidoDBCManager.setFields(fields);
        this.pedidoDBCManager.configureComponents(Pedido.class, this, this.pedidoService, pedidoView.getBtnInsertPedido(),
            pedidoView.getBtnUpdatePedido(), pedidoView.getBtnDeletePedido(), pedidoView.getBtnPostPedido(),
            pedidoView.getBtnCancelPedido(), pedidoView.getBtnRefreshPedido(), pedidoView.getTblPedido());
    }

    @Override
    public void displayView() {
        this.pedidoView.getCmbSttsPagto().removeAllItems();
        this.pedidoView.getCmbSttsPedido().removeAllItems();
        this.pedidoView.getCmbMtdPagto().removeAllItems();
        this.pedidoView.getCmbSttsPagtoFiltro().removeAllItems();
        this.pedidoView.getCmbSttsPedidoFiltro().removeAllItems();
        for (Pedido.StatusPagto value : Pedido.StatusPagto.values()) {
            this.pedidoView.getCmbSttsPagto().addItem(Character.toString(value.getDescricao()));
            this.pedidoView.getCmbSttsPagtoFiltro().addItem(Character.toString(value.getDescricao()));
        }
        for (Pedido.StatusPedido value : Pedido.StatusPedido.values()) {
            this.pedidoView.getCmbSttsPedido().addItem(Character.toString(value.getDescricao()));
            this.pedidoView.getCmbSttsPedidoFiltro().addItem(Character.toString(value.getDescricao()));
        }
        for (String value : this.pedidoService.selectAllMetodoPagto()) {
            this.pedidoView.getCmbMtdPagto().addItem(value);
        }

        this.pedidoView.setVisible(true);
    }
    
    public void requestDisplayClienteViewForLookUp() {
        new ClienteController(this.pedidoView, new ClienteService(new ClienteDAO()), new DatabaseAccessComponentManager<Cliente>()).displayViewForLookUp();
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
