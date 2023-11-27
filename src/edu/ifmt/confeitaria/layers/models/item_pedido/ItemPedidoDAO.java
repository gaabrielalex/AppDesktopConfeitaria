package edu.ifmt.confeitaria.layers.models.item_pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPagto;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPedido;
import edu.ifmt.confeitaria.layers.models.produto.Produto;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
import edu.ifmt.confeitaria.util.database.DBConnection;

public class ItemPedidoDAO {
    private String lastSqlPartialSearch;

    /* ------ Operações básicas de banco de dados ------ */
    public List<ItemPedido> selectById(Long idItemPedido) {
        if(idItemPedido == null) return null;

        //Cria o PreparedStatement e o ResultSet
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        //Cria a query
        String sql =    "SELECT * " +
                        "FROM item_pedido " +
                            "WHERE id_item_pedido = ?";

        try{
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idItemPedido);

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

    public List<ItemPedido> selectAll() {
        return this.partialSearch(null, null);
    }
    
    public List<ItemPedido> partialSearch(String produto, String tipoChocolate) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        /*Define por quais campos o usuário deseja realizar a pesquisa*/
        boolean selectByProduto = produto != null && !produto.isEmpty();
        boolean selectByTipoChocolate = tipoChocolate != null && !tipoChocolate.isEmpty();
        
        //Cria a query
        String sql =    "SELECT item.*, ped.*, prod.*, tc.descricao as tipo_chocolate FROM item_pedido item, pedido ped, produto prod LEFT JOIN tipo_chocolate tc ON p.id_tipo_chocolate = tc.id_tipo_chocolate " +
                            "WHERE item.id_pedido = ped.id_pedido" +
                                "AND item.id_produto = prod.id_produto " +
                                (selectByProduto ?  "AND unaccent(prod.descricao) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pelo produto, adiciona a condição à query
                                (selectByTipoChocolate ? "AND tc.descricao = ?" : "") + // Se o usuário deseja pesquisar pelo tipo do chocolate, adiciona a condição à query
                        "ORDER BY prod.descricao, tc.descricao, item.vlr_total_item";

        /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
        produto = "%" + produto + "%";

        //Define uma variável para armazenar o índice do parâmetro a ser configurado
        int paramIndexCount = 1;
        try{
            //Define o PreparedStatement com o SQL
            statement = DBConnection.getConnection().prepareStatement(sql);

            //Configura os parâmetros necessários
            if(selectByProduto) {
                statement.setString(paramIndexCount, produto);
                paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
            } 
            if(selectByTipoChocolate) {
                statement.setString(paramIndexCount, tipoChocolate);
            }
            //Armazena o SQL para haver refefência da última consulta realizada pelo DAO
            this.lastSqlPartialSearch = statement.toString();

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

    // public List<ItemPedido> redoLastPartialSearch() {
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

    // public boolean insert(Produto produto) {
    //     PreparedStatement statement = null;
    //     try {
    //         //Cria a query
    //         String sql =    "INSERT INTO produto(descricao, vlr_unitario, observacoes, id_tipo_chocolate)" +
    //                         "VALUES(?, ?, ?, (select id_tipo_chocolate from tipo_chocolate where descricao = ?)) " +
    //                         "RETURNING id_produto";
            
    //         //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
    //         statement = DBConnection.getConnection().prepareStatement(sql);
    //         statement.setString(1, produto.getDescricao());
    //         statement.setBigDecimal(2, produto.getVlrUnitario());
    //         statement.setString(3, produto.getObservacoes());
    //         statement.setString(4, produto.getTipoChocolate());
            
    //         //Executa a query e obtém o ResultSet(que deverá conter o ID do produto retornado pela inserção)
    //         ResultSet resultSet = statement.executeQuery();
    //         if(resultSet.next()) {
    //             //Se a inserção foi realizada com sucesso, define o ID do produto
    //             produto.setID(resultSet.getLong("id_produto"));
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

    // public boolean update(Produto produto, Long originalID) {
    //     if(originalID == null) return false;
    //     PreparedStatement statement = null;

    //     //Cria a query
    //         String sql =    "UPDATE produto " +
    //                         "SET id_produto = ?, descricao = ?, vlr_unitario = ?, observacoes = ?," +
    //                             "id_tipo_chocolate = (select id_tipo_chocolate from tipo_chocolate where descricao = ?) " +
    //                         "WHERE id_produto = ?";

    //     try {
    //         //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
    //         statement = DBConnection.getConnection().prepareStatement(sql);
    //         statement.setLong(1, produto.getID());
    //         statement.setString(2, produto.getDescricao());
    //         statement.setBigDecimal(3, produto.getVlrUnitario());
    //         statement.setString(4, produto.getObservacoes());
    //         statement.setString(5, produto.getTipoChocolate());
    //         statement.setLong(6, originalID);
            
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

    // public boolean delete(Long idItemPedido) {
    //     if(idItemPedido == null) return false;
    //     PreparedStatement statement = null;

    //     //Cria a query
    //     String sql =    "DELETE FROM produto " +
    //                     "WHERE id_produto = ?";
        
    //     try {
    //         //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
    //         statement = DBConnection.getConnection().prepareStatement(sql);
    //         statement.setLong(1, idItemPedido);
            
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
    public List<ItemPedido> resultSetToList(ResultSet resultSet) throws SQLException {
        List<ItemPedido> itensPedido = new ArrayList<>();
        
        //Percorre o ResultSet preenchendo a lista de produtos
        while(resultSet.next()) {
             StatusPagto statusPagto = null;
            StatusPedido statusPedido = null;
            try {
                for (StatusPagto value : StatusPagto.values()) {
                    if(value.getDescricao() == resultSet.getString("status_pagto").charAt(0)) {
                        statusPagto = value;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                for (StatusPedido value : StatusPedido.values()) {
                    if(value.getDescricao() == resultSet.getString("status_pedido").charAt(0)) {
                        statusPedido = value;
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            itensPedido.add(new ItemPedido(
                    resultSet.getLong("id_item_pedido"),
                    resultSet.getInt("qtde"),
                    resultSet.getBigDecimal("vlr_total_item"),
                    new Pedido(
                        resultSet.getLong("id_pedido"),
                        new Usuario(
                            resultSet.getLong("id_usuario"),
                            resultSet.getString("nome_usuario"),
                            resultSet.getString("login"),
                            resultSet.getString("senha")
                        ),
                        new Cliente(
                            resultSet.getLong("id_cliente"),
                            resultSet.getString("nome_cliente"),
                            resultSet.getString("cpf"),
                            resultSet.getString("telefones"),
                            resultSet.getString("endereco"),
                            resultSet.getString("link_endereco")
                        ),
                        resultSet.getDate("dt_hr_pedido"),
                        resultSet.getDate("dt_hr_entrega"),
                        resultSet.getBigDecimal("vlr_total_pedido"),
                        resultSet.getBigDecimal("desconto"),
                        resultSet.getString("nome_destinatario"),
                        resultSet.getBoolean("retirada_loja"),
                        statusPagto,
                        statusPedido,
                        resultSet.getString("observacoes"),
                        resultSet.getString("metodo_pagto")
                    ),
                    new Produto(resultSet.getLong("id_produto"),
                        resultSet.getString("descricao"),
                        resultSet.getBigDecimal("vlr_unitario"),
                        resultSet.getString("observacoes"),
                        resultSet.getString("tipo_chocolate"))
                ));
        }
        return itensPedido;
    }
}
