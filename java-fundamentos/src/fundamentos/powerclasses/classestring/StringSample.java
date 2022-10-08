package fundamentos.powerclasses.classestring;

public class StringSample {

    public static void main(String[] args) {
        /*
         * A classe String é utilizada para respresentar conteudos alfanumericos, exemplo:
         * JOSE, maria, NIJ-3323, 123@master
         *
         * Link documentação oficial oracle versão 18
         * https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/lang/String.html
         */
        //metodoConcat();
        metodoContains();
        //metodoIsBlank();
        //metodoLowerUpperCase();

    }
    static void metodoLowerUpperCase(){
        /* * métodos que tornam as palavras  minusculas respectivamente*/

        String nome = "DEYVISON RAMOS";
        String nomeMinusculo = nome.toLowerCase();
        System.out.println(nomeMinusculo);

        String deNovoMaiusculo = nomeMinusculo.toUpperCase();
        System.out.println(deNovoMaiusculo);
    }
    static void metodoConcat(){
        /*
         *O metódo concat realiza a junção entre dois alfanumericos,
         * podendo ser de forma recursiva já que o retonro
         * deste método é um nova String
        */

        String nome = "deyvison";
        String sobrenome = "ramos";
        //gleyson sampaio
        String nomeCompleto = nome.concat( " ").concat(sobrenome);
        System.out.println(nomeCompleto);

    }
    static void metodoContains(){
        /*
         *O metódo contains analisa se existe o texto passado como parametro
         * em uma determinada variável do tipo String retorna um valor boolean
         * verdadeiro ou falso*/

        String nome = "deyvison ramos";
        String palavra = "ramos";
        Boolean resposta = nome.contains(palavra);//ver aplicabilidade de usar classes Wrappers (toString)

        System.out.println("O nome ".concat(nome).concat(" contém a palavara ")
                .concat(palavra).concat("?\nResposta:").concat( resposta.toString() ));

    }
    static void metodoIsBlank(){
        /*
         * Retorna true se a string estiver vazia ou contiver apenas
         codepoints de espaço em branco, caso contrário, false.
         * método disponível desde versão 11
        */

        String palavra= "";

        //antes do java 11
        boolean vazia = palavra.trim().length() == 0;
        System.out.println("A palavra está vazia? " + vazia);

        //com do java 11
        //vazia = palavra.isBlank();
        System.out.println("A palavra está vazia? " + vazia);

        //vamos ver a diferença entre isBlank versus isEmpty
        //https://howtodoinjava.com/java11/check-blank-string/#:~:text=isBlank()%20vs%20isEmpty(),not%20check%20the%20string%20length.

    }
}
