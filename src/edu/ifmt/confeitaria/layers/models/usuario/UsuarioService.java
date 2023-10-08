package edu.ifmt.confeitaria.layers.models.usuario;

import java.util.List;

public class UsuarioService {
    //Attributes
    private final UsuarioDAO usuarioDAO;

    //Constructors
    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    //Methods
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

}
