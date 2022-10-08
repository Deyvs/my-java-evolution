package com.digytal.controlefinanceiro;

import java.util.ArrayList;
import java.util.Objects;

public class ContaBancaria {

    static ArrayList<Cliente> contasCorrente;

    public static void main(String[] args) {

        contasCorrente = new ArrayList<Cliente>();

        novaConta("Luke Skywalker", 1001, 124, 12800.0);
        novaConta("Darth Vader", 1001, 135, 25200.0);
        novaConta("R2 D2", 1002, 124, 1800.0);
        novaConta("Chewbacca", 1002, 121, 4500.0);
        novaConta("Leia Organa", 1003, 135, 14600.0);
        novaConta("Mestre Yoda", 1004, 124, 22500.0);

//        buscarClientes();
        System.out.println(buscarCliente(1002, 124));
    }


    public static void novaConta(String nome, Integer numeroConta, Integer agencia, Double value) {

        Cliente cliente = new Cliente(numeroConta, agencia, nome, value);
        contasCorrente.add(cliente);
        System.out.println("Conta cadastrada com sucesso!");

    }

    public static void buscarClientes(int i) {
       if (contasCorrente.size() > 0) {
           for (Cliente cliente : contasCorrente) {
               System.out.println("\nCliente: " + cliente.getNomeCliente() +
                                  "\nNúmero da conta: " + cliente.getNumeroConta() +
                                  "\nNúmero da Agência: " + cliente.getAgencia());
           }
       }
    }

    public static Cliente buscarCliente(Integer numeroConta, Integer numeroAgencia) {
        Cliente conta = null;
        if (contasCorrente.size() > 0) {
            for (Cliente cliente : contasCorrente) {
                if (Objects.equals(cliente.getNumeroConta(), numeroConta)
                        && Objects.equals(cliente.getAgencia(), numeroAgencia)) {
                    conta = cliente;
                }
            }
        }

        return conta;
    }

    public static void depositar(Integer contaDestino, Integer agenciaDestino, Double value) {
        Cliente conta = buscarCliente(contaDestino, agenciaDestino);

    }

}
