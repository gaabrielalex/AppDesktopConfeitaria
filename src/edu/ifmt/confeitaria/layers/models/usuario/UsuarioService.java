package edu.ifmt.confeitaria.layers.models.usuario;

import java.util.List;

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
        if(usuario != null && usuario.getNome().length() <= 100 && usuario.getLogin().length() <= 30 && usuario.getSenha().length() <= 30
                && usuario.getIdUsuario() > 0 && !this.isIdExists(usuario.getIdUsuario()) && !this.isLoginExists(usuario.getLogin())) {

            /*Caso os dados sejam válidos, solicita ao DAO a inserção
            do usuário no banco de daods já retornando o resultado*/
            return this.usuarioDAO.insert(usuario);
        } else {
            return false;
        }
        
    }

    /* ----- Regras de negócio ----- */
    public boolean isIdExists(Long idUsuario){
        //Solicta ao DAO a lista de usuários com o id especificado
        List<Usuario> usuarios = this.usuarioDAO.selectById(idUsuario);

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

}
