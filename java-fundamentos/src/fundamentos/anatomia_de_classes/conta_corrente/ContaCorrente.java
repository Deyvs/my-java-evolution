package fundamentos.anatomia_de_classes.conta_corrente;

public class ContaCorrente {

    public static void main(String[] args) {

        UserConta conta = new UserConta();

        conta.addConta(1234);
        System.out.println("Conta: " + conta.getNumConta());

        conta.depositar(1532.2);
//        System.out.println("Seu saldo atual é de: " + conta.getSaldo());
//        conta.depositar(0.0);
        conta.sacar(1532.0);
        conta.sacar(1.0);
//        System.out.println("Seu saldo atual é de: " + conta.getSaldo());


    }
}
