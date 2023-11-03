package edu.ifmt.confeitaria.layers.models.produto;

import java.util.List;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;

public class ProdutoService extends SuperService<Produto> {
    private final ProdutoDAO produtoDAO;

    public ProdutoService(ProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    @Override
    public List<Produto> selectAll(){
        return this.produtoDAO.selectAll();
    }
    
    public List<Produto> partialSearch(String nome, String tipoChocolate) {
        //Remove os espaços em branco do início e do fim das strings necessárias
        if(nome != null) nome = nome.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.produtoDAO.partialSearch(nome, tipoChocolate);
    }
    
    @Override
    public List<Produto> redoLastPartialSearch(){
        //Solicita os dados ao DAO
        return this.produtoDAO.redoLastPartialSearch();
    }
    
    @Override
    public boolean insert(Cliente cliente) {
        //Solita ao DAO a inserção do cliente no BD já retornando o resultado
        return this.produtoDAO.insert(cliente);
    }
    
    @Override
    public boolean update(Cliente cliente, Cliente clienteOriginal) {
        //Solita ao DAO a atualização do cliente no BD já retornando o resultado
        return this.produtoDAO.update(cliente, clienteOriginal.getID());
    }

    @Override
    public boolean delete(Cliente cliente) {
        //Solita ao DAO a exclusão do cliente no BD já retornando o resultado
        return this.produtoDAO.delete(cliente.getID());
    }
}
