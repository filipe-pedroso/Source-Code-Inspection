package com.exemplo;

import org.junit.Assert;
import org.junit.Test;
import br.calebe.ticketmachine.core.PapelMoeda; 

/**
 * Test class for PapelMoeda.
 */
public class AppTest {

    @Test
    public void testGetValor() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        Assert.assertEquals("O valor do papel-moeda deve ser 10.", 10, papelMoeda.getValor());
    }

    @Test
    public void testGetQuantidade() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        Assert.assertEquals("A quantidade de papel-moeda deve ser 5.", 5, papelMoeda.getQuantidade());
    }

    @Test
    public void testCriarPapelMoedaComValoresPositivos() {
        PapelMoeda papelMoeda = new PapelMoeda(50, 2);
        Assert.assertEquals("O valor do papel-moeda deve ser 50.", 50, papelMoeda.getValor());
        Assert.assertEquals("A quantidade de papel-moeda deve ser 2.", 2, papelMoeda.getQuantidade());
    }

    @Test
    public void testCriarPapelMoedaComQuantidadeZero() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 0);
        Assert.assertEquals("O valor do papel-moeda deve ser 10.", 10, papelMoeda.getValor());
        Assert.assertEquals("A quantidade de papel-moeda deve ser 0.", 0, papelMoeda.getQuantidade());
    }
    
    @Test
    public void testCriarPapelMoedaComQuantidadeNegativa() {
        PapelMoeda papelMoeda = new PapelMoeda(20, -3);
        Assert.assertEquals("O valor do papel-moeda deve ser 20.", 20, papelMoeda.getValor());
        Assert.assertEquals("A quantidade de papel-moeda deve ser -3.", -3, papelMoeda.getQuantidade());
    }
}
