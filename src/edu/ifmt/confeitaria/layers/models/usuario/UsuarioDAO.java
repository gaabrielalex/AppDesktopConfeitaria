/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.models.usuario;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.ifmt.confeitaria.util.database.ConnectionManager;
import edu.ifmt.confeitaria.util.database.DBConnection;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO {
    //Attributes
    private String lastSQLSelect;
    private ConnectionManager connectionManager;

    //Getters and Setters
    public ConnectionManager getConnectionManager() {
        return connectionManager;
    }

    //Methods
    public ResultSet select(String nome, String login) {
        //Obtém a conexão com o banco de dados e cria o Statement
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        /*Define as strings como vazias caso sejam nulas.*/
        nome = (nome == null) ? "" : nome;
        login = (login == null) ? "" : login;
        
        /*Define o padrão de pesquisa em relação 
        as strings por meio da adição das %*/
        nome= "%" + nome + "%";
        login = "%" + login + "%";
        
        //Cria a query
        String sql =    "SELECT *"+
                        "FROM usuario " +
                        "WHERE unaccent(nome) ILIKE unaccent(?)" +
                            "AND unaccent(login) ILIKE unaccent(?)" +
                        "ORDER BY nome, login";
                        
        try{
            //Cria o PreparedStatement com o SQL, configurando os parâmetros
            statement = connection.prepareStatement(sql);
            statement.setString(1, nome);
            statement.setString(2, login);

            //Armazena o SQL da última consulta
            this.lastSQLSelect = statement.toString();

            //Retorna o ResultSet exexutando a query
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
        finally {
            /*Configura o ConnectionManager com a conexão e o Statement, para 
            que eles sejam fechados pelas classes que utilizarem esse método*/	
            this.connectionManager = new ConnectionManager(connection, statement);
        }
    }

    public ResultSet remakeLastSelect() {
        //Obtém a conexão com o banco de dados e cria o Statement
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;

        try{
            //Cria o PreparedStatement com o SQL da última consulta
            statement = connection.prepareStatement(this.lastSQLSelect);

            //Retorna o ResultSet exexutando a query
            return statement.executeQuery();   
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
        finally {
            /*Configura o ConnectionManager com a conexão e o Statement, para 
            que eles sejam fechados pelas classes que utilizarem esse método*/	
            this.connectionManager = new ConnectionManager(connection, statement);
        }
    }
}
