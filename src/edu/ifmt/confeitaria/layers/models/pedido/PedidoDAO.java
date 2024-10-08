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

    public List<Pedido> selectAll() {
        return this.partialSearch(null, null, null, null);
    }
    
    public List<Pedido> partialSearch(String nomeCliente, String nomeDestinatario, StatusPagto statusPagto, StatusPedido statusPedido) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        /*Define por quais campos o usuário deseja realizar a pesquisa*/
        boolean selectByNomeCliente = nomeCliente != null && !nomeCliente.isEmpty();
        boolean selectByNomeDestinatario = nomeDestinatario != null && !nomeDestinatario.isEmpty();
        boolean selectByStatusPagto = statusPagto != null;
        boolean selectByStatusPedido = statusPedido != null;
        
        //Cria a query
        String sql =    "SELECT u.*, u.nome AS nome_usuario, p.*, c.*, c.nome AS nome_cliente, mp.descricao AS metodo_pagto FROM usuario u, pedido p LEFT JOIN cliente c ON p.id_cliente = c.id_cliente LEFT JOIN metodo_pagto mp ON p.id_metodo_pagto = mp.id_metodo_pagto " + 
                            "WHERE p.id_usuario = u.id_usuario " +
                                (selectByNomeCliente ?  "AND unaccent(c.nome) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pelo nome do cliente, adiciona a condição à query
                                (selectByNomeDestinatario ?  "AND unaccent(p.nome_destinatario) ILIKE unaccent(?)" : "") +  // Se o usuário deseja pesquisar pelo nome do destinatário, adiciona a condição à query
                                (selectByStatusPagto ?  "AND p.status_pagto = ?" : "") +  // Se o usuário deseja pesquisar pelo status do pagamento, adiciona a condição à query
                                (selectByStatusPedido ?  "AND p.status_pedido = ?" : "") +  // Se o usuário deseja pesquisar pelo status do pedido, adiciona a condição à query
                        "ORDER BY p.dt_hr_pedido DESC, c.nome, p.nome_destinatario, mp.descricao";

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

    public List<Pedido> redoLastPartialSearch() {
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            //Define o PreparedStatement com o SQL da última consulta
            statement = DBConnection.getConnection().prepareStatement(this.lastSqlPartialSearch);

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

    public boolean insert(Pedido pedido) {
        PreparedStatement statement = null;
        try {
            //Cria a query
            String sql =    "INSERT INTO pedido(dt_hr_pedido, dt_hr_entrega, vlr_total_pedido, " +
                                "desconto, nome_destinatario, retirada_loja, status_pagto, status_pedido, " +
                                "observacoes, id_cliente, id_metodo_pagto, id_usuario) " +
                            "VALUES(? , ?, ?, ?, ?, ?, ?, ?, ?, ?, (select id_metodo_pagto from metodo_pagto where descricao = ?), ?) " +
                            "RETURNING id_pedido";
            
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setDate(1, pedido.getDtHrPedido() == null ? null : new java.sql.Date(pedido.getDtHrPedido().getTime()));
            statement.setDate(2, pedido.getDtHrEntrega() == null ? null : new java.sql.Date(pedido.getDtHrEntrega().getTime()));
            statement.setBigDecimal(3, pedido.getVlrTotalPedido());
            statement.setBigDecimal(4, pedido.getDesconto());
            statement.setString(5, pedido.getNomeDestinatario());
            statement.setBoolean(6, pedido.isRetiradaLoja());
            statement.setString(7, pedido.getStatusPagto() == null ? null : Character.toString(pedido.getStatusPagto().getDescricao()));
            statement.setString(8, pedido.getStatusPagto() == null ? null : Character.toString(pedido.getStatusPedido().getDescricao()));
            statement.setString(9, pedido.getObservacoes());
            statement.setLong(10, pedido.getCliente().getID());
            statement.setString(11, pedido.getMetodoPagto());
            statement.setLong(12, pedido.getUsuario().getID());
            
            //Executa a query e obtém o ResultSet(que deverá conter o ID do pedido retornado pela inserção)
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()) {
                //Se a inserção foi realizada com sucesso, define o ID do pedido
                pedido.setID(resultSet.getLong("id_pedido"));
            }
            //Se a inserção foi realizada com sucesso, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //Se a inserção não foi realizada com sucesso, retorna false
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    public boolean update(Pedido pedido, Long originalID) {
        if(originalID == null) return false;
        PreparedStatement statement = null;

        //Cria a query
            String sql =    "UPDATE pedido " +
                            "SET id_pedido = ?, dt_hr_pedido = ?, dt_hr_entrega = ?, vlr_total_pedido = ?, " +
                                "desconto = ?, nome_destinatario = ?, retirada_loja = ?, status_pagto = ?, status_pedido = ?, " +
                                "observacoes = ?, id_cliente = ?, id_metodo_pagto = (select id_metodo_pagto from metodo_pagto where descricao = ?), id_usuario = ? " +
                            "WHERE id_pedido = ?";                         

        try {
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, pedido.getID());
            statement.setDate(2, pedido.getDtHrPedido() == null ? null : new java.sql.Date(pedido.getDtHrPedido().getTime()));
            statement.setDate(3, pedido.getDtHrEntrega() == null ? null : new java.sql.Date(pedido.getDtHrEntrega().getTime()));
            statement.setBigDecimal(4, pedido.getVlrTotalPedido());
            statement.setBigDecimal(5, pedido.getDesconto());
            statement.setString(6, pedido.getNomeDestinatario());
            statement.setBoolean(7, pedido.isRetiradaLoja());
            statement.setString(8, pedido.getStatusPagto() == null ? null : Character.toString(pedido.getStatusPagto().getDescricao()));
            statement.setString(9, pedido.getStatusPagto() == null ? null : Character.toString(pedido.getStatusPedido().getDescricao()));
            statement.setString(10, pedido.getObservacoes());
            statement.setLong(11, pedido.getCliente().getID());
            statement.setString(12, pedido.getMetodoPagto());
            statement.setLong(13, pedido.getUsuario().getID());
            statement.setLong(14, originalID);
            
            //Executa a query
            statement.executeUpdate();

            //Se a atualização foi realizada com sucesso, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //Se a atualização não foi realizada com sucesso, retorna false
            return false;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    public boolean delete(Long idPedido) {
        if(idPedido == null) return false;
        PreparedStatement statement = null;

        //Cria a query
        String sql =    "DELETE FROM pedido " +
                        "WHERE id_pedido = ?";
        
        try {
            //Define o PreparedStatement com o SQL, em seguida, configura os parâmetros necessários
            statement = DBConnection.getConnection().prepareStatement(sql);
            statement.setLong(1, idPedido);
            
            //Executa a query
            statement.executeUpdate();

            //Se a exclusão foi realizada com sucesso, retorna true
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            //Se a exclusão não foi realizada com sucesso, retorna false
            return false;
        } finally {
            //Fecha a conexão com o banco de dados e os recursos criados a partir dela
            DBConnection.closeConnection(statement);
        }
    }

    /* ------ Métodos/Operações auxiliares ------ */
    public List<Pedido> resultSetToList(ResultSet resultSet) throws SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        
        //Percorre o ResultSet preenchendo a lista de pedidos
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

            pedidos.add(new Pedido(
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
            ));
        }
        return pedidos;
    }   
}
