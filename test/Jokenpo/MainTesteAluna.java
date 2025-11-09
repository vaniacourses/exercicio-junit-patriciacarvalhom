package Jokenpo;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste do Jokenpo")
public class MainTesteAluna {
    private Main jokenpo;

    @BeforeEach
    public void instanciando(){
        jokenpo = new Main();
    }
    
    @DisplayName("Testando empates")
    @Test
    void testeEmpates() {
        assertEquals(0, jokenpo.jogar(1, 1), "Papel x Papel é empate");
        assertEquals(0, jokenpo.jogar(2, 2), "Pedra x Pedra é ser empate");
        assertEquals(0, jokenpo.jogar(3, 3), "Tesoura x Tesoura é empate");
    }

    @DisplayName("Testando a vitória do jogador 1")
    @Test
    void testeJogador1Vence() {
        
        assertEquals(1, jokenpo.jogar(1, 2), "Jogador 1 (Papel) vence Jogador 2 (Pedra)");
        assertEquals(1, jokenpo.jogar(2, 3), "Jogador 1 (Pedra) vence Jogador 2 (Tesoura)");
        assertEquals(1, jokenpo.jogar(3, 1), "Jogador 1 (Tesoura) vence Jogador 2 (Papel)");
    }

    @DisplayName("Testando a vitória do jogador 2")
    @Test
    void testeJogador2Vence() {

        assertEquals(2, jokenpo.jogar(2, 1), "Jogador 2 (Papel) vence Jogador 1 (Pedra)");
        assertEquals(2, jokenpo.jogar(3, 2), "Jogador 2 (Pedra) vence Jogador 1 (Tesoura)");
        assertEquals(2, jokenpo.jogar(1, 3), "Jogador 2 (Tesoura) vence Jogador 1 (Papel)");
    }



}
