package fundamentos.poweclasses.classelocaldate;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class MetodPlusAndMinus {
    /*
        *Os métodos plus() e minus() são usados para obter uma data com o valor adicionado ou
         subtraído de uma quantidade de unidades, sejam elas em dias, semanas, meses ou anos.
        *recebem como parâmetro um ou dois tipos, que são:
        (TemporalAmount amountToSubtract) – recebem um valor do tipo TemporalAmount ou
        (long amountToSubtract, TemporalUnit unit) – recebem dois parâmetros, dos tipos: long e TemporalUnit
        * retorna um tipo um LocalDate com baseado na data com o valor especificado adicionado ou subtraído, não nulo
        * ERROS - DateTimeException - se a adição ou subtração não puderem ser realizada
                  UnsupportedTemporalTypeException - se a unidade não for suportada
                  ArithmeticException - se ocorrer um overflow numérico
    */
    static void plus() {

        LocalDate today = LocalDate.now();
        System.out.println("Data de hoje: " + today);
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        //utilizando minus(TemporalAmount amountToSubtract)
        LocalDate plusWeek = today.plus(Period.ofWeeks(1));
        LocalDate plusMonthsLater = today.plus(Period.ofMonths(10));
        LocalDate plusYearsLater = today.plus(Period.ofYears(20));

        System.out.println("Algumas semanas depois da data de hoje: " + plusWeek);
        System.out.println("Alguns meses depois da data de hoje: " + plusMonthsLater);
        System.out.println("Alguns anos depois da data de hoje: " + plusYearsLater);

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
        //Utilizando ,minus(long amountToSubtract, TemporalUnit unit)
        LocalDate plusDay = today.plus(1, ChronoUnit.DAYS);
        LocalDate monthsLater = today.plus(1, ChronoUnit.MONTHS);
        LocalDate yearsLater = today.plus(2, ChronoUnit.YEARS);

        System.out.println("Adicionando dias: " + plusDay);
        System.out.println("Adicionando meses: " + monthsLater);
        System.out.println("Adicionando anos: " + yearsLater);

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    static void minus() {

        LocalDate today = LocalDate.now();
        System.out.println("Data de hoje: " + today);
        //utilizando minus(TemporalAmount amountToSubtract)
        LocalDate nextWeek = today.minus(Period.ofWeeks(1));
        LocalDate tenMonthsAgo = today.minus(Period.ofMonths(10));
        LocalDate twentyYearsAgo = today.minus(Period.ofYears(20));

        System.out.println("Semana passada: " + nextWeek);
        System.out.println("Dez meses atrás: " + tenMonthsAgo);
        System.out.println("Vinte anos atrás: " + twentyYearsAgo);

        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println();

        //Utilizando ,minus(long amountToSubtract, TemporalUnit unit)
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        LocalDate oneMonthAgo = today.minus(1, ChronoUnit.MONTHS);
        LocalDate twoYearsAgo = today.minus(2, ChronoUnit.YEARS);

        System.out.println("Data de ontem: " + yesterday);
        System.out.println("Um mês atrás: " + oneMonthAgo);
        System.out.println("2 anos atrás: " + twoYearsAgo);
    }
}
