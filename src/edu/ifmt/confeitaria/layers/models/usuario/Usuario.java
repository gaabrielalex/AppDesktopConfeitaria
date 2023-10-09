package edu.ifmt.confeitaria.layers.models.usuario;

import edu.ifmt.confeitaria.util.abstraction_classes.SuperModel;

public class Usuario extends SuperModel {
    private String nome;
    private String login;
    private String senha;

    /*Construtor vazio para configurações do DatabaseAcessComponentManager*/
    public Usuario() {
        super(null);
    }
   
    public Usuario(Long ID, String nome, String login, String senha) {
        super(ID);
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
