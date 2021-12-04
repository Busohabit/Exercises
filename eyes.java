/* *****************************************
AUTHOR Paul Curzon
A program that politely enquires of people's eye colour  
******************************************** */

import java.util.Scanner; // Needed to make Scanner available

class eyes
{
    public static void main (String[] param)
    {
        // We want to print out the message defined in method helloMessage
		
		askForEyeColour();
		System.exit(0);
		
    } // END main

	/* ***************************************************
	   Method askForEyeColour asks the user for their eye colour,
	   then stores it in the variable called eyeColour
	   it is then printed back as part of a message.
	*/
	
    public static void askForEyeColour()
    {
       String eyeColour = inputColour();
	   
	   System.out.println( 
	               "So your eyes are "+ eyeColour+ 
                   " are they. I like "+ eyeColour+ ".");
       return;	
    } // END askForEyeColour
	
	
	/* ***************************************************
       This method gets a single string - an eye colur. from the user 
       and returns it
    */
    public static String inputColour()
    {
       Scanner scanner = new Scanner(System.in);
       String colour;

       System.out.println("What colour are your eyes?");
       colour = scanner.nextLine();
   
       return colour;
    } // END inputColour
 

} // END class eyes
