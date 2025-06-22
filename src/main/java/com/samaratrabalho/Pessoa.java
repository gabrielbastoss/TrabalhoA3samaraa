package com.samaratrabalho;
import java.util.ArrayList;

public abstract class Pessoa {
    private String nome;
    private ArrayList<Conta> listacontas;

    public Pessoa(String nome){ // Construtor corrigido para não exigir a lista
        this.nome = nome;
        this.listacontas = new ArrayList<>(); // A lista é criada aqui
    }

    // Getters e Setters para 'nome'
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter para a lista de contas
    public ArrayList<Conta> getListaContas(){
        return this.listacontas;
    }

    // Método para adicionar conta (corrigindo o antigo 'setListaContas')
    public void adicionarConta(Conta conta){
        this.listacontas.add(conta);
    }
}