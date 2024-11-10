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
        PapelMoeda papelMoeda = new PapelMoeda(15, 7);
        Assert.assertEquals("O valor do papel-moeda deve ser 15.", 15, papelMoeda.getValor());
    }

    @Test
    public void testGetQuantidade() {
        PapelMoeda papelMoeda = new PapelMoeda(15, 7);
        Assert.assertEquals("A quantidade de papel-moeda deve ser 7.", 7, papelMoeda.getQuantidade());
    }

    @Test
    public void testCriarPapelMoedaComValoresPositivos() {
        PapelMoeda papelMoeda = new PapelMoeda(100, 4);
        Assert.assertEquals("O valor do papel-moeda deve ser 100.", 100, papelMoeda.getValor());
        Assert.assertEquals("A quantidade de papel-moeda deve ser 4.", 4, papelMoeda.getQuantidade());
    }

    @Test
    public void testCriarPapelMoedaComQuantidadeZero() {
        PapelMoeda papelMoeda = new PapelMoeda(50, 0);
        Assert.assertEquals("O valor do papel-moeda deve ser 50.", 50, papelMoeda.getValor());
        Assert.assertEquals("A quantidade de papel-moeda deve ser 0.", 0, papelMoeda.getQuantidade());
    }
    
    @Test
    public void testCriarPapelMoedaComQuantidadeNegativa() {
        PapelMoeda papelMoeda = new PapelMoeda(30, -5);
        Assert.assertEquals("O valor do papel-moeda deve ser 30.", 30, papelMoeda.getValor());
        Assert.assertEquals("A quantidade de papel-moeda deve ser -5.", -5, papelMoeda.getQuantidade());
    }
}
