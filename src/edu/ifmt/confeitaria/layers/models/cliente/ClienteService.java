package edu.ifmt.confeitaria.layers.models.cliente;

import java.util.List;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;

public class ClienteService extends SuperService<Cliente> {
    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    @Override
    public List<Cliente> selectAll(){
        return this.clienteDAO.selectAll();
    }
    
    public List<Cliente> partialSearch(String nome, String CPF) {
        //Remove os espaços em branco do início e do fim das strings
        if(nome != null) nome = nome.stripLeading().stripTrailing();
        if(CPF != null) CPF = CPF.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.clienteDAO.partialSearch(nome, CPF);
    }
    
    @Override
    public List<Cliente> redoLastPartialSearch(){
        //Solicita os dados ao DAO
        return this.clienteDAO.redoLastPartialSearch();
    }
    
    @Override
    public boolean insert(Cliente cliente) {
        //Solita ao DAO a inserção do cliente no BD já retornando o resultado
        return this.clienteDAO.insert(cliente);
    }
    
    @Override
    public boolean update(Cliente cliente, Cliente clienteOriginal) {
        //Solita ao DAO a atualização do cliente no BD já retornando o resultado
        return this.clienteDAO.update(cliente, clienteOriginal.getID());
    }

    // @Override
    // public boolean delete(Usuario usuario) {
    //     //Solita ao DAO a exclusão do cliente no BD já retornando o resultado
    //     return this.clienteDAO.delete(usuario.getID());
    // }
}
