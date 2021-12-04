/*
@NAME - Musa Khan
@DATE - 10/10/2021
@VERSION - Version 1
@purpose - Calculates the parking charges for a person based on a range of different factors,
such as their age, whether they live locally, or whether they disabled, taken from the users input
and determines how much they will be charged for parking based on these things
*/

import java.util.Scanner; // Needed to make Scanner available

class CarPark // change the name to something appropriate
{
    public static void main (String [] args)
    {
        parkingCharges(); //Change this to a call to the method doing the work
        System.exit(0);
    }
    
    // Add all methods the program uses here
    //this function takes in user's input as a string in response to different strings represented by the parameter message
    public static String userInput(String message) 
    { 
        String user_input;

        Scanner scanner = new Scanner(System.in); //creates scanner object

        System.out.println(message);
        user_input = scanner.nextLine(); //stores user input

        return user_input;

    }//END userInput
    
    //this function takes in user's input as an integer in response to different strings represented by the parameter message
    public static int userInput2(String message)
    { 
        int user_input;

        Scanner scanner = new Scanner(System.in); //creates scanner object

        System.out.println(message);
        user_input = Integer.parseInt(scanner.nextLine()); //stores user input

        return user_input;

    }//END userInput2
    
    /* this function takes in the number of hours the person will park for and uses it to calculate 
    their parking charges at this stage
    */
    public static double hoursParking(double parkingCost){
         int hours = userInput2("How many hours do you wish to park?"); //takes in the number of hours

         if (hours == 1) 
         {
             parkingCost += 3.00;
         }
         else if (hours >= 2 && hours <= 4) 
         {
             parkingCost += 4.00;
         }
         else if (hours >= 5 && hours <= 6)
         {
             parkingCost += 4.50;
         }
         else if (hours >= 7 && hours <= 8)
         {
             parkingCost += 5.50;
         }
         else 
         {
             System.out.print("Enter a number between 1 and 8."); //tells the user to try again if their input is invalid
             hoursParking(parkingCost); //recursively calls the hoursParking function
         }

         return parkingCost;
     }//END hoursParking
    
    public static void parkingCharges()
    {
        double parkingCost = 0.0; //represents the cost of parking 
        String disabled;
        double hours;
        String oap;
        String local;

        disabled = userInput("Are you disabled?\nYes or No?"); //takes in the user's input in response to the question
        if (disabled.equals("yes") || disabled.equals("Yes")) 
        {
            System.out.println("Parking for you is free."); //parking is free for the disabled
        }

        else // if they aren't disabled then they have to pay 
        {
            parkingCost+= hoursParking(parkingCost); //adds the returned value of hoursParking to the parkingCost variable
            local = userInput("Do you have a live locally badge?\nYes or No?"); //takes in the user's input in response to the question
            if (local.equals("yes") || local.equals("Yes")) 
            {
                parkingCost -= 1.00;

            }
        
            oap = userInput("Are you an OAP?\nYes or No?"); //takes in the user's input in response to the question
            if (oap.equals("yes") || oap.equals("Yes")) 
            {
                parkingCost -= 2.00;
            }
            
            }

            System.out.println("The parking charge for you is " + parkingCost + " pounds."); //tells the user their parking charges

    }//END parkingCharges 

}//END CarPark
