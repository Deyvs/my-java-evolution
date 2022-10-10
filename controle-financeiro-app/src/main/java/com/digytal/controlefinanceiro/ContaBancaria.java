package com.digytal.controlefinanceiro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class ContaBancaria {

    static ArrayList<Cliente> contasCorrente;

    public static void main(String[] args) {

        contasCorrente = new ArrayList<Cliente>();

        //Criando contas dos novos CLientes
        novaConta("Luke Skywalker", 1001, 124);
        novaConta("Darth Vader", 1001, 135);
        novaConta("R2 D2", 1002, 124);
        novaConta("Chewbacca", 1002, 121);
        novaConta("Leia Organa", 1003, 135);
        novaConta("Mestre Yoda", 1004, 124);

//        //Método depositar
//        depositar(1002,124, 5500.0);
//        depositar(1001,124, 12500.0);
//        depositar(1004,124, 22000.0);
//        depositar(1001,135, 50000.0);

//        //Método sacar
//        sacar(1002, 121, 1200.0);
//        sacar(1002, 12, 1200.0);
//        sacar(1002, 121, 1200.0);

//        //Método Transferir
//        transferir(1001, 135, 1002, 121, 10000.0);
//        transferir(1002, 121, 1002, 124, 3300.0);
//        transferir(1004, 124, 1003, 135, 2500.0);


        //Consultando extrato de contas
        depositar(1002,121, 5500.0);
        sacar(1002, 121, 1200.0);
        transferir(1002, 124, 1002, 124, 3300.0);

        //Método Consultar Extrato
        consultarExtrato(1002, 121, LocalDate.parse("2022-10-09"), LocalDate.now());
        consultarExtrato(1002, 124, LocalDate.parse("2022-10-09"), LocalDate.now());
//        consultarExtrato(1002, 124, LocalDate.now().minusMonths(1), LocalDate.now());


//        //Buscar clientes(recursos) - indivdual ou pegar todos os clientes
//        buscarClientes();
        buscarCliente(1002, 121);

    }

    public static void novaConta(String nome, Integer numeroConta, Integer agencia) {

        Cliente cliente = new Cliente(numeroConta, agencia, nome);
        contasCorrente.add(cliente);
//        System.out.println("Conta cadastrada com sucesso!");

    }

    public static void buscarClientes() {
        System.out.println("------------------------------------");
       if (contasCorrente.size() > 0) {
           for (Cliente cliente : contasCorrente) {
               System.out.println( "Dados do Cliente: " +
                                    "\nCliente: " + cliente.getNomeCliente() +
                                    "\nNúmero da conta: " + cliente.getNumeroConta() +
                                    "\nNúmero da Agência: " + cliente.getAgencia() +
                                    "\nSaldo da conta: " + cliente.getSaldo());
               System.out.println("------------------------------------");
           }
       }
    }

    public static Cliente buscarCliente(Integer numeroConta, Integer numeroAgencia) {
        Cliente conta = null;

        System.out.println("------------------------------------");
        if (contasCorrente.size() > 0) {
            for (Cliente cliente : contasCorrente) {
                if (Objects.equals(cliente.getNumeroConta(), numeroConta)
                        && Objects.equals(cliente.getAgencia(), numeroAgencia)) {
                    conta = cliente;
                    System.out.println("Dados do Cliente: " +
                                    "\nCliente: " + cliente.getNomeCliente() +
                                    "\nNúmero da conta: " + cliente.getNumeroConta() +
                                    "\nNúmero da Agência: " + cliente.getAgencia() +
                                    "\nSaldo da conta: " + cliente.getSaldo());
                    System.out.println("------------------------------------");
                }
            }
        }

        return conta;
    }

    public static void depositar(Integer contaDestino, Integer agenciaDestino, Double value) {
        Cliente conta = buscarCliente(contaDestino, agenciaDestino);

        if (conta != null) {
            conta.depositar(conta, value);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public static void sacar(Integer contaCliente, Integer agenciaCliente, Double value) {
        Cliente conta = buscarCliente(contaCliente, agenciaCliente);
        if (conta != null) {
            conta.sacar(value);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }
    public static void transferir(Integer contaCliente, Integer agenciaCliente,  Integer contaDestino, Integer agenciaDestino, Double value) {
        Cliente contaRemetente = buscarCliente(contaCliente, agenciaCliente);

        if (contaRemetente != null) {
            Cliente contaDestinatario = buscarCliente(contaDestino, agenciaDestino);
//            contaRemetente.reciboTransferenciaFavorecido(contaRemetente, value);
            if (contaDestinatario != null) {
                contaRemetente.transferir(contaDestinatario, value);

            }
        }
//        assert contaRemetente != null;

    }

    public static void consultarExtrato(Integer contaCliente, Integer agenciaCliente, LocalDate dataInicial, LocalDate dataFinal) {
        Cliente conta = buscarCliente(contaCliente, agenciaCliente);

        if (conta != null) {
            conta.buscarExtratoTransacoes(conta, dataInicial, dataFinal);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }
}
