package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Classe para testes da calculadora da aluna")
public class CalculadoraTesteAluna {
    private Calculadora calc;

    @BeforeEach
    public void instanciando() {
        calc = new Calculadora();
    }

    @DisplayName("Testa a subtração")
    @Test
    void testeSubtracao() {
        assertEquals(-1, calc.subtracao(2, 3));
    }

    @DisplayName("Testa a multiplicação")
    @Test
    void testeMultiplicacao() {
        assertEquals(6, calc.multiplicacao(2, 3));
    }

    @DisplayName("Testa a divisão")
    @Test
    void testeDivisao() {
        assertEquals(2, calc.divisao(6, 3));
    }

    @DisplayName("Testa se número é positivo")
    @Test
    void testeEhPositivo_verdadeiro() {
        assertTrue(calc.ehPositivo(5));
    }

    @DisplayName("Testa compara: A é maior que B")
    @Test
    void testeComparaMaior() {
        assertEquals(1, calc.compara(5, 3));
    }

    @DisplayName("Testa compara: A é menor que B")
    @Test
    void testeComparaMenor() {
        assertEquals(-1, calc.compara(3, 5));
    }

    @DisplayName("Testa compara: A e B são iguais")
    @Test
    void testeComparaIgual() {
        assertEquals(0, calc.compara(5, 5));
    }
}
