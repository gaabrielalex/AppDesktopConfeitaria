/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ifmt.confeitaria.layers.models.usuario;

 import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.util.database.DBConnection;

/**
 *
 * @author Gabriel
 */
public class UsuarioDAO {
    //Attributes
    private String lastSQLSelect;

    //Getters and Setters

    //Methods
    /* ------ Operações básicas de banco de dados ------ */
    public List<Usuario> select(String nome, String login) {
        //Obtém a conexão com o banco de dados, cria o Statement e o ResultSet
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        /*Verifica se os parâmetros foram fornecidos e se não são vazios, ou seja,
        confere se o usuário deseja realizar a pesquisa por nome e/ou login*/
        boolean selectByName = nome != null && !nome.isEmpty();
        boolean selectByLogin = login != null && !login.isEmpty();
        
        //Cria a query
        String sql =    "SELECT *"+
                        "FROM usuario " +
                        "WHERE 1 = 1" +
                            (selectByName ?  "AND unaccent(nome) ILIKE unaccent(?)" : "") +  //Se o usuário deseja pesquisar por nome, adiciona a condição à query
                            (selectByLogin ? "AND unaccent(login) ILIKE unaccent(?)" : "") + //Se o usuário deseja pesquisar por login, adiciona a condição à query
                        "ORDER BY nome, login";

        /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
        nome= "%" + nome + "%";
        login = "%" + login + "%";

        //Define uma variável para armazenar o índice do parâmetro a ser configurado
        int paramIndexCount = 1;

        try{
           //Cria o PreparedStatement com o SQL
            statement = connection.prepareStatement(sql);

            //Configura os parâmetros necessários
            if(selectByName) {
                statement.setString(paramIndexCount, nome);
                paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
            } 
            if(selectByLogin) {
                statement.setString(paramIndexCount, login);
            }
            //Armazena o SQL para haver refefência da última consulta realizada pelo DAO
            this.lastSQLSelect = statement.toString();

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();

            return this.resultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
        finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    public List<Usuario> remakeLastSelect() {
        //Obtém a conexão com o banco de dados, cria o Statement e o ResultSet
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            //Cria o PreparedStatement com o SQL da última consulta
            statement = connection.prepareStatement(this.lastSQLSelect);

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();

            return this.resultSetToList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } 
        finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    public void insert(Usuario usuario) {
        //Obtém a conexão com o banco de dados, cria o Statement e o ResultSet
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        
        //Cria a query
        String sql =    "INSERT INTO usuario(id_cliente, nome, login, senha) " +
                        "VALUES(?, ?, ?, ?)";
        
        try{
            //Cria o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = connection.prepareStatement(sql);
            
            // Verifica se o ID do usuário foi fornecido
            if(usuario.getIdUsuario() == null) {
                // O ID será gerado pelo PostgreSQL
                statement.setNull(1, java.sql.Types.INTEGER);
            } else {
                // O ID foi fornecido pelo usuário
                statement.setLong(1, usuario.getIdUsuario());
            }
            statement.setString(2, usuario.getNome());
            statement.setString(3, usuario.getLogin());
            statement.setString(4, usuario.getSenha());
            
            //Executa a query
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    /* ------ Métodos/Operações auxiliares ------ */
    public List<Usuario> resultSetToList(ResultSet resultSet){
        //Cria uma lista de usuários e a preenche com os dados do ResultSet
        List<Usuario> usuarios = new ArrayList<>();
        try {
            while(resultSet.next()) {
                usuarios.add(new Usuario(resultSet.getLong("id_usuario"),
                                         resultSet.getString("nome"),
                                         resultSet.getString("login"),
                                         resultSet.getString("senha")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }

}
