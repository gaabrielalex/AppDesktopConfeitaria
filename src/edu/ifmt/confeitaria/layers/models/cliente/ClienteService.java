package edu.ifmt.confeitaria.layers.models.cliente;

import java.util.List;

import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioDAO;
import edu.ifmt.confeitaria.layers.models.usuario.UsuarioService;
import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;
import edu.ifmt.confeitaria.util.services.ValidationResponses;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

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
    
    // public List<Cliente> partialSearch(String nome, String login) {
    //     //Remove os espaços em branco do início e do fim das strings
    //     if(nome != null) nome = nome.stripLeading().stripTrailing();
    //     if(login != null) login = login.stripLeading().stripTrailing();
        
    //     //Solicita os dados ao DAO
    //     return this.clienteDAO.partialSearch(nome, login);
    // }
    
    // @Override
    // public List<Cliente> redoLastPartialSearch(){
    //     //Solicita os dados ao DAO
    //     return this.clienteDAO.redoLastPartialSearch();
    // }
    
    // @Override
    // public boolean insert(Usuario usuario) {
    //     //Valida os dados do usuário
    //     if(this.validateDataInsert(usuario)) {
    //         /*Caso os dados sejam válidos, solicita ao DAO a inserção
    //         do usuário no banco de dados já retornando o resultado*/
    //         return this.clienteDAO.insert(usuario);
    //     } else {
    //         return false;
    //     }  
    // }
    
    // @Override
    // public boolean update(Usuario usuario, Usuario usuarioOriginal) {
    //     //Valida os dados do usuário
    //     if(this.validateDataUpdate(usuario, usuarioOriginal)) {
    //         /*Caso os dados sejam válidos, solicita ao DAO a atualização
    //         do usuário no banco de dados já retornando o resultado*/
    //         return this.clienteDAO.update(usuario, usuarioOriginal.getID());
    //     } else {
    //         return false;
    //     }
    // }

    // @Override
    // public boolean delete(Usuario usuario) {
    //     //Solicita ao DAO a exclusão do usuário no banco de dados já retornando o resultado
    //     return this.clienteDAO.delete(usuario.getID());
    // }

    // /* ----- Regras de negócio ----- */
    // public boolean isIdExists(Long ID){
    //     //Solicta ao DAO a lista de usuários com o id especificado
    //     List<Cliente> usuarios = this.clienteDAO.selectById(ID);
        
    //     if(usuarios != null) {
    //         //Verifica se a lista está vazia
    //         boolean response = usuarios.size() > 0;
    //         return response;
            
    //     } else {
    //         return false;
    //     }
    // }
}
