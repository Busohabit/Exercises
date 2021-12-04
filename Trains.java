/*
@Author - Musa Khan
@Date -31/10/2021
@Version - Version 1
@Purpose - takes in the destination of trains that have just departed and an integer representing how late each train was,
it does this until repeatedly until it is told to stop. It uses this information to determine which train was 
the most punctual and how late the trains were overall. It then outputs this information in a message to the user through
a string message.
*/

import java.util.Scanner; // Needed to make Scanner available

class Trains // change the name to something appropriate
{
    public static void main (String [] a)
    {
        trainLoop(); //Change this to a call to the method doing the work
        System.exit(0);
    }
    

    //This function takes in an input from the user and returns it when called
    public static String userInput(String given_message)
    {

        String user_input; //declares the variable user_input
        Scanner takes_in_input = new Scanner(System.in); //creates a Scanner object called takes_in_input

        System.out.println(given_message); //prints the message given in functions arguments
        user_input = takes_in_input.nextLine(); //takes in the user's response and stores it in user_input

        return user_input; //returns the variable user_input 

    }//END userInput

    //takes in the destinations of the departed and the amount of time each was late for and uses it to find which was the 
    //least late and the total amount of time that trains were late for which it then outputs to the screen
    public static void trainLoop()
    {

        String destination; //declares variable destination
        int minutes; //declares variable minutes

        int least_late = 0;  //declares and initialises the variable least_late to the integer 0
        int total_minutes = 0; //declares and initialises the variable total_minutes to the integer 0
        String most_punctual = ""; //declares and initialises the variable most_punctual to an empty string
        int train_counter = 0; //declares and initialises the variable train_counter to the integer 0

        boolean loop_condition = false; //declares and initialises the variable loop_condition to false

        while (loop_condition == false)
        {
            destination = userInput("What is the destination of the train that just departed?");
            //asks the user for the train destination
            if (destination.equals("XXX"))
            {

                loop_condition = true; //sets loop_condition to true
                break; //exits loop

            }

            minutes = Integer.parseInt(userInput("How many minutes late was it?")); 
            //sets minutes to userInput after converting the input from a string to an integer
            total_minutes += minutes; //adds the amount of minutes to the total_minutes variables

            if (train_counter == 0)
            {
                most_punctual = destination; //by default it sets most_punctual to the first destination
                least_late = minutes; //by defualt it sets least_late to minutes
            }
            else
            {
                if (least_late > minutes)
                {
                    most_punctual = destination; //sets most_punctual to the destination variable
                    least_late = minutes; //sets least_late to the minutes variable
                }
                else
                {

                    continue; //keeps the loops going

                }
            }
            train_counter += 1; //increments the train_counter

        }

        System.out.println("The trains were " + total_minutes + " minutes late."); //prints message to the screen
        System.out.println("The most punctual train was to " + most_punctual + ". It was " + least_late + " minutes late.");
        //prints message to the screen

        return;
    }//END trainLoop();
}
