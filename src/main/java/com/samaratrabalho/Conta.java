package com.samaratrabalho;

public abstract class Conta implements OperacaoBancaria {
    private int numero;
    private double saldo = 0;
    private Agencia agencia;

    public Conta(int num, Agencia agencia){
        this.numero = num; // Atribuição corrigida
        this.agencia = agencia; // Atribuição corrigida
    }

    // Getters e Setters adicionados/corrigidos
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo(){
        return this.saldo; // Corrigido
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
    
    // Métodos da interface
    @Override
    public void depositar(double valor){
        this.saldo = this.saldo + valor;
    }

    @Override
    public int sacar(double valor){ // Corrigido para retornar int
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor;
            return 1; // 1 para sucesso
        }
        return 0; // 0 para falha
    }
}