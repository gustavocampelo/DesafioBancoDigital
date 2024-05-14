public abstract class Conta implements IConta {
    protected String numeroConta;
    protected double saldo;

    public Conta(String numeroConta, double saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return false;
        }

        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para saque.");
            return false;
        }

        this.saldo -= valor;
        return true;
    }

    public boolean transferir(Conta destino, double valor) {
        if (destino == null) {
            System.out.println("Conta de destino não encontrada.");
            return false;
        }

        if (valor <= 0) {
            System.out.println("Valor de transferência inválido.");
            return false;
        }

        if (this.saldo < valor) {
            System.out.println("Saldo insuficiente para transferência.");
            return false;
        }

        this.saldo -= valor;
        destino.depositar(valor);
        return true;
    }

    public double getSaldo() {
        return saldo;
    }
}
