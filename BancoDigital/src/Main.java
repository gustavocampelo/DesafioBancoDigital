// Main.java
public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("João", "12345678900");
        Cliente cliente2 = new Cliente("Maria", "98765432100");

        ContaCorrente conta1 = new ContaCorrente("001", 1000, 5);
        ContaPoupanca conta2 = new ContaPoupanca("002", 500, 200);

        banco.adicionarCliente(cliente1);
        banco.adicionarCliente(cliente2);
        banco.adicionarConta(conta1);
        banco.adicionarConta(conta2);

        // Testes básicos de depósito, saque e transferência
        conta1.depositar(500);
        conta2.sacar(100);
        conta1.transferir(conta2, 200);

        // Exibir saldos após os testes básicos
        System.out.println("Saldo da conta1 após depósito: " + conta1.getSaldo());
        System.out.println("Saldo da conta2 após saque e transferência: " + conta2.getSaldo());

        // Adicionar quebra de linha
        System.out.println();

        // Testes adicionais
        // Tentativa de transferência para uma conta inexistente
        boolean transferenciaContaInexistente = conta1.transferir(null, 300);
        System.out.println("Transferência para conta inexistente: " + (transferenciaContaInexistente ? "Efetuada" : "Não efetuada"));

        // Tentativa de saque de valor negativo
        boolean saqueValorNegativo = conta1.sacar(-100);
        System.out.println("Saque de valor negativo: " + (saqueValorNegativo ? "Efetuado" : "Não efetuado"));

        // Tentativa de transferência de valor negativo
        boolean transferenciaValorNegativo = conta1.transferir(conta2, -200);
        System.out.println("Transferência de valor negativo: " + (transferenciaValorNegativo ? "Efetuada" : "Não efetuada"));

        // Tentativa de transferência com saldo insuficiente
        boolean transferenciaSaldoInsuficiente = conta1.transferir(conta2, 10000);
        System.out.println("Transferência com saldo insuficiente: " + (transferenciaSaldoInsuficiente ? "Efetuada" : "Não efetuada"));

        // Teste de transferência bem-sucedida
        boolean transferenciaBemSucedida = conta1.transferir(conta2, 300);
        System.out.println("Transferência bem-sucedida: " + (transferenciaBemSucedida ? "Efetuada" : "Não efetuada"));

        // Adicionar quebra de linha
        System.out.println();

        // Exibir saldos finais após os testes
        System.out.println("Saldo final da conta1: " + conta1.getSaldo());
        System.out.println("Saldo final da conta2: " + conta2.getSaldo());
    }
}