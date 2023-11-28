package edu.ifmt.confeitaria.layers.controllers.data_management;

import java.awt.Component;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedido;
import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedidoService;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoDAO;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoService;
import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;
import edu.ifmt.confeitaria.util.views.ViewUtils;

public class ItemPedidoController extends SuperController<ItemPedido> {
    private final PedidoView pedidoView;
    private final ItemPedidoService itemPedidoService;
    private DatabaseAccessComponentManager<ItemPedido> itemPedidoDBCManager;
    ItemPedido itemNulo = new ItemPedido(
        null,
        0,
        null,
        null,
        new Produto()
    );

    public ItemPedidoController(PedidoView pedidoView, ItemPedidoService itemPedidoService, DatabaseAccessComponentManager<ItemPedido> itemPedidoDBCManager) {
        //Injeção de dependências
        this.pedidoView = pedidoView;
        this.itemPedidoService = itemPedidoService;
        this.itemPedidoDBCManager = itemPedidoDBCManager;

        //Configurando o DatabaseAccessComponentManager
        List<Component> fields = Arrays.asList(pedidoView.getEdtProduto(), pedidoView.getEdtCodProduto(), 
            pedidoView.getEdtQtde(), pedidoView.getEdtVlrTotalItemPedido(), pedidoView.getEdtVlrUnt());
        this.itemPedidoDBCManager.setFields(fields);
        this.itemPedidoDBCManager.configureComponents(ItemPedido.class, this, this.itemPedidoService, pedidoView.getBtnInsertItemPedido(),
            pedidoView.getBtnUpdateItemPedido(), pedidoView.getBtnDeleteItemPedido(), pedidoView.getBtnPostItemPedido(),
            pedidoView.getBtnCancelItemPedido(), pedidoView.getBtnRefreshItemPedido(), pedidoView.getTblItemPedido());
    }

    /* O método displey view não faz nada, pois a view em que a entidade do sistema 'item pedido' está
    inserida, é a view do pedido (por se tratar de um mestre detalhe), logo, quem é resposável por exibir
    a interface do pedido, é a controller da entidade principal desta view, a controller do 'pedido'*/
    @Override
    public void displayView() {}
    
    public void requestDisplayProdutoViewForLookUp(JFrame current) {
        new ProdutoController(current, new ProdutoService(new ProdutoDAO()), new DatabaseAccessComponentManager<Produto>()).displayViewForLookUp(this::setProdutoFields);
    }

    public void setProdutoFields(Produto produto) {
        this.pedidoView.getEdtProduto().setText(produto.getDescricao());
        this.pedidoView.getEdtCodProduto().setText(produto.getID() == null ? "" : produto.getID().toString());
        this.pedidoView.getEdtVlrUnt().setText(produto.getVlrUnitario() == null ? "" : produto.getVlrUnitario().toString());
    }

    public void partialSearch(String produto, String tipoChocolate) {
        if(tipoChocolate.equals(ViewUtils.ALL_OPTIONS_TEXT)) {
            tipoChocolate = null;
        }
        this.itemPedidoDBCManager.setTemporaryTDataList(
            this.itemPedidoService.partialSearch(this.itemPedidoDBCManager.getTSelectedRecord().getValue().getID(),
                    produto, tipoChocolate));
    }

    @Override
    public Object[] modelToTableRow(ItemPedido itemPedido) {
        ItemPedido itemPedidoSelecionado = this.itemPedidoDBCManager.getTSelectedRecord().getValue();
        List<ItemPedido> listaAtual = this.itemPedidoDBCManager.getTemporaryTDataList().getValue();
        if (itemPedido.getProduto() == null) {
            itemPedido.setProduto(new Produto());
        }
        return new Object[]{
            itemPedido.getID() == null ? "" : itemPedido.getID(),
            itemPedido.getProduto().getDescricao(),
            itemPedido.getProduto().getTipoChocolate(),
            listaAtual != null && !listaAtual.isEmpty()
            && !(listaAtual.size() == 1 && listaAtual.get(0).equals(this.itemNulo))
                ? Integer.toString(itemPedidoSelecionado != null ? itemPedidoSelecionado.getQtde() : 0)
                : "" ,
            itemPedido.getProduto().getVlrUnitario(),
            itemPedido.getVlrTotalItem(),
        };
    }

    @Override
    public void modelToFields(ItemPedido itemPedido) {
        //ItemPedido não está funcionando por motivo desconhecido
        ItemPedido itemPedidoSelecionado = this.itemPedidoDBCManager.getTSelectedRecord().getValue();
        List<ItemPedido> listaAtual = this.itemPedidoDBCManager.getTemporaryTDataList().getValue();
        if (itemPedidoSelecionado.getProduto() == null) {
            itemPedidoSelecionado.setProduto(new Produto());
        }
        this.pedidoView.getEdtProduto().setText(itemPedidoSelecionado.getProduto().getDescricao());
        this.pedidoView.getEdtCodProduto().setText(itemPedidoSelecionado.getProduto().getID() == null ? "" : itemPedidoSelecionado.getProduto().getID().toString());
        this.pedidoView.getEdtQtde().setText(listaAtual != null && !listaAtual.isEmpty()
            && !(listaAtual.size() == 1 && listaAtual.get(0).equals(this.itemNulo))
                ? Integer.toString(itemPedidoSelecionado.getQtde())
                : "" );
        this.pedidoView.getEdtVlrUnt().setText(itemPedidoSelecionado.getProduto().getVlrUnitario() == null ? "" : itemPedidoSelecionado.getProduto().getVlrUnitario().toString());
        this.pedidoView.getEdtVlrTotalItemPedido().setText(itemPedidoSelecionado.getVlrTotalItem() == null ? "" : itemPedidoSelecionado.getVlrTotalItem().toString());
    }

    @Override
    public ItemPedido fieldsToModel() {
        ItemPedido itemPedidoSelecionado = this.itemPedidoDBCManager.getTSelectedRecord().getValue();
        return new ItemPedido(
            null,
            this.pedidoView.getEdtQtde().getText().equals("") ? 0 : Integer.parseInt(this.pedidoView.getEdtQtde().getText()),
            this.pedidoView.getEdtVlrTotalItemPedido().getText().equals("") ? null : new BigDecimal(this.pedidoView.getEdtVlrTotalItemPedido().getText()),
            itemPedidoSelecionado.getPedido(),
            new Produto(
                this.pedidoView.getEdtCodProduto().getText().equals("") ? null : Long.parseLong(this.pedidoView.getEdtCodProduto().getText()),
                this.pedidoView.getEdtProduto().getText(),
                itemPedidoSelecionado.getProduto().getVlrUnitario(),
                itemPedidoSelecionado.getProduto().getObservacoes(),
                itemPedidoSelecionado.getProduto().getTipoChocolate()
            )
        );
    }
}
