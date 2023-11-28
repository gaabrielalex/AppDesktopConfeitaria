package edu.ifmt.confeitaria.layers.models.item_pedido;

import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoDAO;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;

public class ItemPedidoService extends SuperService<ItemPedido> {
    private final ItemPedidoDAO itemPedidoDAO;

    public ItemPedidoService(ItemPedidoDAO itemPedidoDAO) {
        this.itemPedidoDAO = itemPedidoDAO;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    public List<String> selectAllTipoChocolate() {
        //Solicita os dados ao DAO
        return this.itemPedidoDAO.selectAllTipoChocolate();
    }

    @Override
    public List<Produto> selectAll() {
        return this.itemPedidoDAO.selectAll();
    }
    
    public List<Produto> partialSearch(String nome, String tipoChocolate) {
        //Remove os espaços em branco do início e do fim das strings necessárias
        if(nome != null) nome = nome.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.itemPedidoDAO.partialSearch(nome, tipoChocolate);
    }
    
    @Override
    public List<Produto> redoLastPartialSearch() {
        //Solicita os dados ao DAO
        return this.itemPedidoDAO.redoLastPartialSearch();
    }
    
    @Override
    public boolean insert(Produto produto) {
        //Solita ao DAO a inserção do produto no BD já retornando o resultado
        return this.itemPedidoDAO.insert(produto);
    }
    
    @Override
    public boolean update(Produto produto, Produto produtoOriginal) {
        //Solita ao DAO a atualização do produto no BD já retornando o resultado
        return this.itemPedidoDAO.update(produto, produtoOriginal.getID());
    }

    @Override
    public boolean delete(Produto produto) {
        //Solita ao DAO a exclusão do produto no BD já retornando o resultado
        return this.itemPedidoDAO.delete(produto.getID());
    }
}
