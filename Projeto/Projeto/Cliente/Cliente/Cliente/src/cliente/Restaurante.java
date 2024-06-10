package cliente;

import cliente.Conexao;
import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Restaurante {
    private Connection conn;
    private PreparedStatement pstm;
    private ResultSet rs;

    public void inserir(Pessoa pessoa){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso");
        
        try {
            pstm = conn.prepareStatement("INSERT INTO RESTAURANTE (NOME,CPF,SENHA) VALUES (?, ?,?)");
            pstm.setString(1, pessoa.getNome());
            pstm.setString(2, pessoa.getCpf());
            pstm.setString(3, pessoa.getSenha());
            pstm.execute();
            System.out.println("Inserido com sucesso");
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir no DB: " + ex.getMessage());
        }
    }
        public void inserirCpf(String cpf){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso");
        
        try {
            pstm = conn.prepareStatement("INSERT INTO PEDIDOS (CPF) VALUES (?)");
           
            pstm.setString(1, cpf);
            
            pstm.execute();
            System.out.println("Inserido com sucesso");
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir no DB: " + ex.getMessage());
        }
    }
    
    public void InserirPedido(Pedido pedido, String cpf){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        if (conn==null)
            System.out.println("Erro na conexão");
        else
            System.out.println("Conectado com sucesso");
        
        try {
            pstm = conn.prepareStatement("UPDATE PEDIDOS SET XSALADA= ?, XBURGER= ?, CACHORROQUENTE= ?, MISTOQUENTE= ?, SALADADEFRUTAS= ?, REFRIGERANTE= ?, SUCONATURAL= ? WHERE CPF = ?");
            
            pstm.setInt(1, pedido.getXsalada());
            pstm.setInt(2, pedido.getXburger());
            pstm.setInt(3, pedido.getCachorroquente());
            pstm.setInt(4, pedido.getMistoquente());
            pstm.setInt(5, pedido.getSaladadefrutas());
            pstm.setInt(6, pedido.getRefrigerante());
            pstm.setInt(7, pedido.getSuconatural());
            pstm.setString(8, pedido.getCpf());
            pstm.execute();
            System.out.println("Inserido com sucesso");
            System.out.println(pedido);
            System.out.println(cpf);
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir no DB: " + ex.getMessage());
        }
    }
    
    public void remover(String nome){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        
        try {
            String remove = "DELETE FROM RESTAURANTE WHERE CPF = ?";
            pstm = conn.prepareStatement(remove);
            pstm.setString(1, nome);
            pstm.execute();
            System.out.println("Removido com sucesso");
            conexao.desconectar();
        } catch (SQLException e) {
            conexao.desconectar();
            System.err.println("Falha ao remover no DB: " + e.getMessage());
        }
    }
        public void RemoverPedido(Pedido pedido){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        
        try {
            String remove = "DELETE FROM PEDIDOS WHERE CPF = ?";
            pstm = conn.prepareStatement(remove);
            pstm.setString(1, pedido.cpf);
            pstm.execute();
            System.out.println("Removido com sucesso");
            conexao.desconectar();
        } catch (SQLException e) {
            conexao.desconectar();
            System.err.println("Falha ao remover no DB: " + e.getMessage());
        }
    }
    public void alterar(String NomeAl,String NomeAt){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstm = conn.prepareStatement("UPDATE RESTAURANTE SET NOME = ? WHERE NOME = ?");
            // Setando o valor ao parâmetro​
            pstm.setString(2, NomeAl);
            pstm.setString(1, NomeAt);
            
            
            // Executando o comando sql do objeto preparedStatement​
            pstm.execute();
            System.out.println("Alterado com Sucesso");
            // Fechando a conexão com o banco​
            conexao.desconectar();
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
        }
    
    }
    public void AlterarPedido(Pedido pedido){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstm = conn.prepareStatement("UPDATE PEDIDOS SET XSALADA= ?, XBURGER= ?, CACHORROQUENTE= ?, MISTOQUENTE= ?, SALADADEFRUTAS= ?, REFRIGERANTE= ?, SUCONATURAL= ? WHERE CPF = ?");
            // Setando o valor ao parâmetro​
            pstm.setInt(1, pedido.getXsalada());
            pstm.setInt(2, pedido.getXburger());
            pstm.setInt(3, pedido.getCachorroquente());
            pstm.setInt(4, pedido.getMistoquente());
            pstm.setInt(5, pedido.getSaladadefrutas());
            pstm.setInt(6, pedido.getRefrigerante());
            pstm.setInt(7, pedido.getSuconatural());
            pstm.setString(8, pedido.getCpf());
            
            
            // Executando o comando sql do objeto preparedStatement​
            pstm.execute();
            System.out.println("Alterado com Sucesso");
            // Fechando a conexão com o banco​
            conexao.desconectar();
        } catch (SQLException e) {
            // Fechando a conexão com o banco​
            conexao.desconectar();
        }
    
    }
    public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstm = conn.prepareStatement("SELECT * FROM RESTAURANTE ORDER BY NOME");
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    public ResultSet buscarPorNome(String nome) {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            pstm = conn.prepareStatement("SELECT * FROM RESTAURANTE WHERE NOME = ? ORDER BY CPF");
            pstm.setString(1, nome);
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
}