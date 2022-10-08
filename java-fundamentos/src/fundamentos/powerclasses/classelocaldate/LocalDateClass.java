package fundamentos.powerclasses.classelocaldate;

import static fundamentos.powerclasses.classelocaldate.MetodPlusAndMinus.*;

public class LocalDateClass {

    public static void main(String[] args) {
        /*
            *A classe LocalDate está localizada no pacote java.time, desde a versão 1.8.
            * é um objeto de data imutável - todos os métodos de modificação retornam
              um novo objeto e, portanto, não alteram o valor do objeto atual
            * representa uma data com formato padrão como yyyy-MM-dd (seguindo ISO 8601)
            * Link documentação oficial oracle versão 18
            * https://docs.oracle.com/javase/8/docs/api/java/time/LocalDate.html
            *
         */

        //metodoOf(2021, 5, 23);
        plus();
        minus();
    }

}
