/**
 *
 *  @author Ługowska Dominika S17226
 *
 */

package zad1;

import java.math.BigDecimal;
import java.math.RoundingMode; //zaokrąglanie 
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calc {
	BigDecimal n1 = null;
	BigDecimal n2 = null;
	String operator;
	String str;
	BigDecimal result;
	
	public Calc() {}
	
	
	
	public String doCalc(String cmd) {
		try {
			
			//zapisuję liczby do typu BigDecimal i operator typ String

			
			String[] args = cmd.split("\\s+");
			this.n1 = new BigDecimal(args[0]);
			this.n2 = new BigDecimal(args[2]);
			
			this.operator = args[1];
			// w tej metodzie sprawdzam aby podawane liczby byly oddzielone spacjami
			 this.str = String.join("",args);
			
		}catch(Exception e) {
			return "Invalid command to calc";
		}
			
			
			
			try {
				//korzystam z implementacji JavaScript
				
				ScriptEngineManager mgr = new ScriptEngineManager();  
				ScriptEngine se = mgr.getEngineByName("JavaScript"); 
				
				//Object result = se.eval(operator);
				
				//wynik z zaokragleniem do 7 miejsc po przecinku 
				//eval jako obliczenie dzialania (dziala na liczbach bez spacji)
				
				this.result = new BigDecimal((se.eval(str).toString())).setScale(7, RoundingMode.HALF_UP);
				
				
				
			} catch (ScriptException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			return result.toString();
			
	        //System.out.println("wynik" + result.toString());
	
		
	}
	
}  


