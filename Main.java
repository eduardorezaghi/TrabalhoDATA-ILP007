import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data novaData1 = new Data("20/02/2001"); // formato britânico
        System.out.printf("Data armazenada no objeto: \t%s%n",novaData1.dataString()); // invocando método de instância dataString para exibir a data armazenada no atributo componentes[]

        System.out.printf("Dias decorridos até o conteúdo da instância = %d%n",novaData1.dataDias());
        System.out.printf("5 dias somados = %s%n", (novaData1.soma(5)).dataString() );
    }
}
