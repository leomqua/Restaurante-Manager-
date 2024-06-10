/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package restaurante;

/**
 *
 * @author unielqualharello
 */
public class Pedido {
    String cpf;
    int xsalada;
    int xburger;
    int cachorroquente;
    int mistoquente;
    int saladadefrutas;
    int refrigerante;
    int suconatural;
    double getConta;

    public Pedido(String cpf, int xsalada, int xburger, int cachorroquente, int mistoquente, int saladadefrutas, int refrigerante, int suconatural) {
        this.cpf = cpf;
        this.xsalada = xsalada;
        this.xburger = xburger;
        this.cachorroquente = cachorroquente;
        this.mistoquente = mistoquente;
        this.saladadefrutas = saladadefrutas;
        this.refrigerante = refrigerante;
        this.suconatural = suconatural;
    }

    public Pedido(int xsalada, int xburger, int cachorroquente, int mistoquente, int saladadefrutas, int refrigerante, int suconatural) {
        this.xsalada = xsalada;
        this.xburger = xburger;
        this.cachorroquente = cachorroquente;
        this.mistoquente = mistoquente;
        this.saladadefrutas = saladadefrutas;
        this.refrigerante = refrigerante;
        this.suconatural = suconatural;
    }
    

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getXsalada() {
        return xsalada;
    }

    public void setXsalada(int xsalada) {
        this.xsalada = xsalada;
    }

    public int getXburger() {
        return xburger;
    }

    public void setXburger(int xburger) {
        this.xburger = xburger;
    }

    public int getCachorroquente() {
        return cachorroquente;
    }

    public void setCachorroquente(int cachorroquente) {
        this.cachorroquente = cachorroquente;
    }

    public int getMistoquente() {
        return mistoquente;
    }

    public void setMistoquente(int mistoquente) {
        this.mistoquente = mistoquente;
    }

    public int getSaladadefrutas() {
        return saladadefrutas;
    }

    public void setSaladadefrutas(int saladadefrutas) {
        this.saladadefrutas = saladadefrutas;
    }

    public int getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(int refrigerante) {
        this.refrigerante = refrigerante;
    }

    public int getSuconatural() {
        return suconatural;
    }

    public void setSuconatural(int suconatural) {
        this.suconatural = suconatural;
    }
    
    public double getConta(){
        double soma = 10*xsalada + 10*xburger + 7.5*cachorroquente + 8*mistoquente + 5.5*saladadefrutas + 4.5*refrigerante + 6.25*suconatural;
        return soma;
    }
    
    @Override
    public String toString() {
        return "Pedido = xsalada=" + xsalada + ", xburger=" + xburger + ", cachorroquente=" + cachorroquente + ", mistoquente=" + mistoquente + ", saladadefrutas=" + saladadefrutas + ", refrigerante=" + refrigerante + ", suconatural=" + suconatural ;
    }

    
}