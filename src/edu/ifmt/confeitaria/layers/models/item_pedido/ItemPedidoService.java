package edu.ifmt.confeitaria.layers.models.item_pedido;

import java.util.List;

import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoDAO;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;

public class ItemPedidoService extends SuperService<ItemPedido> {
    private final ItemPedidoDAO itemPedidoDAO;

    public ItemPedidoService(ItemPedidoDAO itemPedidoDAO) {
        this.itemPedidoDAO = itemPedidoDAO;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    @Override
    public List<ItemPedido> selectAll() {
        return this.itemPedidoDAO.selectAll();
    }
    
    public List<ItemPedido> partialSearch(String produto, String tipoChocolate) {
        //Remove os espaços em branco do início e do fim das strings necessárias
        if(produto != null) produto = produto.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.itemPedidoDAO.partialSearch(produto, tipoChocolate);
    }
    
    // @Override
    // public List<ItemPedido> redoLastPartialSearch() {
    //     //Solicita os dados ao DAO
    //     return this.itemPedidoDAO.redoLastPartialSearch();
    // }
    
    // @Override
    // public boolean insert(Produto produto) {
    //     //Solita ao DAO a inserção do produto no BD já retornando o resultado
    //     return this.itemPedidoDAO.insert(produto);
    // }
    
    // @Override
    // public boolean update(Produto produto, Produto produtoOriginal) {
    //     //Solita ao DAO a atualização do produto no BD já retornando o resultado
    //     return this.itemPedidoDAO.update(produto, produtoOriginal.getID());
    // }

    // @Override
    // public boolean delete(Produto produto) {
    //     //Solita ao DAO a exclusão do produto no BD já retornando o resultado
    //     return this.itemPedidoDAO.delete(produto.getID());
    // }
}
