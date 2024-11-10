package com.exemplo;

import org.junit.Assert;
import org.junit.Test;
import br.calebe.ticketmachine.core.TicketMachine;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;

public class AppTest {

    @Test(expected = SaldoInsuficienteException.class)
    public void testEmitirTicketComSaldoExato() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(10);
        machine.inserir(10);
        String recibo = machine.imprimir();
        Assert.assertEquals("*****************\n*** R$ 10,00 ****\n*****************\n", recibo);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testInserirDinheiroMultiplasVezes() throws PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(15);
        machine.inserir(5);
        machine.inserir(10);
        Assert.assertEquals(15, machine.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirValorInvalido() throws PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(20);
        machine.inserir(3); // Valor inválido
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testSaldoNaoAlteradoAposFalhaImpressao() {
        TicketMachine machine = new TicketMachine(20); // Declara a variável fora do bloco try
        try {
            machine.inserir(10);
            machine.imprimir(); // Deve lançar SaldoInsuficienteException
        } catch (SaldoInsuficienteException | PapelMoedaInvalidaException e) {
            // Verifica se o saldo permanece o mesmo
            Assert.assertEquals(10, machine.getSaldo());
        }
    }
}
