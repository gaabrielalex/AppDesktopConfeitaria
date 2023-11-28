package edu.ifmt.confeitaria.layers.models.item_pedido;

import java.util.List;

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
    
    public List<ItemPedido> partialSearch(Long idPedido, String produto, String tipoChocolate) {
        //Remove os espaços em branco do início e do fim das strings necessárias
        if(produto != null) produto = produto.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.itemPedidoDAO.partialSearch(idPedido, produto, tipoChocolate);
    }
    
    @Override
    public List<ItemPedido> redoLastPartialSearch() {
        //Solicita os dados ao DAO
        return this.itemPedidoDAO.redoLastPartialSearch();
    }
    
    @Override
    public boolean insert(ItemPedido itemPedido) {
        //Solita ao DAO a inserção do item do pedido no BD já retornando o resultado
        return this.itemPedidoDAO.insert(itemPedido);
    }
    
    @Override
    public boolean update(ItemPedido itemPedido, ItemPedido itemPedidoOriginal) {
        //Solita ao DAO a atualização do item do pedido no BD já retornando o resultado
        return this.itemPedidoDAO.update(itemPedido, itemPedidoOriginal.getID());
    }

    @Override
    public boolean delete(ItemPedido ItemPedido) {
        //Solita ao DAO a exclusão do item do pedido no BD já retornando o resultado
        return this.itemPedidoDAO.delete(ItemPedido.getID());
    }
}
