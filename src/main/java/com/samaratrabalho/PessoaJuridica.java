package com.samaratrabalho;

// A importação de ArrayList não é mais necessária aqui, pois a classe não a manipula diretamente.

public class PessoaJuridica extends Pessoa {
    // 1. O tipo de dado foi melhorado para String.
    private String cnpj;

    /**
     * Construtor corrigido.
     * 2. Não recebe mais a lista de contas.
     * 3. Chama o construtor super(nome) da classe Pessoa, que cria a lista de contas interna.
     * @param nome O nome da pessoa jurídica.
     * @param cnpj O CNPJ da pessoa jurídica.
     */
    public PessoaJuridica(String nome, String cnpj) {
        super(nome); // Chama o construtor da classe mãe
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return this.cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}