import java.util.Scanner;

public class Main {
    public static void main(String[] args) 
    {
        Data novaData1 = new Data("17/03/2021"); // formato britânico
        Data tempData1 = new Data(7,4,2007);
        Data.mudaFormato(4);
        Data tempData2 = new Data(tempData1);

        System.out.printf("Data armazenada no objeto %s: \t%s%n","novaData1",novaData1.dataString()); // invocando método de instância dataString para exibir a data armazenada no atributo componentes[]
        System.out.printf("Data armazenada no objeto %s: \t%s%n","tempData1",tempData1.dataString());
        System.out.printf("Data armazenada na cópia  %s: \t%s%n","tempData2",tempData2.dataString());

        int dias = 365000;
        System.out.printf("%d dias somados = \t\t%s%n",dias,(novaData1.soma(dias)).dataString() );
        
        System.out.printf("%s - %s = \t%02d dias%n",novaData1.dataString(),tempData1.dataString(),novaData1.sub(tempData1));
    }
}
