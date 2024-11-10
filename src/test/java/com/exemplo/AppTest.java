package com.exemplo;

import org.junit.Assert;
import org.junit.Test;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;

public class AppTest {

    @Test(expected = SaldoInsuficienteException.class)
    public void testEmitirTicketComSaldoExato() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(17);
        machine.inserir(7);
        machine.inserir(10);
        Assert.assertEquals(17, machine.getSaldo());
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testInserirDinheiroMultiplasVezes() throws PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(15);
        machine.inserir(5);
        machine.inserir(10);
        Assert.assertEquals(15, machine.getSaldo());
    }
}
