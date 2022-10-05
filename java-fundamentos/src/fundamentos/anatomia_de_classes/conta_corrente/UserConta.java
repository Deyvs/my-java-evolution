package fundamentos.anatomia_de_classes.conta_corrente;

public class UserConta {

    private Integer numConta;
    private Integer numAgencia;
    private String nomeCliente;
    private Double saldo;

    public void addConta(Integer numConta) {
        this.numConta = numConta;
    }

    public void addAgencia(Integer numAgencia) {
        this.numAgencia = numAgencia;
    }

    public void nomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void depositar(Double value) {
        if(saldo == null) {
            saldo = 0.0;
        }

        if(value > 0.0) {
            saldo = saldo + value;
        } else {
            System.out.println("O valor de depósito deve ser superior a zero.");
        }
    }
    public Integer getNumConta() {
        return numConta;
    }

    public Double getSaldo() {
        return saldo;
    }
}

