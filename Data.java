public class Data
{
    private static int formato = 0; // 0 para britânico, 1 para americano, 2 para italiano, 3 para germânico e 4 para ANSI
    private static int termos[] = {0,1,2}; // 0 - aparece antes do 1º separador, 1 - aparece entre os separadores, 2 - aparece após o 3º separador
    private static String separador = "/";

    private int componentes[] = new int[3];

    public static boolean mudaFormato(int formato)
    {
      switch(formato)
      {
        case 0: // formato britanico: DD/MM/AAAA 
          termos[0] = 0;
          termos[1] = 1;
          termos[2] = 2;
          separador = "/";
        break;
        case 1: // formato americano: MM/DD/AAAA 
          termos[0] = 1;
          termos[1] = 0;
          termos[2] = 2;
          separador = "/";
        break;
        case 2: // formato italiano: DD-MM-AAAA 
          termos[0] = 0; 
          termos[1] = 1; 
          termos[2] = 2; 
          separador = '-'; 
          break; 
        case 3: // formato germânico: DD.MM.AAAA 
          termos[0] = 0; 
          termos[1] = 1; 
          termos[2] = 2; 
          separador = '.'; 
          break; 
        case 4: // formato ANSI: AAAA.MM.DD 
          termos[0] = 2; 
          termos[1] = 1; 
          termos[2] = 0; 
          separador = '.'; 
          break; 
        default: // formato inválido 
          return false;
        }
    return true;
    }

    public static boolean consistencia(int dia, int mes, int ano) 
    { 
      if(mes < 1 || mes > 12) // Se mês for menor que 1 ou maior que 12
        return false; // retorne FALSO (Inválido)
      else if (dia < 1 || dia > diasMes(mes, ano)) // Se não, se dia for menor que 1 ou maior que o dia válido do mês
        return false; // retorne FALSO (Inválido)
      else  // Se não for nenhum dos dois casos
        return true; // retorne VERDADEIRO (Válido)
    }

    public static int diasMes(int mes, int ano) 
    { 
      int dias; 
      switch(mes) { 
        case 1: 
        case 3: 
        case 5: 
        case 7: 
        case 8: 
        case 10: 
        case 12: dias = 31; break; // case engloba os meses [1,3,5,6,8,10]
        case 4: 
        case 6: 
        case 9: 
        case 11: dias = 30; break; // case engloba os meses [4,6,8,11]
        case 2: dias = (bissexto(ano))? 29 : 28; break;  // case especial para o mes de fevereiro
        default: dias = 0; 
      } 
      return dias; 
    } 

    public Data(int d, int m, int a)
    {
        // ...
    }
    public Data(String sd)
    {
        stringData(sd);
    }
    public Data(Data data)
    {
        // ...
    }

    public boolean stringData(String string) // A instancia que ativa este método deve assumir o valor correspondente à string recebida como parâmetro. A data passará pela consistencia, retornará true para data OK, e false para data inválida.
    {
        return false;
    }
    public String dataString() // Retorna uma string a partir do conteúdo da instancia que ativa o método, de modo que seja respeitado o formato.
    {
        return String;
    }
    
    private long dataDias() // nº de dias decorridos desde 1 de janeiro de 1900 até a data conteúdo da instância.
    {

    }
    private void diasData(long d) //dias desde 1-jan-1900, define o conteúdo da instancia que ativa o método
    {

    }

    public Data soma(int dias) // Data + dias => Outra Data posterior em dias
    {
        // ...
    }
    public Data sub(int dias) // Data – dias => Data anterior em dias
    {
        // ...
    }
    public long sub(Data d) // Data – Data => dias decorridos entre as duas datas.
    {
        // ...
    }
}