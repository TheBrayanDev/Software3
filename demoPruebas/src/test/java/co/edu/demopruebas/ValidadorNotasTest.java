package co.edu.demopruebas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorNotasTest {

    @Test
    public void testEsAprobadoConNotaMayorA3() {
        ValidadorNotas validador = new ValidadorNotas();
        assertTrue(validador.esAprobado(3.5));
    }

    @Test
    public void testNoEsAprobadoConNotaMenorA3() {
        ValidadorNotas validador = new ValidadorNotas();
        assertFalse(validador.esAprobado(2.5));
    }

    @Test
    public void testClasificarNotaComoAprobado() {
        ValidadorNotas validador = new ValidadorNotas();
        assertEquals("Aprobado", validador.clasificarNota(3.2));
    }

    @Test
    public void testClasificarNotaComoSobresaliente() {
        ValidadorNotas validador = new ValidadorNotas();
        assertEquals("Sobresaliente", validador.clasificarNota(4.5));
    }

    @Test
    public void testClasificarNotaComoReprobado() {
        ValidadorNotas validador = new ValidadorNotas();
        assertEquals("Reprobado", validador.clasificarNota(2.0));
    }

    @Test
    public void testNotaFueraDeRangoSuperior() {
        ValidadorNotas validador = new ValidadorNotas();
        assertThrows(IllegalArgumentException.class, () -> {
            validador.validarRango(6.0);
        });
    }

    @Test
    public void testNotaFueraDeRangoInferior() {
        ValidadorNotas validador = new ValidadorNotas();
        assertThrows(IllegalArgumentException.class, () -> {
            validador.validarRango(-1.0);
        });
    }

    @Test
    public void testRendimientoBasico() {
        ValidadorNotas validador = new ValidadorNotas();

        for (int i = 0; i < 100000; i++) {
            validador.esAprobado(4.0);
        }

        assertTrue(true);
    }
}