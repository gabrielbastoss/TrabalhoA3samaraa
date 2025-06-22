package com.samaratrabalho;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Aula {

    // Constantes para evitar "números mágicos"
    private static final int OPCAO_PESSOA_JURIDICA = 1;
    private static final int OPCAO_PESSOA_FISICA = 2;
    private static final int OPCAO_SIM = 1;

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("--- Sistema de Controle Bancário ---");

        Agencia agenciaEscolhida = selecionarAgencia(entrada);
        Pessoa cliente = cadastrarCliente(entrada);

        if (cliente != null) {
            // A agência agora é passada diretamente para o método de criação de contas
            criarContasParaCliente(entrada, cliente, agenciaEscolhida);
            
            System.out.println("\n--- Cadastro Finalizado ---");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("Contas criadas:");
            for (Conta conta : cliente.getListaContas()) {
                System.out.println("- Conta N. " + conta.getNumero() + 
                                   " | Agência: " + conta.getAgencia().getNumero() + 
                                   " | Saldo: R$" + conta.getSaldo());
            }
        }
        
        entrada.close();
    }

    private static Agencia selecionarAgencia(Scanner entrada) {
        System.out.println("\nAgências disponíveis: 1, 2 e 3");
        int numAgencia = 0;
        
        while (numAgencia < 1 || numAgencia > 3) {
            System.out.print("Informe a agência que você deseja: ");
            try {
                numAgencia = entrada.nextInt();
                if (numAgencia < 1 || numAgencia > 3) {
                    System.out.println("Opção inválida. Por favor, escolha 1, 2 ou 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                entrada.next(); // Limpa o buffer do scanner
            }
        }
        return new Agencia(numAgencia);
    }

    private static Pessoa cadastrarCliente(Scanner entrada) {
        System.out.println("A conta é para: \n 1: Pessoa Jurídica \n 2: Pessoa Física");
        System.out.print("Digite a opção: ");
        int opcao = entrada.nextInt();
        entrada.nextLine(); // <-- Adicionado para consumir o "Enter" pendente

        System.out.print("\nInforme o nome completo da Pessoa: ");
        String nome = entrada.nextLine(); // Corrigido para ler nome completo

        switch (opcao) {
            case OPCAO_PESSOA_JURIDICA:
                System.out.print("Informe o CNPJ: ");
                String cnpj = entrada.next(); // CORRIGIDO: Lê CNPJ como String
                return new PessoaJuridica(nome, cnpj);

            case OPCAO_PESSOA_FISICA:
                System.out.print("Informe o CPF: ");
                String cpf = entrada.nextLine(); // Mantido como int conforme o arquivo PessoaFisica.java
                return new PessoaFisica(nome, cpf);

            default:
                System.out.println("Opção inválida. Cadastro cancelado.");
                return null;
        }
    }

    // CORRIGIDO: O método agora recebe a agência como parâmetro
    private static void criarContasParaCliente(Scanner entrada, Pessoa cliente, Agencia agencia) {
        Random random = new Random();

        System.out.print("\nDeseja criar conta corrente? (1-Sim / 2-Não): ");
        if (entrada.nextInt() == OPCAO_SIM) {
            System.out.print("Informe o salário: ");
            double salario = entrada.nextDouble();
            int numConta = 10000 + random.nextInt(90000);
            
            // CORRIGIDO: Usa a 'agencia' recebida como parâmetro
            ContaCorrente cc = new ContaCorrente(numConta, salario, agencia);
            cliente.adicionarConta(cc);
            System.out.println(">> Conta Corrente criada! Número: " + cc.getNumero());
        }

        System.out.print("Deseja criar conta poupança? (1-Sim / 2-Não): ");
        if (entrada.nextInt() == OPCAO_SIM) {
            System.out.print("Informe o rendimento (%): ");
            double rendimento = entrada.nextDouble();
            int numConta = 10000 + random.nextInt(90000);
            
            // CORRIGIDO: Usa a 'agencia' recebida como parâmetro
            ContaPoupanca cp = new ContaPoupanca(numConta, rendimento, agencia);
            cliente.adicionarConta(cp);
            System.out.println(">> Conta Poupança criada! Número: " + cp.getNumero());
        }
    }
}