public class Data
{
    private static int formato = 0; // 0 para britânico, 1 para americano, 2 para italiano, 3 para germânico e 4 para ANSI
    private static String separador = "";
    private static int termos[] = {0,1,2}; // 0 - aparece antes do 1º separador, 1 - aparece entre os separadores, 2 - aparece após o 3º separador
    private int componentes[] = new int[3];

    public static boolean mudaFormato(int formato)
    {
        // ...
        return false;
    }

    public Data(int d, int m, int a)
    {
        // ...
    }
    public Data(String stringData)
    {
        // ...
    }
    public Data(Data data)
    {
        // ...
    }

    public boolean stringData(String string) // A instancia que ativa este método deve assumir o valor correspondente à string recebida como parâmetro. A data passará pela consistencia, retornará true para data OK, e false para data inválida.
    {
        // ...
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