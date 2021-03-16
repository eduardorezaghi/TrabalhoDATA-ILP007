import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data novaData1 = new Data("29/02/2096"); // formato britânico
        System.out.printf("Data armazenada no objeto: \t%s%n",novaData1.dataString()); // invocando método de instância dataString para exibir a data armazenada no atributo componentes[]
        int dias = 366;
        System.out.printf("%d dias somados = \t%s%n",dias,(novaData1.soma(dias)).dataString() );
/*         Data tempData = new Data("20/02/2002");
        System.out.printf("%s - %s = \t%02d dias%n",novaData1.dataString(),tempData.dataString(),novaData1.sub(tempData)); */
    }
}
