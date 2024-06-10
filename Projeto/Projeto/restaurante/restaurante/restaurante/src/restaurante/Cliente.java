/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

import java.sql.SQLException;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author unielqualharello
 */
public class Cliente {
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
            pstm = conn.prepareStatement("INSERT INTO RESTAURANTE (CPF,NOME,SENHA) VALUES (?, ?,?)");
            pstm.setString(1, pessoa.getCpf());
            pstm.setString(2, pessoa.getNome());
            pstm.setString(3, pessoa.getSenha());
            pstm.execute();
            System.out.println("Inserido com sucesso");
            conexao.desconectar();
        } catch (SQLException ex) {
            System.out.println("Falha ao inserir no DB: " + ex.getMessage());
        }
    }
    public void remover(String cpf){
        Conexao conexao = new Conexao();
        this.conn = conexao.conectar();
        
        try {
            String remove = "DELETE FROM RESTAURANTE WHERE CPF = ?";
            pstm = conn.prepareStatement(remove);
            pstm.setString(1, cpf);
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
            pstm = conn.prepareStatement("UPDATE AGENDA SET NOME = ? WHERE NOME = ?");
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
    public ResultSet buscarPedidos() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            
            pstm = conn.prepareStatement("SELECT * FROM PEDIDOS ORDER BY CPF");
            
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    public ResultSet buscar() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            
            pstm = conn.prepareStatement("SELECT * FROM RESTAURANTE ORDER BY CPF");
            
            // Executando o comando sql e armazenando no ResultSet
            rs = pstm.executeQuery();
            //Retornando o ResultSet​
             return rs;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
    
    public String buscarPorNome() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        String pedido = ("");
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            Cliente cliente = new Cliente();
            ResultSet rs = cliente.buscar();
            while(rs.next()){
                pedido = pedido + rs.getString("cpf") +" "+ rs.getString("nome")+ " ";
                System.out.println("aaa");
            }
            // Executando o comando sql e armazenando no ResultSet
            
            //Retornando o ResultSet​
             return pedido;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
     public String buscarPorNomee() {
        // Abrindo a conexão com o banco​
        Conexao conexao = new Conexao();
        conn = conexao.conectar();
        String pedido = ("");
        try {
            // Instanciando o objeto preparedStatement (pstmt)​
            Cliente cliente = new Cliente();
            ResultSet rs = cliente.buscarPedidos();
            while(rs.next()){
                Pedido pedir = new Pedido(rs.getInt("xsalada"),rs.getInt("xburger"),rs.getInt("cachorroquente"),rs.getInt("mistoquente"),rs.getInt("saladadefrutas"),rs.getInt("refrigerante"),rs.getInt("suconatural"));
                pedido = pedir +pedido;
                System.out.println("aaa");
            }
            // Executando o comando sql e armazenando no ResultSet
            
            //Retornando o ResultSet​
             return pedido;
        } catch (SQLException e) {
            conexao.desconectar();
            return null;
        }
    }
}
                //Pedido pedido = new Pedido(rs.getInt("xsalada"),rs.getInt("xburger"),rs.getInt("cachorroquente"),rs.getInt("mistoquente"),rs.getInt("saladadefrutas"),rs.getInt("refrigerante"),rs.getInt("suconatural"));
