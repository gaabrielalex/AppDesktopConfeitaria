package edu.ifmt.confeitaria.layers.models.usuario;

import java.util.List;

import edu.ifmt.confeitaria.util.service.ServiceUtils;

public class UsuarioService {
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
        return(usuario != null && usuario.getNome().length() <= 100 
                    && usuario.getSenha().length() <= 30
                    && this.validateID(usuario.getID(), usuarioOriginal == null ? null : usuarioOriginal.getID())
                    && this.validateLogin(usuario.getLogin(), usuarioOriginal == null ? null : usuarioOriginal.getLogin()));
    }

    //Método para validar o ID, privado pois só deve ser usado internamente
    private boolean validateID(Long ID, Long originalID) {
        //Verifica se o ID não é nulo e se é maior que 0
        if(ID != null && ID > 0 && ID <= ServiceUtils.MAX_ID_VALUE) {
            /*Verifica se o ID é diferente do ID original, se for, verifica se ele já existe no BD*/
            if(!ID.equals(originalID)) {
                return !this.isIdExists(ID);
            }
            return true;
        } else if(ID == null) {
            return true;
        } else {
            return false;
        }
    }

    //Método para validar o login, privado pois só deve ser usado internamente
    private boolean validateLogin(String login, String originalLogin) {
        //Verifica se o login tem menos de 30 caracteres
        if(login.length() <= 30 ) {
            /*Se sim, verifica se o login é diferente do login original, 
            sendo diferente, verifica se ele já existe no banco de dados*/
            if(!login.equals(originalLogin)){
                return !this.isLoginExists(login);
            }
            return true;
        } else {
            return false;
        }
    }
}
