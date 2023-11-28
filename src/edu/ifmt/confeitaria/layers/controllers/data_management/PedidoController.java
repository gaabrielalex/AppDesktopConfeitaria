package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.awt.Component;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteDAO;
import edu.ifmt.confeitaria.layers.models.cliente.ClienteService;
import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedido;
import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedidoDAO;
import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedidoService;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPagto;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPedido;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoService;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.layers.models.pedido.PedidoService;
import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;
import edu.ifmt.confeitaria.util.views.ViewUtils;

public class PedidoController extends SuperController<Pedido> {
    private final PedidoView pedidoView;
    private final PedidoService pedidoService;
    private final ProdutoService produtoService;
    private DatabaseAccessComponentManager<Pedido> pedidoDBCManager;
    
    public PedidoController(JFrame previousView, PedidoService pedidoService, ProdutoService produtoService, DatabaseAccessComponentManager<Pedido> pedidoDBCManager) {
        //Injeção de dependências
        this.pedidoDBCManager = pedidoDBCManager;
        this.pedidoService = pedidoService;
        this.produtoService = produtoService;

        //Instancia a View e define esta instância como seu controlador
        this.pedidoView = new PedidoView(this, null, previousView);

        //Configura corretamente o ItemPedidoController
        this.pedidoView.setItemPedidoController(new ItemPedidoController(this.pedidoView, new ItemPedidoService(new ItemPedidoDAO()),new DatabaseAccessComponentManager<ItemPedido>()));

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
        this.pedidoView.getCmbTipoChocFiltro().removeAllItems();
        for (Pedido.StatusPagto value : Pedido.StatusPagto.values()) {
            this.pedidoView.getCmbSttsPagto().addItem(ViewUtils.customToLowerCase(value.toString()));
            this.pedidoView.getCmbSttsPagtoFiltro().addItem(ViewUtils.customToLowerCase(value.toString()));
        }
        for (Pedido.StatusPedido value : Pedido.StatusPedido.values()) {
            this.pedidoView.getCmbSttsPedido().addItem(ViewUtils.customToLowerCase(value.toString()));
            this.pedidoView.getCmbSttsPedidoFiltro().addItem(ViewUtils.customToLowerCase(value.toString()));
        }
        for (String value : this.pedidoService.selectAllMetodoPagto()) {
            this.pedidoView.getCmbMtdPagto().addItem(value);
        }
        for (String value : this.produtoService.selectAllTipoChocolate()) {
            this.pedidoView.getCmbTipoChocFiltro().addItem(value);
        }
        this.pedidoView.getCmbSttsPagtoFiltro().addItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbSttsPagtoFiltro().setSelectedItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbSttsPedidoFiltro().addItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbSttsPedidoFiltro().setSelectedItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbTipoChocFiltro().addItem(ViewUtils.ALL_OPTIONS_TEXT);
        this.pedidoView.getCmbTipoChocFiltro().setSelectedItem(ViewUtils.ALL_OPTIONS_TEXT);
        /*Cancela qualquer operação que possa estar sendo realizada, isso porque houve
        alterações acima ne um dos fields, logo, o manager entende que estava havendo uma
        operação de atualização, o que não era o caso, eram apenas configurações iniciais*/
        this.pedidoDBCManager.cancel();
        ViewUtils.addTextChangeListeners(this.pedidoView.getEdtVlrTotalItemPedido(), this::calculateTotalOrderValue);
        ViewUtils.addTextChangeListeners(this.pedidoView.getEdtDesconto(), this::calculateTotalOrderValue);
        this.pedidoView.setVisible(true);
    }
    
    public void requestDisplayClienteViewForLookUp() {
        new ClienteController(this.pedidoView, new ClienteService(new ClienteDAO()), new DatabaseAccessComponentManager<Cliente>()).displayViewForLookUp(this::setCustomerFields);
    }

    public void setCustomerFields(Cliente cliente) {
        this.pedidoView.getEdtCliente().setText(cliente.getNome());
        this.pedidoView.getEdtCodCliente().setText(cliente.getID() == null ? "" : cliente.getID().toString());
    }

    public void calculateTotalOrderValue() {
        double totalOrderValue = Double.parseDouble(this.pedidoView.getEdtVlrTotalItemPedido().getText().equals("") ? "0" : this.pedidoView.getEdtVlrTotalPedido().getText())
                + Double.parseDouble(this.pedidoView.getEdtDesconto().getText().equals("") ? "0" : this.pedidoView.getEdtDesconto().getText());
        this.pedidoView.getEdtVlrTotalPedido().setText(String.valueOf(totalOrderValue));  
    }

    public void partialSearch(String nomeCliente, String nomeDestinatario, String statusPagto, String statusPedido) {
        if (statusPagto.equals(ViewUtils.ALL_OPTIONS_TEXT) || statusPagto.equals(ViewUtils.ALL_OPTIONS_TEXT.toUpperCase())) {
            statusPagto = null;
        }
        if (statusPedido.equals(ViewUtils.ALL_OPTIONS_TEXT) || statusPedido.equals(ViewUtils.ALL_OPTIONS_TEXT.toUpperCase())) {
            statusPedido = null;
        }
        this.pedidoDBCManager.setTemporaryTDataList(this.pedidoService.partialSearch(nomeCliente, nomeDestinatario,
                statusPagto == null ? null : StatusPagto.valueOf(statusPagto),
                statusPedido == null ? null : StatusPedido.valueOf(statusPedido)));
    }

    @Override
    public Object[] modelToTableRow(Pedido pedido) {
        if(pedido.getCliente() == null) {
            pedido.setCliente(new Cliente());
        }
        if(pedido.getUsuario() == null) {
            pedido.setUsuario(new Usuario());
        }
        return new Object[]{
            pedido.getID() == null ? "" : pedido.getID(),
            pedido.getCliente().getNome(),
            pedido.getCliente().getTelefones(),
            pedido.getCliente().getEndereco(),
            pedido.getCliente().getLinkEndereco(),
            pedido.getDtHrPedido() == null ? "" : new SimpleDateFormat("dd/MM/yyyy").format(pedido.getDtHrPedido().getTime()),
            pedido.getDtHrEntrega() == null ? "" : new SimpleDateFormat("dd/MM/yyyy").format(pedido.getDtHrEntrega().getTime()),
            pedido.getVlrTotalPedido(),
            pedido.getDesconto(),
            pedido.getMetodoPagto(),
            pedido.getNomeDestinatario(),
            pedido.isRetiradaLoja(),
            pedido.getStatusPagto() == null ? null : ViewUtils.customToLowerCase( pedido.getStatusPagto().toString()),
            pedido.getStatusPedido() == null ? null : ViewUtils.customToLowerCase(pedido.getStatusPedido().toString()),
            pedido.getObservacoes(),
            pedido.getUsuario() == null ? "" : pedido.getUsuario().getNome(),
        };
    }

    @Override
    public void modelToFields(Pedido pedido) {
        if(pedido.getCliente() == null) {
            pedido.setCliente(new Cliente());
        }
        if(pedido.getUsuario() == null) {
            pedido.setUsuario(new Usuario());
        }
        this.pedidoView.getEdtCliente().setText(pedido.getCliente().getNome());
        this.pedidoView.getEdtCodCliente().setText(pedido.getCliente().getID() == null ? "" : pedido.getCliente().getID().toString());
        this.pedidoView.getDtChooserDtPedido().setDate(pedido.getDtHrPedido());
        this.pedidoView.getDtChooserDtEntrega().setDate(pedido.getDtHrEntrega());
        this.pedidoView.getEdtVlrTotalPedido().setText(pedido.getVlrTotalPedido() == null ? "" : pedido.getVlrTotalPedido().toString());
        this.pedidoView.getEdtDesconto().setText(pedido.getDesconto() == null ? "" : pedido.getDesconto().toString());
        this.pedidoView.getCmbMtdPagto().setSelectedItem(pedido.getMetodoPagto());
        this.pedidoView.getEdtDestinatario().setText(pedido.getNomeDestinatario());
        this.pedidoView.getCkBRetirada().setSelected(pedido.isRetiradaLoja());
        this.pedidoView.getCmbSttsPagto().setSelectedItem(pedido.getStatusPagto() == null ? null : pedido.getStatusPagto().getDescricao());
        this.pedidoView.getCmbSttsPedido().setSelectedItem(pedido.getStatusPedido() == null ? null : pedido.getStatusPedido().getDescricao());
        this.pedidoView.getEdtObs().setText(pedido.getObservacoes());
    }

    @Override
    public Pedido fieldsToModel() {
        Pedido pedidoSelecionado = this.pedidoDBCManager.getTSelectedRecord().getValue();

        return new Pedido(
            null,
            new Usuario(
                UsuarioService.getInstance().getLoggedUser().getValue().getID(),
                UsuarioService.getInstance().getLoggedUser().getValue().getNome(),
                UsuarioService.getInstance().getLoggedUser().getValue().getLogin(),
                null
            ),
            new Cliente(
                this.pedidoView.getEdtCodCliente().getText().equals("") ? null : Long.parseLong(this.pedidoView.getEdtCodCliente().getText()),
                this.pedidoView.getEdtCliente().getText(),
                pedidoSelecionado.getCliente().getCPF(),
                pedidoSelecionado.getCliente().getTelefones(),
                pedidoSelecionado.getCliente().getEndereco(),
                pedidoSelecionado.getCliente().getLinkEndereco()
            ),
            this.pedidoView.getDtChooserDtPedido().getDate(),
            this.pedidoView.getDtChooserDtEntrega().getDate(),
            this.pedidoView.getEdtVlrTotalPedido().getText().equals("") ? null : new BigDecimal(this.pedidoView.getEdtVlrTotalPedido().getText()),
            this.pedidoView.getEdtDesconto().getText().equals("") ? null : new BigDecimal(this.pedidoView.getEdtDesconto().getText()),
            this.pedidoView.getEdtDestinatario().getText(),
            this.pedidoView.getCkBRetirada().isSelected(),
            this.pedidoView.getCmbSttsPagto().getSelectedItem() == null ? null : StatusPagto.valueOf(this.pedidoView.getCmbSttsPagto().getSelectedItem().toString().toUpperCase()),
            this.pedidoView.getCmbSttsPedido().getSelectedItem() == null ? null : StatusPedido.valueOf(this.pedidoView.getCmbSttsPedido().getSelectedItem().toString().toUpperCase()),
            this.pedidoView.getEdtObs().getText(),
            this.pedidoView.getCmbMtdPagto().getSelectedItem() == null ? null : this.pedidoView.getCmbMtdPagto().getSelectedItem().toString()
        );
    }
}
