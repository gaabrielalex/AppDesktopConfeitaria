package edu.ifmt.confeitaria.layers.controllers.data_management;

import javax.swing.JFrame;

import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedido;
import edu.ifmt.confeitaria.layers.models.item_pedido.ItemPedidoService;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoDAO;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoService;
import edu.ifmt.confeitaria.layers.views.data_management.PedidoView;
import edu.ifmt.confeitaria.util.abstraction_classes.DatabaseAccessComponentManager;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperController;

public class ItemPedidoController extends SuperController<ItemPedido> {
    private final PedidoView pedidoView;
    private final ItemPedidoService itemPedidoService;
    private DatabaseAccessComponentManager<ItemPedido> itemPedidoDBCManager;

    public ItemPedidoController(PedidoView pedidoView, ItemPedidoService itemPedidoService, DatabaseAccessComponentManager<ItemPedido> itemPedidoDBCManager) {
        //Injeção de dependências
        this.pedidoView = pedidoView;
        this.itemPedidoService = itemPedidoService;
        this.itemPedidoDBCManager = itemPedidoDBCManager;

        //Configurando o DatabaseAccessComponentManager
        this.itemPedidoDBCManager.configureComponents(ItemPedido.class, this, this.itemPedidoService, pedidoView.getBtnInsertItemPedido(),
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
        new ProdutoController(current, new ProdutoService(new ProdutoDAO()), new DatabaseAccessComponentManager<Produto>()).displayViewForLookUp();
    }

    @Override
    public Object[] modelToTableRow(ItemPedido itemPedido) {
        return new Object[]{
            itemPedido.getID(),
            itemPedido.getProduto().getDescricao(),
            itemPedido.getProduto().getTipoChocolate(),
            itemPedido.getQtde(),
            itemPedido.getProduto().getVlrUnitario(),
            itemPedido.getVlrTotalItem(),
        };
    }

    @Override
    public void modelToFields(ItemPedido itemPedido) {
        // TODO Auto-generated method stub
    }

    @Override
    public ItemPedido fieldsToModel() {
        // TODO Auto-generated method stub
        return null;
    }

}
