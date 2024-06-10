/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection conn;
    
    public Connection conectar() {
        try {
            // Informando qual driver de conexão será utilizado pelo DriveManager​
            Class.forName("org.postgresql.Driver");
            // Criando a conexão com o BD
            String url = "jdbc:postgresql://localhost:5432/postgres";
            String  username  =  "postgres";
            String  password  = "leo";
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado com Sucesso");
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar: "+e.getMessage());
            return null;
        }
    }
    
    public void desconectar() {
        try {
            if (conn != null && !conn.isClosed()) {
                // Desconectando do BD
                conn.close();
            }
        } catch (SQLException e) {
        }
    }
}