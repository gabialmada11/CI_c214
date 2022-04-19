package br.inatel.c214.compras;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompra {

    private List<Roupa> roupas;
    private CupomDesconto cupom;

    public CarrinhoCompra() {
        roupas = new ArrayList<Roupa>();
    }

    public void adiciona(Roupa rp) throws NumeroNegativoException {

        if(rp.getQnt() > 0){
            roupas.add(rp);
        }else{
            throw new NumeroNegativoException("Não é possivel adicionar uma quantidade negativa");
        }

    }

    public double somaTotal() {
        double total = 0;
        for (Roupa roupa : roupas) {
            total += roupa.getValor();
        }

        if(cupom != null && cupom.getDesconto() > 0){
            return somaTotalComDesconto(total, cupom.getDesconto());
        }else{
            return total;
        }
    }

    private double somaTotalComDesconto(double total, double desconto){
        return total = total - (total*desconto);
    }

    public double somaTotalItens() {
        double total = 0;
        for (Roupa roupa : roupas) {

            total += roupa.getQnt();
        }
        return total;
    }

    public CupomDesconto getCupom() {
        return cupom;
    }

    public void setCupom(CupomDesconto cupom) {
        this.cupom = cupom;
    }

}
