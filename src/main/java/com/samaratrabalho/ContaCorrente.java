package com.samaratrabalho;

public class ContaCorrente extends Conta{
    private double salario;

    public ContaCorrente(int numero, double salario, Agencia agencia){
        super(numero, agencia);
        this.salario = salario;
    }

    @Override
    public void imprimir() {
        System.out.println("Seu salário é : "+this.salario);
    }

    public double getSalario(){
        return this.salario;
    }

    // Corrigido o tipo do parâmetro de int para double
    public void setSalario(double salario){
        this.salario = salario;
    }
}