package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import produto.Produto;
import produto.ProdutoNaoEncontradoException;

public class CarrinhoTesteGPT {
    @Test
    public void testCarrinhoVazio() {
        Carrinho c = new Carrinho();
        assertEquals(0.0, c.getValorTotal());
        assertEquals(0, c.getQtdeItems());
    }

    @Test
    public void testAdicionaItem() {
        Carrinho c = new Carrinho();
        Produto p1 = new Produto("Arroz", 10.0);
        c.addItem(p1);
        assertEquals(1, c.getQtdeItems());
        assertEquals(10.0, c.getValorTotal());
    }

    @Test
    public void testAdicionaVariosItens() {
        Carrinho c = new Carrinho();
        Produto p1 = new Produto("Arroz", 10.0);
        Produto p2 = new Produto("Feijão", 15.5);
        Produto p3 = new Produto("Sal", 0.0);
        c.addItem(p1);
        c.addItem(p2);
        c.addItem(p3);
        assertEquals(3, c.getQtdeItems());
        assertEquals(25.5, c.getValorTotal());
    }

    @Test
    public void testRemoveItemExistente() throws ProdutoNaoEncontradoException {
        Carrinho c = new Carrinho();
        Produto p1 = new Produto("Arroz", 10.0);
        c.addItem(p1);
        c.removeItem(p1);
        assertEquals(0, c.getQtdeItems());
        assertEquals(0.0, c.getValorTotal());
    }

    @Test
    public void testRemoveItemNaoExistente() {
        Carrinho c = new Carrinho();
        Produto p1 = new Produto("Arroz", 10.0);
        Produto p2 = new Produto("Feijão", 15.5);
        c.addItem(p1);
        assertThrows(ProdutoNaoEncontradoException.class, () -> c.removeItem(p2));
        assertEquals(1, c.getQtdeItems());
        assertEquals(10.0, c.getValorTotal());
    }

    @Test
    public void testEsvaziaCarrinho() {
        Carrinho c = new Carrinho();
        Produto p1 = new Produto("Arroz", 10.0);
        Produto p2 = new Produto("Feijão", 15.5);
        c.addItem(p1);
        c.addItem(p2);
        c.esvazia();
        assertEquals(0, c.getQtdeItems());
        assertEquals(0.0, c.getValorTotal());
    }

    @Test
    public void testValorTotalPrecision() {
        Carrinho c = new Carrinho();
        Produto p1 = new Produto("Arroz", 0.09999);
        Produto p2 = new Produto("Feijão", 10000.0);
        c.addItem(p1);
        c.addItem(p2);
        assertEquals(10000.09999, c.getValorTotal(), 0.00001);
    }

    @Test
    public void testRemovePorEqualsPersonalizado() throws ProdutoNaoEncontradoException {
        Carrinho c = new Carrinho();
        Produto original = new Produto("Arroz", 10.0);
        Produto igual = new Produto("Arroz", 99.99); // nomes iguais, mesmo equals
        c.addItem(original);
        c.removeItem(igual); // deve remover pelo equals customizado
        assertEquals(0, c.getQtdeItems());
        assertEquals(0.0, c.getValorTotal());
    }
}


