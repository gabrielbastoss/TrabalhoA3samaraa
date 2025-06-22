package com.samaratrabalho;

public class PessoaFisica extends Pessoa{
    private String cpf;

    // Construtor corrigido para usar o construtor da classe Pessoa
    PessoaFisica(String nome, String cpf){
        super(nome);
        this.cpf = cpf;
    }

    public String getCpf(){
        return this.cpf; // Corrigido o erro de digitação 't'
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
}