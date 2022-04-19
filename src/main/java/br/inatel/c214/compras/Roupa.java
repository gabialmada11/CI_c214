package br.inatel.c214.compras;

public class Roupa {

    private String nome;
    private int qnt;
    private double valor;

    public Roupa(String nome, int qnt, double valor) {
        this.nome = nome;
        this.qnt = qnt;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
    public int getQnt() {
        return qnt;
    }
    public double getValor() {
        return valor;
    }
}
