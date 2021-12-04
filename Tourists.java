/*
@Author - Musa Khan
@Date - 16/10/2021
@Version - Version 1
@Purpose - asks the user how many attractions they would like to know about and then asks them 
to name that many attractions. If the program recognises that attraction, it will print information about it, 
else it will just state that it does not recognise that attraction.
*/

import java.util.Scanner; // Needed to make Scanner available

class Attraction
{
    String name;
    int opening_time;
    int closing_time;
    Boolean open_on_bank_holiday;
    
}//END attraction    

class Tourists // change the name to something appropriate
{
    public static void main (String [] a)
    {
        final Attraction stonehenge = createAttraction("Stonehenge", 9, 5, true); //creates attraction
        final Attraction tower_of_london = createAttraction("Tower of London", 10, 4, false); //creates attraction
        final Attraction british_museum = createAttraction("British Museum", 10, 5, true); //creates attraction
        final Attraction chester_zoo = createAttraction("Chester Zoo", 10, 5, false); //creates attraction

        touristAttractions(stonehenge, tower_of_london, british_museum, chester_zoo);
        //Change this to a call to the method doing the work
        System.exit(0);
    }
        
    // Add all methods the program uses here
    //Sets the value for that record's name field
    
    public static Attraction setName(Attraction a, String given_name)
    {
    a.name = given_name;
    return a;
    }//END setName

    //Sets the value for that record's openingTime field
    public static Attraction setOpeningTime(Attraction a, int given_opening_time)
    {
        a.opening_time = given_opening_time;
        return a;
    }//END setOpeningTime

    //Sets the value for that record's closingTime field
    public static Attraction setClosingTime(Attraction a, int given_closing_time)
    {
        a.closing_time = given_closing_time;
        return a;
    }//END setClosingTime

    //Sets the value for that record's openOnBankHoliday field
    public static Attraction setOpenOnBankHoliday(Attraction a, boolean given_open_on_bank_holiday)
    {
        a.open_on_bank_holiday = given_open_on_bank_holiday;
        return a;
    }//END SetOpenOnBankHoliday

    //Gets the value for that record's name field
    public static String getName(Attraction a)
    {
        return a.name;
    }//END GetName

    //Gets the value for that record's openingTime field
    public static int getOpeningTime(Attraction a)
    {
        return a.opening_time;
    }//END setOpeningTime

    //Gets the value for that record's closingTime field
    public static int getClosingTime(Attraction a)
    {
        return a.closing_time;
    }//END getClosingTime

    //Gets the value for that record's openOnBankHoliday field
    public static boolean getOpenOnBankHoliday(Attraction a)
    {
        return a.open_on_bank_holiday;
    }//END getOpenOnBankHoliday

     
    //creates a new record of the Attraction type using the arguments given by the user
    public static Attraction createAttraction(String given_name, int given_opening_time, int given_closing_time, 
                                                  Boolean given_open_on_bank_holiday) 
    { 
        Attraction a = new Attraction();

        a.name = given_name;
        a.opening_time = given_opening_time;
        a.closing_time = given_closing_time;
        a.open_on_bank_holiday = given_open_on_bank_holiday;  

        return a;
    }//END createAttraction


    //prints a message given in the functions parameters, takes in their input in response and returns it
    public static String userInput(String message)
    { 
        String user_input;

        Scanner scanner = new Scanner(System.in); //creates scanner object

        System.out.println(message);
        user_input = scanner.nextLine(); //stores user input

        return user_input;

    }//END userInput
    
    //prints information about the given tourist attraction 
    public static String infoMessage(Attraction attraction)
    {
        if (getOpenOnBankHoliday(attraction) == true) //if-then-else statement to determine what message to print
        {
            System.out.println(getName(attraction) + " opens on bank holidays."); 
            //prints message saying that the attraction is open on a bank holiday
        }
        else if (getOpenOnBankHoliday(attraction) == false)
        {
            System.out.println(getName(attraction) + " does not open on bank holidays.");
        }

        return ("It opens at " + getOpeningTime(attraction) + "am." ); //returns the time the attraction opens at

    }//END infoMessage    


    //takes in an attraction name as an input and prints out information about that attraction
    public static void attractionInformation(String attraction_name, Attraction stonehenge, 
                                             Attraction tower_of_london, Attraction british_museum, Attraction chester_zoo)
    {
        if (attraction_name.equals("Stonehenge"))
        {
            System.out.println(infoMessage(stonehenge));
        }
        else if (attraction_name.equals("Tower of London"))
        {
            System.out.println(infoMessage(tower_of_london));
        }
        else if (attraction_name.equals("Big Ben"))
        {
            System.out.println(infoMessage(bigBen));
        }    
        else if (attraction_name.equals("British Museum"))
        {
            System.out.println(infoMessage(british_museum));
        }
        else if (attraction_name.equals("Chester Zoo"))
        {
            System.out.println(infoMessage(chester_zoo));
        }
        else
        {
            System.out.println("I have no information about that attraction.");
        }

        return;

    }//END attractionInformation


    //asks the user to name tourist attractions for a certain number of times and gives info on them
    public static void touristAttractions(Attraction stonehenge, Attraction tower_of_london, Attraction british_museum, 
                                          Attraction chester_zoo)
    {       
        int number_of_attractions; //declares number_of_attractions
        String attraction_input; //declares attraction_input

        number_of_attractions = Integer.parseInt(userInput("How many attractions do you need to know about?"));

        for (int i = 1; i <= number_of_attractions; i++) //for loop
        {
            attraction_input = userInput("Name attraction " + i + "?"); //stores result in attraction_input variable
            attractionInformation(attraction_input, stonehenge, tower_of_london, british_museum, chester_zoo);
            //calls attractionInformation with attraction_input as an argument
        }

        return;

    }//END touristAttractions

}

