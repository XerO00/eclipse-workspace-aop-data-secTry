import java.util.Scanner;

public class StrSplit{

public static void main(String []args){
	  Scanner scan = new Scanner(System.in);  
	  System.out.println("Please enter your name");
	  
   String strMain = "Alpha  Beta  Delta  Gamma  Sigma";
    String[] arrSplit = strMain.split("  ");
    for (int i=0; i < arrSplit.length; i++)
    {
      System.out.println(arrSplit[i]);
    }
  }
}
