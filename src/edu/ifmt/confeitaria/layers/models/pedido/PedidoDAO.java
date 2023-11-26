package edu.ifmt.confeitaria.layers.models.pedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ifmt.confeitaria.layers.models.cliente.Cliente;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPagto;
import edu.ifmt.confeitaria.layers.models.pedido.Pedido.StatusPedido;
import edu.ifmt.confeitaria.layers.models.usuario.Usuario;
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

    public List<String> selectAllMetodoPagto() {
        //Cria o PreparedStatement e o ResultSet
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        //Cria a query
        String sql =    "SELECT descricao " +
                        "FROM metodo_pagto " +
                            "ORDER BY descricao";

        try{
            //Define o PreparedStatement com o SQL
            statement = DBConnection.getConnection().prepareStatement(sql);

            //Obtém o ResultSet exexutando a query
            resultSet = statement.executeQuery();

            List<String> metodoPagtoList = new ArrayList<>();
            while(resultSet.next()) {
                metodoPagtoList.add(resultSet.getString("descricao"));
            }
            return metodoPagtoList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement, resultSet);
        }
    }

    // public List<Pedido> selectAll() {
    //     return this.partialSearch(null, null);
    // }
    
    public List<Pedido> partialSearch(String nomeCliente, String nomeDestinatario, StatusPagto statusPagto, StatusPedido statusPedido) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        /*Define por quais campos o usuário deseja realizar a pesquisa*/
        boolean selectByNomeCliente = nomeCliente != null && !nomeCliente.isEmpty();
        boolean selectByNomeDestinatario = nomeDestinatario != null && !nomeDestinatario.isEmpty();
        boolean selectByStatusPagto = statusPagto != null;
        boolean selectByStatusPedido = statusPedido != null;
        
        //Cria a query
        String sql =    "SELECT p.*, c.*, mp.descricao as metodo_pagto FROM pedido p LEFT JOIN cliente c ON p.id_cliente = c.id_cliente LEFT JOIN metodo_pagto mp ON p.id_metodo_pagto = mp.id_metodo_pagto " + 
                            "WHERE 1 = 1" +
                                (selectByNomeCliente ?  "AND unaccent(c.nome) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pelo nome do cliente, adiciona a condição à query
                                (selectByNomeDestinatario ?  "AND unaccent(p.nome_destinatario) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pelo nome do destinatário, adiciona a condição à query
                                (selectByStatusPagto ?  "AND p.status_pagto = ?" : "") +  // Se o usuário deseja pesquisar pelo status do pagamento, adiciona a condição à query
                                (selectByStatusPedido ?  "AND p.status_pedido = ?" : "") +  // Se o usuário deseja pesquisar pelo status do pedido, adiciona a condição à query
                        "ORDER BY p.data_hora_pedido DESC, c.nome, p.nome_destinatario, mp.descricao";

        /*Define o padrão de pesquisa em relação aos parâmetros fornecidos pelo usuário*/
        if(selectByNomeCliente) nomeCliente= "%" + nomeCliente + "%";
        if(selectByNomeDestinatario) nomeDestinatario= "%" + nomeDestinatario + "%";

        //Define uma variável para armazenar o índice do parâmetro a ser configurado
        int paramIndexCount = 1;
        try{
            //Define o PreparedStatement com o SQL
            statement = DBConnection.getConnection().prepareStatement(sql);

            //Configura os parâmetros necessários
            if(selectByNomeCliente) {
                statement.setString(paramIndexCount, nomeCliente);
                paramIndexCount++; //Incrementa o índice do parâmetro para que o próximo seja configurado corretamente
            }
            if(selectByNomeDestinatario) {
                statement.setString(paramIndexCount, nomeDestinatario);
                paramIndexCount++;
            }
            if(selectByStatusPagto) {
                statement.setString(paramIndexCount, Character.toString(statusPagto.getDescricao()));
                paramIndexCount++;
            }
            if(selectByStatusPedido) {
                statement.setString(paramIndexCount, Character.toString(statusPedido.getDescricao()));
                paramIndexCount++;
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
                StatusPagto.valueOf(resultSet.getString("status_pagto")),
                StatusPedido.valueOf(resultSet.getString("status_pedido")),
                resultSet.getString("observacoes"),
                new Cliente(
                    resultSet.getLong("id_cliente"),
                    resultSet.getString("nome"),
                    resultSet.getString("cpf"),
                    resultSet.getString("telefones"),
                    resultSet.getString("endereco"),
                    resultSet.getString("link_endereco")
                ),
                resultSet.getString("metodo_pagto"),
                new Usuario(
                    resultSet.getLong("id_usuario"),
                    resultSet.getString("nome"),
                    resultSet.getString("login"),
                    resultSet.getString("senha")
                )
            ));
        }
        return produtos;
    }   
}