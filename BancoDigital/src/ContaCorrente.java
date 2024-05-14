// ContaCorrente.java
public class ContaCorrente extends Conta {
    public ContaCorrente(String numeroConta, double saldoInicial, double taxaManutencao) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }

        if (saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }

        saldo -= valor;
        return true;
    }

    @Override
    public boolean transferir(Conta destino, double valor) {
        if (destino == null) {
            System.out.println("Conta de destino não encontrada.");
            return false;
        }

        if (valor <= 0) {
            System.out.println("Valor de transferência inválido.");
            return false;
        }

        if (saldo < valor) {
            System.out.println("Saldo insuficiente para transferência.");
            return false;
        }

        saldo -= valor;
        destino.depositar(valor);
        return true;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}
