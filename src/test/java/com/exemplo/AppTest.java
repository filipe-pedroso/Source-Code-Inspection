package br.calebe.ticketmachine.core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test class for PapelMoeda.
 */
public class PapelMoedaTest {

    @Test
    public void testGetValor() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(10, papelMoeda.getValor(), "O valor do papel-moeda deve ser 10.");
    }

    @Test
    public void testGetQuantidade() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(5, papelMoeda.getQuantidade(), "A quantidade de papel-moeda deve ser 5.");
    }

    @Test
    public void testCriarPapelMoedaComValoresPositivos() {
        PapelMoeda papelMoeda = new PapelMoeda(50, 2);
        assertEquals(50, papelMoeda.getValor(), "O valor do papel-moeda deve ser 50.");
        assertEquals(2, papelMoeda.getQuantidade(), "A quantidade de papel-moeda deve ser 2.");
    }

    @Test
    public void testCriarPapelMoedaComQuantidadeZero() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 0);
        assertEquals(10, papelMoeda.getValor(), "O valor do papel-moeda deve ser 10.");
        assertEquals(0, papelMoeda.getQuantidade(), "A quantidade de papel-moeda deve ser 0.");
    }
    
    @Test
    public void testCriarPapelMoedaComQuantidadeNegativa() {
        PapelMoeda papelMoeda = new PapelMoeda(20, -3);
        assertEquals(20, papelMoeda.getValor(), "O valor do papel-moeda deve ser 20.");
        assertEquals(-3, papelMoeda.getQuantidade(), "A quantidade de papel-moeda deve ser -3.");
    }
}
