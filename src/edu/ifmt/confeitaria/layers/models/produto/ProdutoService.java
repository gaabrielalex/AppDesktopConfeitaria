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
    public boolean insert(Produto produto) {
        //Solita ao DAO a inserção do produto no BD já retornando o resultado
        return this.produtoDAO.insert(produto);
    }
    
    @Override
    public boolean update(Produto produto, Produto produtoOriginal) {
        //Solita ao DAO a atualização do produto no BD já retornando o resultado
        return this.produtoDAO.update(produto, produtoOriginal.getID());
    }

    @Override
    public boolean delete(Produto produto) {
        //Solita ao DAO a exclusão do produto no BD já retornando o resultado
        return this.produtoDAO.delete(produto.getID());
    }
}
