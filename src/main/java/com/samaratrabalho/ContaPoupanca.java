package com.samaratrabalho;

public class ContaPoupanca extends Conta{
    private double rendimento;

    public ContaPoupanca(int numero, double rendimento, Agencia agencia){
        super(numero, agencia);
        this.rendimento = rendimento;
    }

    @Override
    public void imprimir() {
        System.out.println("Conta Poupança | Rendimento: "+this.rendimento + "%");
    }

    public double getRendimento(){
        return this.rendimento;
    }

    public void setRendimento(double rendimento){
        this.rendimento = rendimento;
    }
}