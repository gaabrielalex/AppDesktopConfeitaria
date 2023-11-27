package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteDAO;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteService;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPagto;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPedido;
import edu.ifmt.confeitaria.layers.models.pedido.PedidoService;
import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;
import edu.ifmt.confeitaria.util.views.ViewUtils;

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
        this.pedidoView.getCmbSttsPagtoFiltro().addItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbSttsPedidoFiltro().addItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbSttsPagtoFiltro().setSelectedItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbSttsPedidoFiltro().setSelectedItem(ViewUtils.ALL_OPTIONS_TEXT);
        /*Cancela qualquer operação que possa estar sendo realizada, isso porque houve
        alterações acima ne um dos fields, logo, o manager entende que estava havendo uma
        operação de atualização, o que não era o caso, eram apenas configurações iniciais*/
        this.pedidoDBCManager.cancel();
        this.pedidoView.setVisible(true);
    }
    
    public void requestDisplayClienteViewForLookUp() {
        new ClienteController(this.pedidoView, new ClienteService(new ClienteDAO()), new DatabaseAccessComponentManager<Cliente>()).displayViewForLookUp();
    }

    public void partialSearch(String nomeCliente, String nomeDestinatario, String statusPagto, String statusPedido) {
        if (statusPagto.equals(ViewUtils.ALL_OPTIONS_TEXT)) {
            statusPagto = null;
        }
        if (statusPedido.equals(ViewUtils.ALL_OPTIONS_TEXT)) {
            statusPedido = null;
        }
        this.pedidoDBCManager.setTemporaryTDataList(this.pedidoService.partialSearch(nomeCliente, nomeDestinatario,
                statusPagto == null ? null : StatusPagto.valueOf(statusPagto),
                statusPedido == null ? null : StatusPedido.valueOf(statusPedido)));
    }

    @Override
    public Object[] modelToTableRow(Pedido pedido) {
        return new Object[]{
            pedido.getID(),
            pedido.getCliente().getNome(),
            pedido.getCliente().getTelefones(),
            pedido.getCliente().getEndereco(),
            pedido.getCliente().getLinkEndereco(),
            pedido.getDtHrPedido(),
            pedido.getDtHrEntrega(),
            pedido.getVlrTotalPedido(),
            pedido.getDesconto(),
            pedido.getMetodoPagto(),
            pedido.getNomeDestinatario(),
            pedido.isRetiradaLoja(),
            pedido.getStatusPagto(),
            pedido.getStatusPedido(),
            pedido.getObservacoes()
        };
    }

    @Override
    public void modelToFields(Pedido pedido) {
        this.pedidoView.getEdtCliente().setText(pedido.getCliente().getNome());
        this.pedidoView.getEdtCodCliente().setText(pedido.getCliente().getID().toString());
        this.pedidoView.getDtChooserDtPedido().setDate(pedido.getDtHrPedido());
        this.pedidoView.getDtChooserDtEntrega().setDate(pedido.getDtHrEntrega());
        this.pedidoView.getEdtVlrTotalPedido().setText(pedido.getVlrTotalPedido() == null ? "" : pedido.getVlrTotalPedido().toString());
        this.pedidoView.getEdtDesconto().setText(pedido.getDesconto() == null ? "" : pedido.getDesconto().toString());
        this.pedidoView.getCmbMtdPagto().setSelectedItem(pedido.getMetodoPagto());
        this.pedidoView.getEdtDestinatario().setText(pedido.getNomeDestinatario());
        this.pedidoView.getCkBRetirada().setSelected(pedido.isRetiradaLoja());
        this.pedidoView.getCmbSttsPagto().setSelectedItem(pedido.getStatusPagto().getDescricao());
        this.pedidoView.getCmbSttsPedido().setSelectedItem(pedido.getStatusPedido().getDescricao());
        this.pedidoView.getEdtObs().setText(pedido.getObservacoes());
    }

    @Override
    public Pedido fieldsToModel() {
        // TODO Auto-generated method stub
        return null;
    }

}
