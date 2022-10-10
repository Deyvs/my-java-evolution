package com.digytal.controlefinanceiro;

import java.time.LocalDate;

public class Extrato {

    private LocalDate data;
    private String tipoTransacao;
    private Double valor;

    public Extrato(LocalDate data, String tipoTransacao, Double valor) {
        this.data = data;
        this.tipoTransacao = tipoTransacao;
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public String getTipoTransacao() {
        return tipoTransacao;
    }

    public Double getValor() {
        return valor;
    }

}
