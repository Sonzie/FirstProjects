import java.util.Scanner;
/**
 * Takes amount of oil in ounces and converts to barrels, gallons, quarts, and ounces.
 *
 * @author Adam Bostwick
 * @version 9/10/19
 */
 
public class OilUnits
{
   /** @param args Command line arguments (not used). */
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      int max = 1000000000;
      String inputOzString = "";
      int inputOz = 0;
      int bl = 0;
      int gal = 0;
      int qt = 0;
      int oz = 0;
      
      System.out.print("Enter amount of oil in ounces: ");
      inputOzString = userInput.nextLine();
      userInput.close();
      try {
         inputOz = Integer.parseInt(inputOzString);
      } catch (NumberFormatException e) {
         System.out.println("Input is not a valid integer");
         System.exit(0);
      }
      if (inputOz >= max)
      {
         System.out.print("Amount must not exceed 1,000,000,000.");
      }
      else
      {
         bl = inputOz / 5376;
         oz = inputOz % 5376;
      
         gal = oz / 128;
         oz = oz % 128;
      
         qt = oz / 32;
         oz = oz % 32;
      
         System.out.print("Oil amount in units:\n\tBarrels: " + bl);
         System.out.print("\n\tGallons: " + gal + "\n\tQuarts: " + qt);
         System.out.print("\n\tOunces: " + oz);
         System.out.print("\n" + inputOz + " oz = (" + bl);
         System.out.print(" bl * 5376 oz) + (" + gal + " gal * 128 oz) + (");
         System.out.print(qt + " qt * 32 oz) + (" + oz + " oz)");
      }    
   }
}