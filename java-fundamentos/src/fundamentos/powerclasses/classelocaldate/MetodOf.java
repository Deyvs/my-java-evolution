package fundamentos.powerclasses.classelocaldate;

import java.time.LocalDate;

public class MetodOf {

    static void metodoOf(int year, int month, int day) {
        /*
            * É usado para obter uma instância de LocalDate a partir do ano, mês e dia do mês
              passados como parâmetros.
            * é parecido com o método parse(), mas diferente deste último, que recebe uma
              data no formato String como parâmetro (parse(yyyy-MM-dd)), o método of() recebe tipos de parâmetros
            * ano (valor do tipo inteiro), mês (que pode ser dois tipos de valores, int ou Month, este último é
              uma classe da API do Java) e ano (valor do tipo inteiro).
Ex:                     (int year, int month, int dayOfMonth) ou (int year, Month month, int dayOfMonth)
            * Retorno esperado - Tipo LocalDate
            * se o resultado exceder a faixa de data suportada, retorna um DataTimeException
         */
        LocalDate data = LocalDate.of(year, month, day);
        //MOSTRANDO A DATA POR COMPLETO
        System.out.println("Mostrando a data: " + data);
        //PEGANDO APENAS O ANO DA DATA
        System.out.println("[ ANO ] -> " + data.getYear());
        //PEGANDO MES SENDO ELE POR VALOR NUMERICO OU EXTENSO
        System.out.println("[ MÊS ] -> " + data.getMonth());
        System.out.println("[ MES EM VALOR ] -> " + data.getMonthValue());
        //PEGANDO DIA DO MES
        System.out.println("[ DIA ] -> " + data.getDayOfMonth());
        //PEGANDO DIA DA SEMANA
        System.out.println("[ DIA DA SEMANA ] -> " + data.getDayOfWeek());
    }
}
