/*
@Author - Musa Khan
@Date - 27/10/2021
@Version - Version 1
@Purpose - asks the user for information about olympians/paralympians, stores it in different arrays which it then uses to
print this information back to the user along with the average number of medals won by the olympians
*/

import java.util.Scanner; // Needed to make Scanner available

class Athletes 
{
    public static void main (String [] a)
    {
        athleteLoop(); //Change this to a call to the method doing the work
        System.exit(0);
    }
    
    //Takes in the user's input and returns it
    public static String userInput(String message)
    {
        Scanner keyboard = new Scanner(System.in); //creates Scanner object called keyboard
        String user_input; //declares variable user_input

        System.out.println(message); //prints message from the functions arguments
        user_input = keyboard.nextLine(); //takes in the user's response and stores it in user_input

        return user_input; //returns the user's input  
    }//END userInput 

    // prints information about the arrays
    public static void printInfo(int size, String[] a, String[] b, int[] c)
    {
        for (int i = size - 1; i >= 0; i--)
        {
            System.out.println(a[i] + ", " + b[i] + ", " + c[i]); //prints information from arrays
        }    
    }//END printInfo
    
    //takes in information about athletes and stores it in different arrays 
    //also prints the average amount of medals and information about the athletes back to the user
    public static void athleteLoop()
    {
        final int size = 5; //declares variable size
        String[] olympians = new String[size]; //creates array olympians
        String[] sports = new String[size]; //creates array sports
        int[] medals = new int[size]; //creates array medals
        double medal_total = 0; //declares and initalizes variable medal_counter
        int medal_average; //declares variable

        for (int i = 1; i <= size; i++)
        {
            olympians[i] = userInput("Name Olympians/Paralympian " + i + "?"); //takes in input and adds it to array
            medals[i] = Integer.parseInt(userInput("How many medals did he/she win?")); //takes in input and adds it to array
            //also converts it to an integer
            sports[i] = userInput("What sport did he/she compete in?"); //takes in input and adds it to array
            medal_total += medals[i];
        }

        medal_average = (int)(medal_total/5); //finds average amount of medals won

        System.out.println("Between them they won an average of " + medal_average + " medals each.");
        //prints out the average amount of medals won
        System.out.println(); //prints a blank line

        printInfo(size, sports, olympians, medals); //calls printInfo method
    }//END athleteLoop
}
