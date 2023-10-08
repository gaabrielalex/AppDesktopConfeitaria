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
        /*Solicita a inserção ao DAO já retornando o resultado,
        se a inserção foi bem sucedida ou não*/
        return this.usuarioDAO.insert(usuario);
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

}
