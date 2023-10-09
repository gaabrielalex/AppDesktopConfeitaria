package edu.ifmt.confeitaria.layers.models.usuario;

import java.util.List;

import edu.ifmt.confeitaria.util.services.ServiceUtils;
import edu.ifmt.confeitaria.util.services.ValidationResponses;

public class UsuarioService {
    public static final int NOME_MAX_LENGTH = 100;
    public static final int LOGIN_MAX_LENGTH = 30;
    public static final int SENHA_MAX_LENGTH = 30;
    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    /* ----- Métodos principais de manipulação de dados ----- */
    public List<Usuario> select(){
        return this.select(null, null);
    }

    public List<Usuario> select(String nome, String login) {
        //Remove os espaços em branco do início e do fim das strings
        if(nome != null) nome = nome.stripLeading().stripTrailing();
        if(login != null) login = login.stripLeading().stripTrailing();

        //Solicita os dados ao DAO
        return this.usuarioDAO.select(nome, login);
    }

    public List<Usuario> remakeLastSelect(){
        //Solicita os dados ao DAO
        return this.usuarioDAO.remakeLastSelect();
    }

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

    public boolean validateDataInsert(Usuario usuario) {
        return this.validateData(usuario, null);
    }

    public boolean validateDataUpdate(Usuario usuario, Usuario usuarioOriginal) {
        return this.validateData(usuario, usuarioOriginal);
    }

    //Método para validar os dados, privado pois só deve ser usado internamente
    private boolean validateData(Usuario usuario, Usuario usuarioOriginal) {
        return(usuario != null 
                && ValidationResponses.VALID == this.validateNome(usuario.getNome())
                && ValidationResponses.VALID == this.validateSenha(usuario.getSenha())
                && ValidationResponses.VALID == this.validateID(usuario.getID(), usuarioOriginal == null ? null : usuarioOriginal.getID())
                && ValidationResponses.VALID == this.validateLogin(usuario.getLogin(), usuarioOriginal == null ? null : usuarioOriginal.getLogin()));
    }

    //Método para validar o ID, privado pois só deve ser usado internamente
    public ValidationResponses validateID(Long ID, Long originalID) {
        if(ID != null) {
            if(ID < ServiceUtils.MIN_ID_VALUE) {
                return ValidationResponses.BELOW_MIN_VALUE;
            } else if (ID > ServiceUtils.MAX_ID_VALUE) {
                return ValidationResponses.MAX_VALUE_EXCEEDED;

              /*Verifica se o ID é diferente do ID original, se 
              for, verifica se ele já existe no banco de dados*/   
            } else if(!ID.equals(originalID) && this.isIdExists(ID)) {
                return ValidationResponses.ALREADY_EXISTS;
            } else {
                return ValidationResponses.VALID;
            }
        } else {
            return ValidationResponses.VALID;
        }
    }

    public ValidationResponses validateNome(String nome) {
        //Verifica se o nome tem menos de 100 caracteres
        if(nome.length() <= UsuarioService.NOME_MAX_LENGTH) {
            return ValidationResponses.VALID;
        } else {
            return ValidationResponses.MAX_LENGTH_EXCEEDED;
        }
    }

    public ValidationResponses validateLogin(String login, String originalLogin) {
        //Verifica se o login tem menos de 30 caracteres
        if(login.length() <= UsuarioService.LOGIN_MAX_LENGTH) {
            /*Se sim, verifica se o login é diferente do login original, 
            sendo diferente, verifica se ele já existe no banco de dados*/
            if(!login.equals(originalLogin) && this.isLoginExists(login)) {
                return ValidationResponses.ALREADY_EXISTS;
            } else {
                return ValidationResponses.VALID;
            }
        } else {
            return ValidationResponses.MAX_LENGTH_EXCEEDED;
        }
    }

    public ValidationResponses validateSenha(String senha) {
        //Verifica se a senha tem menos de 30 caracteres
        if(senha.length() <= UsuarioService.SENHA_MAX_LENGTH) {
            return ValidationResponses.VALID;
        } else {
            return ValidationResponses.MAX_LENGTH_EXCEEDED;
        }
    }
}
