package edu.ifmt.confeitaria.layers.models.usuario;

import java.util.List;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperService;
import edu.ifmt.confeitaria.util.services.ServiceUtils;
import edu.ifmt.confeitaria.util.services.ValidationResponses;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class UsuarioService extends SuperService<Usuario> {
    private static UsuarioService instance;
    private final UsuarioDAO usuarioDAO;
    private BehaviorSubject<Usuario> loggedUser;

    private UsuarioService(UsuarioDAO usuarioDAO) {
        this.loggedUser = BehaviorSubject.create();
        this.loggedUser.onNext(new Usuario());
        this.usuarioDAO = usuarioDAO;
    }
    
    public static UsuarioService getInstance() {
        if(UsuarioService.instance == null) {
            UsuarioService.instance = new UsuarioService(new UsuarioDAO());
        }
        
        return UsuarioService.instance;
    }

    public BehaviorSubject<Usuario> getLoggedUser() {
        return loggedUser;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    @Override
    public List<Usuario> selectAll(){
        return this.usuarioDAO.selectAll();
    }
    
    public List<Usuario> partialSearch(String nome, String login) {
        //Remove os espaços em branco do início e do fim das strings
        if(nome != null) nome = nome.stripLeading().stripTrailing();
        if(login != null) login = login.stripLeading().stripTrailing();
        
        //Solicita os dados ao DAO
        return this.usuarioDAO.partialSearch(nome, login);
    }
    
    @Override
    public List<Usuario> remakeLastPartialSearch(){
        //Solicita os dados ao DAO
        return this.usuarioDAO.remakeLastPartialSearch();
    }
    
    @Override
    public boolean insert(Usuario usuario) {
        //Valida os dados do usuário
        if(this.validateDataInsert(usuario)) {
            /*Caso os dados sejam válidos, solicita ao DAO a inserção
            do usuário no banco de daods já retornando o resultado*/
            return this.usuarioDAO.insert(usuario);
        } else {
            return false;
        }
        
    }
    
    @Override
    public boolean update(Usuario usuario, Usuario usuarioOriginal) {
        //Valida os dados do usuário
        if(this.validateDataUpdate(usuario, usuarioOriginal)) {
            /*Caso os dados sejam válidos, solicita ao DAO a atualização
            do usuário no banco de daods já retornando o resultado*/
            return this.usuarioDAO.update(usuario, usuarioOriginal.getID());
        } else {
            return false;
        }
    }

    /* ----- Regras de negócio ----- */
    public boolean signIn(String login, String senha) {
        //Solicita ao DAO a lista de usuários com o login especificado
        List<Usuario> usuarios = this.usuarioDAO.selectByLoginAndPassword(login, senha);
        Usuario currentUser;
        
        //Verifica se a lista não é nula e se não está vazia
        if(usuarios != null && !usuarios.isEmpty()) {  
            //Define o usuário atual como o primeiro usuário da lista
            currentUser = usuarios.get(0);
            /*Define o usuário logado como o usuário atual. A 
            senha não é definida para evitar que ela seja vazada*/
            this.loggedUser.onNext(new Usuario( currentUser.getID(), 
                                                currentUser.getNome(),
                                                currentUser.getLogin(), 
                                                null));
            //Aprova o login                                
            return true;
        } else {
            
            /*Define o usuário logado como nulo para evitar que o usuário
            anterior seja mantido como logado e, sem seguida, reprova o login*/
            if(this.loggedUser.getValue().getID() != null) this.loggedUser.onNext(new Usuario());
            return false;
        }
    }
    
    public void signOut() {
        //Define o usuário logado como nulo
        this.loggedUser.onNext(new Usuario());
    }
    
    public boolean isIdExists(Long ID){
        //Solicta ao DAO a lista de usuários com o id especificado
        List<Usuario> usuarios = this.usuarioDAO.selectById(ID);
        
        if(usuarios != null) {
            //Verifica se a lista está vazia
            boolean response = usuarios.size() > 0;
            return response;
            
        } else {
            return false;
        }
    }
    
    public boolean isLoginExists(String login){
        //Solicta ao DAO a lista de usuários com o login especificado
        List<Usuario> usuarios = this.usuarioDAO.selectByLogin(login);
        
        if(usuarios != null) {
            //Verifica se a lista está vazia
            boolean response = usuarios.size() > 0;
            return response;
            
        } else {
            return false;
        }
    }

    /* ----- Validações ----- */
    public static final int NOME_MAX_LENGTH = 100;
    public static final int LOGIN_MAX_LENGTH = 30;
    public static final int LOGIN_MIN_LENGTH = 5;
    public static final int SENHA_MAX_LENGTH = 30;
    public static final int SENHA_MIN_LENGTH = 8;

    public boolean validateDataInsert(Usuario usuario) {
        return this.validateAllData(usuario, null);
    }
    
    public boolean validateDataUpdate(Usuario usuario, Usuario usuarioOriginal) {
        return this.validateAllData(usuario, usuarioOriginal);
    }

    //Método para validar os dados, privado pois só deve ser usado internamente
    private boolean validateAllData(Usuario usuario, Usuario usuarioOriginal) {
        return(usuario != null 
                && ValidationResponses.VALID == this.validateNome(usuario.getNome())
                && ValidationResponses.VALID == this.validateSenha(usuario.getSenha())
                && ValidationResponses.VALID == this.validateID(usuario.getID(), usuarioOriginal == null ? null : usuarioOriginal.getID())
                && ValidationResponses.VALID == this.validateLogin(usuario.getLogin(), usuarioOriginal == null ? null : usuarioOriginal.getLogin()));
    }

    public ValidationResponses validateID(Long ID, Long originalID) {
        if(ID == null) {
            return ValidationResponses.VALID;
        } else if(ID < ServiceUtils.MIN_ID_VALUE) {
            return ValidationResponses.BELOW_MIN_VALUE;
        } else if (ID > ServiceUtils.MAX_ID_VALUE) {
            return ValidationResponses.MAX_VALUE_EXCEEDED;
        }    
        /*Verifica se o ID é diferente do ID original, se 
        for, verifica se ele já existe no banco de dados*/   
        else if(!ID.equals(originalID) && this.isIdExists(ID)) {
            return ValidationResponses.ALREADY_EXISTS;
        } else {
            return ValidationResponses.VALID;
        }
    }

    public ValidationResponses validateNome(String nome) {
        if(nome.length() > UsuarioService.NOME_MAX_LENGTH) {
            return ValidationResponses.MAX_LENGTH_EXCEEDED;
        } else {
            return ValidationResponses.VALID;
        }
    }

    public ValidationResponses validateLogin(String login, String originalLogin) {
        if(login == null || login.isEmpty()) {
            return ValidationResponses.REQUIRED_FIELD;
        } else if(login.length() < UsuarioService.LOGIN_MIN_LENGTH) {
            return ValidationResponses.MIN_LENGTH_NOT_REACHED;
        } else if(login.length() > UsuarioService.LOGIN_MAX_LENGTH) {
            return ValidationResponses.MAX_LENGTH_EXCEEDED;
        }
        /*Se sim, verifica se o login é diferente do login original, 
        sendo diferente, verifica se ele já existe no banco de dados*/
        else if(!login.equals(originalLogin) && this.isLoginExists(login)) {
            return ValidationResponses.ALREADY_EXISTS;   
        } else {
            return ValidationResponses.VALID;
        }
    }

    public ValidationResponses validateSenha(String senha) {
        if(senha == null || senha.isEmpty()) {
            return ValidationResponses.REQUIRED_FIELD;
        } else if(senha.length() < UsuarioService.SENHA_MIN_LENGTH) {
            return ValidationResponses.MIN_LENGTH_NOT_REACHED;
        } else if(senha.length() > UsuarioService.SENHA_MAX_LENGTH) {
            return ValidationResponses.MAX_LENGTH_EXCEEDED;
        } else {
            return ValidationResponses.VALID;
        }
    }
}
