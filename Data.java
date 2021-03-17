//   ILP007  – José Paulo Ciscato
// Data.java – Classe para manipulação de datas.
/* NOMES  
*  EDUARDO AUGUSTO REZAGHI TALIANI    RA: 192072-12
*  RICARDO MOLINA OLIVEIRA DE AMORIM  RA: 
*  YURI TAKAE WATANABE                RA: 192142-62
*/
public class Data
{
  private static int formato = 0; // 0 para britânico, 1 para americano, 2 para italiano, 3 para germânico e 4 para ANSI
  private static int termos[] = {0,1,2}; // 0 - aparece antes do 1º separador, 1 - aparece entre os separadores, 2 - aparece após o 3º separador
  private static char separador = '/';
  private int componentes[] = new int[3];

  public static boolean mudaFormato(int formato)
  {
    switch(formato)
    {
      case 0: // formato britanico: DD/MM/AAAA 
        termos[0] = 0;
        termos[1] = 1;
        termos[2] = 2;
        separador = '/';
      break;
      case 1: // formato americano: MM/DD/AAAA 
        termos[0] = 1;
        termos[1] = 0;
        termos[2] = 2;
        separador = '/';
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

  // método de classe para verificação de ano bissexto
  public static boolean bissexto(int ano) 
  {
    return ( (ano%4)==0 && (ano%100)!=0 || (ano%400)==0 );
  }

  // método de classe para verificação de consistência da data
  public static boolean consistencia(int dia, int mes, int ano) 
  { 
    if(mes < 1 || mes > 12)
      return false;
    else if (dia < 1 || dia > diasMes(mes, ano))
      return false;
    else
      return true;
  }

  // método de classe para correta distribuição de dias de um determinado mês
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

  // método construtor com parâmetros int
  public Data(int d, int m, int a)
  {
    if(consistencia(d, m, a)){
      componentes[termos[0]] = d;
      componentes[termos[1]] = m;
      componentes[termos[2]] = a;
    }
  }

  // método construtor com parâmetro String
  public Data(String sd)
  {
    if (!stringData(sd))
    {
      this.componentes[0] = 0;
      this.componentes[1] = 0;
      this.componentes[2] = 0;
    }
  }

  // método construtor de cópia com parâmetro Data
  public Data(Data data)
  {
    this.componentes[0] = data.componentes[0];
    this.componentes[1] = data.componentes[1];
    this.componentes[2] = data.componentes[2];
  }

  // método boolean para definir valor da data por meio de uma String, e validar se a data é válida
  public boolean stringData(String string)
  {
    int[] pos = new int[2];
    for (int i = 0; i < string.length(); i++) 
    {
      if (string.charAt(i) == separador) 
      {
          pos[0] = i;
          break;
      }
    }
    for(int i= pos[0]+1; i < string.length(); i++) 
    {
      if (string.charAt(i) == separador) 
      {
          pos[1] = i;
          break;
      }
    }
    try 
    {
      componentes[termos[0]] = Integer.parseInt(string.substring(0, pos[0]));
      componentes[termos[1]] = Integer.parseInt(string.substring(pos[0] + 1, pos[1]));
      componentes[termos[2]] = Integer.parseInt(string.substring(pos[1] + 1));
    } catch (Exception e) { return false; }

    return consistencia(componentes[termos[0]], componentes[termos[1]], componentes[termos[2]]);
  }

  // método String para retornar a data contida numa string
  public String dataString() 
  {
  return String.format("%02d%c%02d%c%d",
      componentes[termos[0]], separador,
      componentes[termos[1]], separador, 
      componentes[termos[2]]
    );
  }

  // método para retornar o nº de dias decorridos desde 1 de janeiro de 1900 até a data conteúdo da instância.
  public int dataDias()
  {
    int dias = componentes[0];
    for (int ctano = 1900; ctano < componentes[2]; ++ctano)
      dias += bissexto(ctano) ? 366 : 365;
    
    for (int ctmes = 1; ctmes < componentes[1]; ++ctmes)
      dias += diasMes(ctmes, componentes[2]); 
    
    return dias; 
  }

  // método para transformar dias em data
  private void diasData(int d) //dias desde 1-jan-1900, define o conteúdo da instancia que ativa o método
  {
    int ctano = 1900, ctmes = 1, ctdias = 0, delta = 0;
  
    while(ctdias < d) 
    { 
      delta = (bissexto(ctano)) ? 366 : 365;
      ctdias += delta;
      ++ctano;
      if (ctdias > d) ctano--;
    }
    ctdias -= delta; 
    componentes[2] = ctano; 
  
    while(ctdias < d) 
    { 
      delta = diasMes(ctmes, ctano); 
      ctdias += delta; 
      ++ctmes;
      if (ctdias > d) ctmes--;
    } 
    ctdias -= delta; 
    componentes[1] = ctmes; 
    componentes[0] = d - ctdias;
  }

  // public Data soma(int dias) // Data + dias => Outra Data posterior em dias
  // {
  //   Data tempData = new Data("01/01/1900");
  //   tempData.diasData( this.dataDias() + dias );
  //   return tempData;
  // }

  public Data soma(int dias) // Data + dias => Outra Data posterior em dias
  {
    Data tempData = new Data("01/01/1900");
    tempData.diasData( this.dataDias() + dias );
    return tempData;
  }

  public Data sub(int dias) // Data - dias => Outra Data anterior em dias
  {
    Data tempData = new Data("01/01/1900");
    tempData.diasData( this.dataDias() + dias );
    return tempData;
  }

  public int sub(Data d) // Data – Data => dias decorridos entre as duas datas.
  {
    int dias = dataDias() - d.dataDias();
    if (dias < 0)
      return dias * -1;
    else
      return dias;
  }
}