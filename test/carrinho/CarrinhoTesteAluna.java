// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package carrinho;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import produto.Produto;
import produto.ProdutoNaoEncontradoException;

@DisplayName("Classe da aluna para testes da classe carrinho")
public class CarrinhoTesteAluna {
  private Carrinho car;
  private Produto produto1;
  private Produto produto2;
  private Produto produto3;

  @BeforeEach
  public void instanciando() {
    car = new Carrinho();

    produto1 = new Produto(nome: "estojo", 30.00);
    produto2 = new Produto(nome: "caderno", preco: 20.00);
    produto3 = new Produto(nome: "agenda", 50.00);
  }
   
  @DisplayName("Testa a adição de itens e o cálculo do valor total")
  @Test
  public void testeAddItemEGetValorTotal() {
    car.addItem(produto1);
    assertEquals(50.0, car.getValorTotal(), 0.001, "Valor total deve ser 50.0");

    car.addItem(produto2);
    assertEquals(150.0, car.getValorTotal(), 0.001, "Valor total deve ser 150.0");
         
    car.addItem(produto3);
    assertEquals(160.0, car.getValorTotal(), 0.001, "Valor total deve ser 160.0");
  }

  @DisplayName("Testa a adição de itens e o cálculo da qtd total")
  @Test
  public void testeAddItemEGetQtd() {
    car.addItem(produto1);
    assertEquals(1, car.getQtdeItems(), "Deve ter apenas 1 item");

    car.addItem(produto2);
    assertEquals(2, car.getQtdeItems(), "Deve ter 2 itens");
         
    car.addItem(produto3);
    assertEquals(3, car.getQtdeItems(), "Deve ter 3 itens");
  }

  @DisplayName("Testa a remoção de 1 item")
  @Test
  public void testeRemoveItem() {
    car.addItem(produto1);
    car.addItem(produto2);
    assertEquals(2, car.getQtdeItems());

    car.removeItem(produto1);
        
    assertEquals(1, car.getQtdeItems(), "Quantidade deve ser 1 após remover p1.");
    assertEquals(100.0, car.getValorTotal(), 0.001, "Valor total deve ser o de p2 (100.0).");
  }

  @DisplayName("Testa o esvaziamento do carrinho")
  @Test
  public void testeEsvazia() {
    car.addItem(produto1);
    car.addItem(produto2);
    car.addItem(produto3);

    car.esvazia();
        
    assertEquals(0, car.getQtdeItems(), "Carrinho deve ter 0 itens após esvaziar");
    assertEquals(0.0, car.getValorTotal(), 0.001, "Carrinho deve ter valor 0.0 após esvaziar");
    }





}