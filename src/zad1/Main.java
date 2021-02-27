
package zad1;


public class Main {

  public static void main(String[] args) {
    Calc c = new Calc();
    if (args.length >= 1) {
    	String wynik = c.doCalc(args[0]);  
    	System.out.println(wynik);
    	}
   
  }

}
