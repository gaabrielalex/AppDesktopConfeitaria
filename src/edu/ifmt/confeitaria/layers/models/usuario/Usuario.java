package edu.ifmt.confeitaria.layers.models.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {
    private int idUsuario;
    private String nome;
    private String login;
    private String senha;

    public Usuario(int idUsuario, String nome, String login, String senha) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public static Usuario fromResultSet(ResultSet resultSet) throws SQLException {
        return new Usuario(resultSet.getInt("id_usuario"),
                            resultSet.getString("nome"),
                            resultSet.getString("login"),
                            resultSet.getString("senha"));
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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
