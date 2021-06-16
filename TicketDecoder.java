import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Ticket Decoder - decodes tickets to Auburn home football games.
 *
 * @author Adam Bostwick
 * @version 9/13/19
 */
 
public class TicketDecoder
{
  /** @param args Command line arguments (not used). */
   public static void main(String[] args)
   {
     // define variables
      String tc = null; //ticket code
      int ltc = 0;
      double price = 0;
      double discount = 0;
      double discountDec = 0;
      double cost = 0;
      String time = null;
      String date = null;
      String section = null;
      String row = null;
      String seat = null;
      String gameDes = null;
      int rpn = 0; //random prize number
      
      DecimalFormat money = new DecimalFormat("$##.00");
      DecimalFormat perc = new DecimalFormat("0.#");
     
      Scanner userInput = new Scanner(System.in);
     // take input
     
      System.out.print("Enter your ticket code: ");
      tc = userInput.nextLine();
      tc = tc.trim();
      userInput.close();

     // decode ticket
     
     //must have at least 26 characters
      ltc = tc.length();
      if (ltc >= 26)
      {
        //price
         price = Double.parseDouble(tc.substring(0, 5));
         price = price * 0.01;
         //priceStr = Double.toString(price.format(money));
         
        //discont
         discount = Double.parseDouble(tc.substring(5, 7));
         discountDec = discount * 0.01;
         
        //calculate cost
         cost = price - (price * discountDec);
         
        //time
         time = tc.substring(7, 9) + ":" + tc.substring(9, 11);
         
        //date
         date = tc.substring(11, 13) + "/" + tc.substring(13, 15) + "/" 
            + tc.substring(15, 19);
            
        //section
         section = tc.substring(19, 21);
         
        //row
         row = tc.substring(21, 23);
         
        //seat
         seat = tc.substring(23, 25);
         
        //game description
         gameDes = tc.substring(25, ltc);
         
        //random prize number
         rpn = ThreadLocalRandom.current().nextInt(1, 10000000);
         
        // output result
         System.out.print("\nGame: " + gameDes + "   Date: " + date
            + "   Time: " + time
            + "\nSection: " + section + "   Row: " + row + "   Seat: " + seat
            + "\nPrice: " + money.format(price) + "   Discount: " 
            + perc.format(discount) + "%   Cost: " + money.format(cost)
            + "\nPrize Number: " + rpn);
      }  
      else //if less than 26 character input
      {
         System.out.print("\nInvalid Ticket Code.\nTicket code must have at "
            + "least 26 characters.");
      }
   }
}