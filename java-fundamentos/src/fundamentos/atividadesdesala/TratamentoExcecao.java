package fundamentos.atividadesdesala;

public class TratamentoExcecao {
    public static void main(String[] args) {

        try {
            System.out.println(somar(2, 3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }

    static int somar(int num1, int num2) throws IllegalArgumentException {
        if (num1 < 0) {
            throw new IllegalArgumentException("[ERRO] - O primeiro valor informado não pode ser negativo");
        }

        if (num2 > 10) {
            throw new IllegalArgumentException("[ERRO] - O segundo valor informado pode ser maior que 10!");
        }

        int resultado = num1 > num2 ? num1 - num2 : num2 - num1;
        return resultado;
    }
}
