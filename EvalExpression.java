import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * 
 *
 * @author Adam Bostwick
 * @version 9/13/19
 */
public class EvalExpression
{
   /** @param args Command line arguments (not used). */
   public static void main(String[] args)
   {
      //define variables
      double x = 0;
      double result = 0;
      String restring = "";
      int dotPos = 0;
      int theLength = 0;
      int afterDot = 0;
      double res2 = 0;
      
      Scanner userInput = new Scanner(System.in);
      
      String pattern = "#,##0.0###";
      DecimalFormat traditional = new DecimalFormat(pattern);
      
      //take input
      System.out.print("Enter a value for x: ");
      x = Double.parseDouble(userInput.nextLine());
      userInput.close();

      //formula
      
      result = (12.4 * Math.pow(x, 6)) - (1.2 * Math.pow(x, 3));
      res2 = Math.abs((2.6 * Math.pow(x, 5)) - (6.8 * x) + 7);
      result = result + Math.sqrt(res2);
      result = result / (Math.pow(x, 4) + 9);
      
      //convert / analyze result
      
      restring = Double.toString(result);
      dotPos = restring.indexOf(".");
      theLength = restring.length();
      afterDot = theLength - (dotPos + 1);
      
      //output result
      System.out.print("Result: " + result 
         + "\n# of characters to left of decimal point: " + dotPos 
         + "\n# of characters to right of decimal point: " + afterDot
         + "\nFormatted Result: " +  traditional.format(result));  
   }
}