package com.digytal.controlefinanceiro;


import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

import static com.digytal.controlefinanceiro.ContaBancaria.contasCorrente;

public class Cliente {

    private Integer numeroConta;
    private Integer agencia;
    private String nomeCliente;
    private Double saldo;

    private ArrayList<Extrato> registroTransacoes;

    public Cliente(Integer numeroConta, Integer agencia, String nomeCliente) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
        this.registroTransacoes = new ArrayList<Extrato>();

    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void depositar(Cliente conta, Double value) {
        if (value > 0.0) {
            setSaldo(getSaldo() + value);
//            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("\nNão foi possível realizar o depósito." +
                                "Tente novamente!");
        }

        LocalDate dataTransacao = LocalDate.now();
        Extrato registroTransacao = new Extrato(dataTransacao, "Depósito", value);
        this.registroTransacoes.add(registroTransacao);
    }
//
    public void sacar(Double value) {
        if (value > 0.0 && this.getSaldo() > value) {
            setSaldo(getSaldo() - value);
//            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("\nNão foi possível realizar esta transação." +
                                "\nVerifique o saldo da sua conta ou entre em contato com sua Agência!");
        }

        LocalDate dataTransacao = LocalDate.now();
        Extrato registroTransacao = new Extrato(dataTransacao, "Saque", value);
        this.registroTransacoes.add(registroTransacao);
    }

    public void transferir(Cliente contaDestino, Double value) {
        if (value > 0.0 && this.getSaldo() >= value) {
            setSaldo(getSaldo() - value);
            contaDestino.saldo = contaDestino.getSaldo() + value;
            System.out.println("Transferência realizada com sucesso!");
        }

        contaDestino.gerarReciboTransferenciaFavorecido(contaDestino, value);

        LocalDate dataTransacao = LocalDate.now();
        Extrato registroTransacao = new Extrato(dataTransacao, "Transferência entre contas" +
                                                "\npara Conta: " + contaDestino.getNumeroConta() +
                                                " - Ag: " + contaDestino.getAgencia(), value);

        this.registroTransacoes.add(registroTransacao);
    }

    public void gerarReciboTransferenciaFavorecido(Cliente contaDestino, Double value) {
        LocalDate dataTransacao = LocalDate.now();
        Extrato registroTransacao = new Extrato(dataTransacao, "Transferência entre contas" +
                                                "\nde Conta: " + contaDestino.getNumeroConta() +
                                                " - Ag: " + contaDestino.getAgencia(), value);
        this.registroTransacoes.add(registroTransacao);
    }

//
    public void buscarExtratoTransacoes(Cliente clienteConta, LocalDate dataInicial, LocalDate dataFinal) {

        if (dataInicial.isAfter(dataFinal)) {
            System.out.println("Data incial deve ser inferior a data final.");
        }

        if (registroTransacoes.size() > 0) {
            System.out.println("\n-----------------------------------" +
                    "\nExtrato da Conta" +
                    "\nConta: " + clienteConta.getNumeroConta() +
                    " --- Agência: " + clienteConta.getAgencia());

            for (Extrato extrato : this.registroTransacoes) {
                System.out.println("\nData da transação: " + extrato.getData() +
                        "\nValor da transação: " + extrato.getValor() +
                        "\nTipo de transação: " + extrato.getTipoTransacao());
            }
        } else {

            System.out.println("\n-----------------------------------" +
                    "\nExtrato da Conta" +
                    "\nConta: " + clienteConta.getNumeroConta() +
                    " --- Agência: " + clienteConta.getAgencia());
            System.out.println("Não houve transações neste período!");
        }

        System.out.println("\n-----------------------------------" +
                            "\nSaldo atual da conta: " + clienteConta.getSaldo());

    }

}
