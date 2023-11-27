package edu.ifmt.confeitaria.layers.models.pedido;

import java.util.List;

import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPagto;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPedido;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.produto.ProdutoDAO;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;

public class PedidoService extends SuperService<Pedido> {
    private final PedidoDAO pedidoDAO;

    public PedidoService(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    public List<String> selectAllMetodoPagto() {
        //Solicita os dados ao DAO
        return this.pedidoDAO.selectAllMetodoPagto();
    }

    @Override
    public List<Pedido> selectAll() {
        return this.pedidoDAO.selectAll();
    }
    
    public List<Pedido> partialSearch(String nomeCliente, String nomeDestinatario, StatusPagto statusPagto, StatusPedido statusPedido) {
        //Remove os espaços em branco do início e do fim das strings necessárias
        if(nomeCliente != null) nomeCliente = nomeCliente.stripLeading().stripTrailing();
        if(nomeDestinatario != null) nomeDestinatario = nomeDestinatario.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.pedidoDAO.partialSearch(nomeCliente, nomeDestinatario, statusPagto, statusPedido);
    }
    
    @Override
    public List<Pedido> redoLastPartialSearch() {
        //Solicita os dados ao DAO
        return this.pedidoDAO.redoLastPartialSearch();
    }
    
    // @Override
    // public boolean insert(Produto produto) {
    //     //Solita ao DAO a inserção do produto no BD já retornando o resultado
    //     return this.pedidoDAO.insert(produto);
    // }
    
    // @Override
    // public boolean update(Produto produto, Produto produtoOriginal) {
    //     //Solita ao DAO a atualização do produto no BD já retornando o resultado
    //     return this.pedidoDAO.update(produto, produtoOriginal.getID());
    // }

    // @Override
    // public boolean delete(Produto produto) {
    //     //Solita ao DAO a exclusão do produto no BD já retornando o resultado
    //     return this.pedidoDAO.delete(produto.getID());
    // }
}
