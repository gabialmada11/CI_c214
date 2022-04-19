package br.inatel.c214.compras;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteCarrinhoCompra {

    // Teste inicial básico (Padrão 1)
    @Test
    public void testSomaTotalCompra() throws NumeroNegativoException {

        Roupa rp1 = new Roupa("Camiseta", 2, 50);
        Roupa rp2 = new Roupa("Bermuda", 1, 30);

        CarrinhoCompra carrinho = new CarrinhoCompra();

        carrinho.adiciona(rp1);
        carrinho.adiciona(rp2);

        assertEquals(80, carrinho.somaTotal(),0.01);

    }


    // Teste inicial básico (Padrão 1) + algo diferente (teste valor total de itens) (Padrão 2)
    @Test
    public void testSomaTotalQtd() throws NumeroNegativoException {

        Roupa rp1 = new Roupa("Camiseta", 2, 50);
        Roupa rp2 = new Roupa("Bermuda", 1, 30);

        CarrinhoCompra carrinho = new CarrinhoCompra();

        carrinho.adiciona(rp1);
        carrinho.adiciona(rp2);

        assertEquals(3, carrinho.somaTotalItens(),0.01);


    }

    // Teste negativo (Padrão 3) forçando uma situação inesperada
    @Test(expected = NumeroNegativoException.class)
    public void testSomaNegativo() throws NumeroNegativoException {

        Roupa rp1 = new Roupa("Camiseta", -2, 50);
        Roupa rp2 = new Roupa("Bermuda", -1, 30);

        CarrinhoCompra carrinho = new CarrinhoCompra();

        carrinho.adiciona(rp1);
        carrinho.adiciona(rp2);

    }

    // Teste integração (Padrão 4) 2 classes (Carrinho e Cupom sendo testadas juntas).
    @Test
    public void testIntegracaoCupom() throws NumeroNegativoException {

        Roupa rp1 = new Roupa("Camiseta", 2, 50);
        Roupa rp2 = new Roupa("Bermuda", 1, 30);

        CarrinhoCompra carrinho = new CarrinhoCompra();
        CupomDesconto cupom = new CupomDesconto(0.20);
        carrinho.setCupom(cupom);

        carrinho.adiciona(rp1);
        carrinho.adiciona(rp2);
        carrinho.somaTotal();

        assertEquals(64, carrinho.somaTotal(), 0.1);

    }
}
