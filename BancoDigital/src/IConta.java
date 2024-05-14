// IConta.java
public interface IConta {
    void depositar(double valor);
    boolean sacar(double valor);
    boolean transferir(Conta destino, double valor);
    double getSaldo();
}
