package edu.ifmt.confeitaria.layers.models.pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.util.database.DBConnection;

public class PedidoDAO {
    private String lastSqlPartialSearch;

    /* ------ Operações básicas de banco de dados ------ */
    public List<Pedido> selectById(Long idPedido) {
        if(idPedido == null) return null;

        //Cria o PreparedStatement e o ResultSet
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        //Cria a query
        String sql =    "SELECT * " +
                        "FROM pedido " +
                            "WHERE id_pedido = ?";

        try{
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idPedido);

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

//     public List<String> selectAllTipoChocolate() {
//         //Cria o PreparedStatement e o ResultSet
//         PreparedStatement statement = null;
//         ResultSet resultSet = null;

//         //Cria a query
//         String sql =    "SELECT descricao " +
//                         "FROM tipo_chocolate " +
//                             "ORDER BY descricao";

//         try{
//             //Define o PreparedStatement com o SQL
//             statement = DBConnection.getConnection().prepareStatement(sql);

//             //Obtém o ResultSet exexutando a query
//             resultSet = statement.executeQuery();

//             List<String> tipoChocolateList = new ArrayList<>();
//             while(resultSet.next()) {
//                 tipoChocolateList.add(resultSet.getString("descricao"));
//             }
//             return tipoChocolateList;
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return null;
//         } finally {
//             //Fecha a conexão com o banco de dados e os recursos criados a partir dela
//             DBConnection.closeConnection(statement, resultSet);
//         }
//     }

//     public List<Pedido> selectAll() {
//         return this.partialSearch(null, null);
//     }
    
//     public List<Pedido> partialSearch(String descricao, String tipoChocolate) {
//         PreparedStatement statement = null;
//         ResultSet resultSet = null;

//         /*Verifica se os parâmetros foram fornecidos e se não são vazios, ou seja,
//         confere se o usuário deseja realizar a pesquisa pela descrição do produto e/ou pelo tipo do chocolate*/
//         boolean selectByDescricao = descricao != null && !descricao.isEmpty();
//         boolean selectByTipoChocolate = tipoChocolate != null && !tipoChocolate.isEmpty();
        
//         //Cria a query
//         String sql =    "SELECT p.*, tc.descricao as tipo_chocolate FROM produto p LEFT JOIN tipo_chocolate tc ON p.id_tipo_chocolate = tc.id_tipo_chocolate " +
//                             "WHERE 1 = 1" +
//                                 (selectByDescricao ?  "AND unaccent(p.descricao) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pela descrição, adiciona a condição à query
//                                 (selectByTipoChocolate ? "AND tc.descricao = ?" : "") + // Se o usuário deseja pesquisar pelo tipo do chocolate, adiciona a condição à query
//                         "ORDER BY p.descricao, tc.descricao, p.vlr_unitario";

//         /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
//         descricao= "%" + descricao + "%";

//         //Define uma variável para armazenar o índice do parâmetro a ser configurado
//         int paramIndexCount = 1;
//         try{
//             //Define o PreparedStatement com o SQL
//             statement = DBConnection.getConnection().prepareStatement(sql);

//             //Configura os parâmetros necessários
//             if(selectByDescricao) {
//                 statement.setString(paramIndexCount, descricao);
//                 paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
//             } 
//             if(selectByTipoChocolate) {
//                 statement.setString(paramIndexCount, tipoChocolate);
//             }
//             //Armazena o SQL para haver refefência da última consulta realizada pelo DAO
//             this.lastSqlPartialSearch = statement.toString();

//             //Obtém o ResultSet exexutando a query
//             resultSet = statement.executeQuery();

//             return this.resultSetToList(resultSet);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return null;
//         } finally {
//             //Fecha a conexão com o banco de dados e os recursos criados a partir dela
//             DBConnection.closeConnection(statement, resultSet);
//         }
//     }

//     public List<Pedido> redoLastPartialSearch() {
//         PreparedStatement statement = null;
//         ResultSet resultSet = null;

//         try{
//             //Define o PreparedStatement com o SQL da última consulta
//             statement = DBConnection.getConnection().prepareStatement(this.lastSqlPartialSearch);

//             //Obtém o ResultSet exexutando a query
//             resultSet = statement.executeQuery();

//             return this.resultSetToList(resultSet);
//         } catch (SQLException e) {
//             e.printStackTrace();
//             return null;
//         } finally {
//             //Fecha a conexão com o banco de dados e os recursos criados a partir dela
//             DBConnection.closeConnection(statement, resultSet);
//         }
//     }

//     public boolean insert(Produto produto) {
//         PreparedStatement statement = null;
//         try {
//             //Cria a query
//             String sql =    "INSERT INTO produto(descricao, vlr_unitario, observacoes, id_tipo_chocolate)" +
//                             "VALUES(?, ?, ?, (select id_tipo_chocolate from tipo_chocolate where descricao = ?)) " +
//                             "RETURNING id_produto";
            
//             //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
//             statement = DBConnection.getConnection().prepareStatement(sql);
//             statement.setString(1, produto.getDescricao());
//             statement.setBigDecimal(2, produto.getVlrUnitario());
//             statement.setString(3, produto.getObservacoes());
//             statement.setString(4, produto.getTipoChocolate());
            
//             //Executa a query e obtém o ResultSet(que deverá conter o ID do produto retornado pela inserção)
//             ResultSet resultSet = statement.executeQuery();
//             if(resultSet.next()) {
//                 //Se a inserção foi realizada com sucesso, define o ID do produto
//                 produto.setID(resultSet.getLong("id_produto"));
//             }
//             //Se a inserção foi realizada com sucesso, retorna true
//             return true;
//         } catch (SQLException e) {
//             e.printStackTrace();
//             //Se a inserção não foi realizada com sucesso, retorna false
//             return false;
//         } finally {
//             //Fecha a conexão com o banco de dados e os recursos criados a partir dela
//             DBConnection.closeConnection(statement);
//         }
//     }

//     public boolean update(Produto produto, Long originalID) {
//         if(originalID == null) return false;
//         PreparedStatement statement = null;

//         //Cria a query
//             String sql =    "UPDATE produto " +
//                             "SET id_produto = ?, descricao = ?, vlr_unitario = ?, observacoes = ?," +
//                                 "id_tipo_chocolate = (select id_tipo_chocolate from tipo_chocolate where descricao = ?) " +
//                             "WHERE id_produto = ?";

//         try {
//             //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
//             statement = DBConnection.getConnection().prepareStatement(sql);
//             statement.setLong(1, produto.getID());
//             statement.setString(2, produto.getDescricao());
//             statement.setBigDecimal(3, produto.getVlrUnitario());
//             statement.setString(4, produto.getObservacoes());
//             statement.setString(5, produto.getTipoChocolate());
//             statement.setLong(6, originalID);
            
//             //Executa a query
//             statement.executeUpdate();

//             //Se a atualização foi realizada com sucesso, retorna true
//             return true;
//         } catch (SQLException e) {
//             e.printStackTrace();
//             //Se a atualização não foi realizada com sucesso, retorna false
//             return false;
//         } finally {
//             //Fecha a conexão com o banco de dados e os recursos criados a partir dela
//             DBConnection.closeConnection(statement);
//         }
//     }

//     public boolean delete(Long idPedido) {
//         if(idPedido == null) return false;
//         PreparedStatement statement = null;

//         //Cria a query
//         String sql =    "DELETE FROM produto " +
//                         "WHERE id_produto = ?";
        
//         try {
//             //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
//             statement = DBConnection.getConnection().prepareStatement(sql);
//             statement.setLong(1, idPedido);
            
//             //Executa a query
//             statement.executeUpdate();

//             //Se a exclusão foi realizada com sucesso, retorna true
//             return true;
//         } catch (SQLException e) {
//             e.printStackTrace();
//             //Se a exclusão não foi realizada com sucesso, retorna false
//             return false;
//         } finally {
//             //Fecha a conexão com o banco de dados e os recursos criados a partir dela
//             DBConnection.closeConnection(statement);
//         }
//     }

    /* ------ Métodos/Operações auxiliares ------ */
    public List<Pedido> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Pedido> produtos = new ArrayList<>();
        
        //Percorre o ResultSet preenchendo a lista de produtos
        while(resultSet.next()) {
            produtos.add(new Pedido(
                resultSet.getLong("id_pedido"),
                resultSet.getDate("dt_hr_pedido"),
                resultSet.getDate("dt_hr_entrega"),
                resultSet.getBigDecimal("vlr_total_pedido"),
                resultSet.getBigDecimal("desconto"),
                resultSet.getString("nome_destinatario"),
                resultSet.getBoolean("retirada_loja"),
                resultSet.getString("status_pagto").charAt(0),
                resultSet.getString("status_pedido").charAt(0),
                resultSet.getString("observacoes"),
                resultSet.getLong("id_cliente"),
                resultSet.getLong("id_metodo_pagto"),
                resultSet.getLong("id_usuario")
            ));
        }
        return produtos;
    }   
}