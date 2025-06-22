package com.samaratrabalho;

/**
 *
 * @author samara
 */
public interface OperacaoBancaria {
    /**
     * Define o contrato para o método de depósito.
     * @param valor A quantia a ser depositada.
     */
    public void depositar(double valor);

    /**
     * Define o contrato para o método de saque.
     * Exige um retorno int, que pode ser usado como um código de status 
     * (ex: 1 para sucesso, 0 para falha).
     * @param valor A quantia a ser sacada.
     * @return um código de status inteiro.
     */
    public int sacar(double valor);
    
    /**
     * Define o contrato para um método de impressão,
     * usado para exibir os detalhes da conta.
     */
    public void imprimir();   
}