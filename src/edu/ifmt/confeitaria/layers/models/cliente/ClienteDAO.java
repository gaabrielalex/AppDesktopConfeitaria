package edu.ifmt.confeitaria.layers.models.cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.util.database.DBConnection;

public class ClienteDAO {
    private String lastSqlPartialSearch;

    /* ------ Operações básicas de banco de dados ------ */
    public List<Cliente> selectById(Long idCliente) {
        if(idCliente == null) return null;

        //Cria o PreparedStatement e o ResultSet
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        //Cria a query
        String sql =    "SELECT * " +
                        "FROM cliente " +
                            "WHERE id_cliente = ?";

        try{
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idCliente);

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();
            
            return this.resultSetToList(resultSet); 
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    // public List<Cliente> selectAll() {
    //     return this.partialSearch(null, null);
    // }
    
    // public List<Cliente> partialSearch(String nome, String login) {
    //     PreparedStatement statement = null;
    //     ResultSet resultSet = null;

    //     /*Verifica se os parâmetros foram fornecidos e se não são vazios, ou seja,
    //     confere se o usuário deseja realizar a pesquisa por nome e/ou login*/
    //     boolean selectByNome = nome != null && !nome.isEmpty();
    //     boolean selectByLogin = login != null && !login.isEmpty();
        
    //     //Cria a query
    //     String sql =    "SELECT *"+
    //                     "FROM usuario " +
    //                         "WHERE 1 = 1" +
    //                             (selectByNome ?  "AND unaccent(nome) ILIKE unaccent(?)" : "") +  //Se o usuário deseja pesquisar por nome, adiciona a condição à query
    //                             (selectByLogin ? "AND unaccent(login) ILIKE unaccent(?)" : "") + //Se o usuário deseja pesquisar por login, adiciona a condição à query
    //                     "ORDER BY nome, login";

    //     /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
    //     nome= "%" + nome + "%";
    //     login = "%" + login + "%";

    //     //Define uma variável para armazenar o índice do parâmetro a ser configurado
    //     int paramIndexCount = 1;
    //     try{
    //         //Define o PreparedStatement com o SQL
    //         statement = DBConnection.getConnection().prepareStatement(sql);

    //         //Configura os parâmetros necessários
    //         if(selectByNome) {
    //             statement.setString(paramIndexCount, nome);
    //             paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
    //         } 
    //         if(selectByLogin) {
    //             statement.setString(paramIndexCount, login);
    //         }
    //         //Armazena o SQL para haver refefência da última consulta realizada pelo DAO
    //         this.lastSqlPartialSearch = statement.toString();

    //         //Obtém o ResultSet exexutando a query
    //         resultSet = statement.executeQuery();

    //         return this.resultSetToList(resultSet);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     } finally {
    //         //Fecha a conexão com o banco de dados e os recursos criados a partir dela
    //         DBConnection.closeConnection(statement, resultSet);
    //     }
    // }

    // public List<Cliente> redoLastPartialSearch() {
    //     PreparedStatement statement = null;
    //     ResultSet resultSet = null;

    //     try{
    //         //Define o PreparedStatement com o SQL da última consulta
    //         statement = DBConnection.getConnection().prepareStatement(this.lastSqlPartialSearch);

    //         //Obtém o ResultSet exexutando a query
    //         resultSet = statement.executeQuery();

    //         return this.resultSetToList(resultSet);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         return null;
    //     } finally {
    //         //Fecha a conexão com o banco de dados e os recursos criados a partir dela
    //         DBConnection.closeConnection(statement, resultSet);
    //     }
    // }

    // public boolean insert(Usuario usuario) {
    //     PreparedStatement statement = null;
    //     try {
    //         //Cria a query
    //         String sql =    "INSERT INTO usuario(nome, login, senha) " +
    //                         "VALUES(?, ?, ?) RETURNING id_usuario";
            
    //         //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
    //         statement = DBConnection.getConnection().prepareStatement(sql);
    //         statement.setString(1, usuario.getNome());
    //         statement.setString(2, usuario.getLogin());
    //         statement.setString(3, usuario.getSenha());
            
    //         //Executa a query e obtém o ResultSet(que deverá conter o ID do usuário retornado pela inserção)
    //         ResultSet resultSet = statement.executeQuery();
    //         if(resultSet.next()) {
    //             //Se a inserção foi realizada com sucesso, define o ID do usuário
    //             usuario.setID(resultSet.getLong("id_usuario"));
    //         }
    //         //Se a inserção foi realizada com sucesso, retorna true
    //         return true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         //Se a inserção não foi realizada com sucesso, retorna false
    //         return false;
    //     } finally {
    //         //Fecha a conexão com o banco de dados e os recursos criados a partir dela
    //         DBConnection.closeConnection(statement);
    //     }
    // }

    // public boolean update(Usuario usuario, Long originalID) {
    //     if(originalID == null) return false;
    //     PreparedStatement statement = null;

    //     //Cria a query
    //         String sql =    "UPDATE usuario " +
    //                         "SET id_usuario = ?, nome = ?, login = ?, senha = ? " +
    //                             "WHERE id_usuario = ?";

    //     try {
    //         //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
    //         statement = DBConnection.getConnection().prepareStatement(sql);
    //         statement.setLong(1, usuario.getID());
    //         statement.setString(2, usuario.getNome());
    //         statement.setString(3, usuario.getLogin());
    //         statement.setString(4, usuario.getSenha());
    //         statement.setLong(5, originalID);
            
    //         //Executa a query
    //         statement.executeUpdate();

    //         //Se a atualização foi realizada com sucesso, retorna true
    //         return true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         //Se a atualização não foi realizada com sucesso, retorna false
    //         return false;
    //     } finally {
    //         //Fecha a conexão com o banco de dados e os recursos criados a partir dela
    //         DBConnection.closeConnection(statement);
    //     }
    // }

    // public boolean delete(Long idUsuario) {
    //     if(idUsuario == null) return false;
    //     PreparedStatement statement = null;

    //     //Cria a query
    //     String sql =    "DELETE FROM usuario " +
    //                     "WHERE id_usuario = ?";
        
    //     try {
    //         //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
    //         statement = DBConnection.getConnection().prepareStatement(sql);
    //         statement.setLong(1, idUsuario);
            
    //         //Executa a query
    //         statement.executeUpdate();

    //         //Se a exclusão foi realizada com sucesso, retorna true
    //         return true;
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //         //Se a exclusão não foi realizada com sucesso, retorna false
    //         return false;
    //     } finally {
    //         //Fecha a conexão com o banco de dados e os recursos criados a partir dela
    //         DBConnection.closeConnection(statement);
    //     }
    // }

    /* ------ Métodos/Operações auxiliares ------ */
    public List<Cliente> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        
        //Percorre o ResultSet preenchendo a lista de usuários
        while(resultSet.next()) {
            clientes.add(new Cliente(resultSet.getLong("id_cliente"),
                                    resultSet.getString("nome"),
                                    resultSet.getString("cpf"),
                                    resultSet.getString("telefones"),
                                    resultSet.getString("endereco"),
                                    resultSet.getString("link_endereco")));
        }
        return clientes;
    }
}