package com.exemplo;

import org.junit.Assert;
import org.junit.Test;
import br.calebe.ticketmachine.core.PapelMoeda; 
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.core.TicketMachine;

public class AppTest {

    @Test(expected = SaldoInsuficienteException.class)
    public void testEmitirTicketComSaldoExato() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(10);
        machine.inserir(10);
        String recibo = machine.imprimir();
        Assert.assertEquals("*****************\n*** R$ 10,00 ****\n*****************\n", recibo);
    }

    // Teste: Inserir dinheiro múltiplas vezes e checar saldo
    @Test(expected = SaldoInsuficienteException.class)
    public void testInserirDinheiroMultiplasVezes() throws PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(15);
        machine.inserir(5);
        machine.inserir(10);
        Assert.assertEquals(15, machine.getSaldo()); // O saldo deve refletir a soma das quantias inseridas
    }

    // Teste: Inserir valor inválido e verificar exceção
    @Test(expected = SaldoInsuficienteException.class)
    public void testInserirValorInvalido() throws PapelMoedaInvalidaException {
        TicketMachine machine = new TicketMachine(20);
        machine.inserir(3); // Valor inválido, pois não é um valor de papel-moeda aceito
    }

    // Teste: Saldo insuficiente após tentativa de emissão
    @Test(expected = SaldoInsuficienteException.class)
    public void testSaldoNaoAlteradoAposFalhaImpressao() {
        try {
            TicketMachine machine = new TicketMachine(20);
            machine.inserir(10);
            machine.imprimir(); // Deve lançar SaldoInsuficienteException
        } catch (SaldoInsuficienteException | PapelMoedaInvalidaException e) {
            // Captura a exceção e verifica se o saldo permanece o mesmo
            Assert.assertEquals(10, machine.getSaldo());
        }
    }
}
