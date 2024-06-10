/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

/**
 *
 * @author unielqualharello
 */
public class Pessoa {
    String nome;
    String cpf;
    String senha;
    
    public Pessoa(String cpf, String nome, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public Pessoa(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
    }
    
    public Pessoa(String cpf) {
        this.cpf = cpf;
    }
    

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", cpf=" + cpf + ", senha=" + senha + '}';
    }
    
}
