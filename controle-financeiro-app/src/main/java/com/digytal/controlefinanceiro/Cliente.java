package com.digytal.controlefinanceiro;


public class Cliente {

    private Integer numeroConta;
    private Integer agencia;
    private String nomeCliente;
    private Double saldo = 0.0;


    public Cliente(Integer numeroConta, Integer agencia, String nomeCliente, Double saldo) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
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

    public String toString() {
        return "\nDados da conta: " +
                "\nCliente: " + this.getNomeCliente() +
                "\nNúmero da conta: " + this.getNumeroConta() +
                "\nAgência: " + this.getAgencia() +
                "\nSaldo: " + this.getSaldo();

    }


    public void depositar(Double value) {
        if (value > 0.0) {
            setSaldo(getSaldo() + value);
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("\nNão foi possível realizar o depósito." +
                                "Tente novamente!");
        }
    }

    public void sacar(Double value) {
        if (value > 0.0 && this.getSaldo() > value) {
            setSaldo(getSaldo() - value);
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("\nNão foi possível realizar esta transação" +
                                "Verifique o saldo da sua conta ou entre em contato com sua Agência!");
        }
    }

    public void transferir(Cliente contaDestino, Cliente agenciaDestino, Double value) {
        if (value > 0.0 && this.getSaldo() >= value) {
            setSaldo(getSaldo() - value);
            contaDestino.saldo = contaDestino.getSaldo() + value;
        }
    }

}
