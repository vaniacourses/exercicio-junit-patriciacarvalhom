package calculadora;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTesteGPT {
     private final Calculadora calc = new Calculadora();

    @Test
    public void testSoma() {
        assertEquals(5, calc.soma(2, 3));
        assertEquals(0, calc.soma(0, 0));
        assertEquals(-1, calc.soma(-2, 1));
        assertEquals(-5, calc.soma(-2, -3));
        assertEquals(Integer.MAX_VALUE, calc.soma(Integer.MAX_VALUE, 0));
        assertEquals(-1, calc.soma(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

    @Test
    public void testSubtracao() {
        assertEquals(-1, calc.subtracao(2, 3));
        assertEquals(0, calc.subtracao(0, 0));
        assertEquals(-3, calc.subtracao(-2, 1));
        assertEquals(1, calc.subtracao(-2, -3));
        assertEquals(Integer.MAX_VALUE, calc.subtracao(Integer.MAX_VALUE, 0));
        assertEquals(1, calc.subtracao(Integer.MAX_VALUE, Integer.MAX_VALUE - 1));
    }

    @Test
    public void testMultiplicacao() {
        assertEquals(6, calc.multiplicacao(2, 3));
        assertEquals(0, calc.multiplicacao(0, 3));
        assertEquals(-2, calc.multiplicacao(-2, 1));
        assertEquals(6, calc.multiplicacao(-2, -3));
        assertEquals(0, calc.multiplicacao(0, 0));
        assertEquals(Integer.MIN_VALUE, calc.multiplicacao(Integer.MIN_VALUE, 1));
    }

    @Test
    public void testDivisao() {
        assertEquals(2, calc.divisao(6, 3));
        assertEquals(0, calc.divisao(0, 1));
        assertEquals(-2, calc.divisao(-6, 3));
        assertEquals(1, calc.divisao(3, 2)); // divisão inteira

        // Teste divisão por zero
        assertThrows(ArithmeticException.class, () -> calc.divisao(5, 0));
    }

    @Test
    public void testSomatoria() {
        assertEquals(10, calc.somatoria(4)); // 4+3+2+1+0 = 10
        assertEquals(0, calc.somatoria(0));
        assertEquals(0, calc.somatoria(-1)); // borda
        assertEquals(1, calc.somatoria(1)); // 1+0
        assertEquals(55, calc.somatoria(10));
    }

    @Test
    public void testEhPositivo() {
        assertTrue(calc.ehPositivo(0));
        assertTrue(calc.ehPositivo(5));
        assertFalse(calc.ehPositivo(-1));
        assertFalse(calc.ehPositivo(-100));
        assertTrue(calc.ehPositivo(Integer.MAX_VALUE));
        assertFalse(calc.ehPositivo(Integer.MIN_VALUE));
    }

    @Test
    public void testCompara() {
        assertEquals(0, calc.compara(5, 5)); // igual
        assertEquals(-1, calc.compara(3, 4)); // menor
        assertEquals(1, calc.compara(5, 4)); // maior
        assertEquals(0, calc.compara(0, 0));
        assertEquals(-1, calc.compara(Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(1, calc.compara(Integer.MAX_VALUE, Integer.MIN_VALUE));
    }

}
