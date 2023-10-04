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
        return this.select("", "");
    }

    public List<Usuario> select(String nome, String login) {
        //Remove os espaços em branco do início e do fim das strings
        nome = nome.stripLeading().stripTrailing();
        login = login.stripLeading().stripTrailing();

        //Solicita os dados ao DAO
        return this.usuarioDAO.select(nome, login);
    }

    public List<Usuario> remakeLastSelect(){
        //Solicita os dados ao DAO
        return this.usuarioDAO.remakeLastSelect();
    }

    public void insert(Usuario usuario){
        //Solicita a inserção ao DAO
        this.usuarioDAO.insert(usuario);
    }

}
