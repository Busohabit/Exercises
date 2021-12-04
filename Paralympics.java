/*
@Author - Musa Khan
@Date -14/11/2021
@Version - Version 1
@Purpose - determines the legality of a paralympic relay team using the disability classes of each relay leg and outputs a 
message to the user stating which legs are and aren't legal.
*/

import java.util.Scanner; // Needed to make Scanner available

//creates record type UniversalRelayTeams
class UniversalRelayTeam
{
    String country;  //creates field country
    int leg1; //creates field leg1
    int leg2; //creates field leg2
    int leg3; //creates field leg3
    int leg4; //creates field leg4

} //END Teams record

class Paralympics // change the name to something appropriate
{
    public static void main (String [] a)
    {
        relay(); //Change this to a call to the method doing the work
        System.exit(0);
    }
    
    //asks the user for an input and then takes in their response which it then returns
    public static String userInput(String question)
    {
        String given_input; //declares the variable given_input
        Scanner scanner= new Scanner(System.in); //creates a Scanner object labelled scanner

        System.out.println(question); //prints the message taken in as an input
        given_input = scanner.nextLine(); //takes in the user input and stores it in the given_input variable

        return given_input; //returns the variable given_input
    }//END userInput 
    
    //checks if the first leg of the team is legal
    public static boolean checkLeg1(UniversalRelayTeam u)
    {
        if (getLeg1(u) == 11 || getLeg1(u) == 13)
        {
            return true; //returns true
        }
        else
        {
            return false; //returns false
        }    
    }//END checkLeg1
    
    //checks if the second leg of the team is legal
    public static boolean checkLeg2(UniversalRelayTeam u)
    {
        if (getLeg2(u) == 61  || getLeg2(u) == 62 )
        {
            return true; //returns true
        }
        else
        {
            return false; //returns false
        }    
    }//END checkLeg2
    
    //this method checks if the third leg of the team is legal
    public static boolean checkLeg3(UniversalRelayTeam u)
    {
        if (getLeg3(u) == 35 || getLeg3(u) == 36)
        {
            return true; //returns true
        }
        else
        {
            return false; //returns false
        }    
    }//END checkLeg3
    
    //this function checks if the fourth leg of the team is legal
    public static boolean checkLeg4(UniversalRelayTeam u)
    {
        if (getLeg4(u) == 51 || getLeg4(u) == 52)
        {
            return true; //returns true
        }
        else
        {
            return false; //returns false
        }    
    }//END checkLeg4
    
    //checks if each leg of a UniversalRelayTeam record is legal or not and outputs a message if it isn't
    public static void legalMessages(UniversalRelayTeam u)
    {
        if (checkLeg1(u) == false) //checks if the first leg is legal or not
        {
            System.out.println("Leg 1 (" + getLeg1(u) + ") is not legal."); 
            //prints message informing the user that it is not legal
        }

        if (checkLeg2(u) == false) //checks if the second leg is legal or not
        {
            System.out.println("Leg 2 (" + getLeg2(u) + ") is not legal."); 
            //prints message stating that the second leg is not legal
        }

        if (checkLeg3(u) == false) //checks if the third leg is legal or not
        {
            System.out.println("Leg 3 (" + getLeg3(u) + ") is not legal."); 
            //prints message stating that the third leg is not legal
        }

        if (checkLeg4(u) == false) //checks if the fourth leg is legal or not
        {
            System.out.println("Leg 4 (" + getLeg4(u) + ") is not legal."); 
            //prints message stating that the fourth leg is not legal
        }

        return;

    }//END legalMessages
    
    //this method asks the user to give information about the team which is used to check the legality of the team
    public static void relay()
    {
        String country; //declares variable country
        int leg1; //declares variable leg1
        int leg2; //declares variable leg2
        int leg3; //declares variable leg3
        int leg4; //declares variable leg4

        UniversalRelayTeam team = new UniversalRelayTeam();

        country = userInput("What country is the team representing?"); //takes in input and stores it in country
        leg1 = Integer.parseInt(userInput("What is the disability class for leg 1?T "));
        //takes in input and stores it in leg1
        leg2 = Integer.parseInt(userInput("What is the disability class for leg 2?T ")); 
        //takes in input and stores it in leg2
        leg3 = Integer.parseInt(userInput("What is the disability class for leg 3?T "));
        //takes in input and stores it in leg3
        leg4 = Integer.parseInt(userInput("What is the disability class for leg 4?T "));
        //takes in input and stores it in leg4

        team = createTeam(country, leg1, leg2, leg3, leg4); 
        //calls createTeam function to create a UniversalRelayTeam record using the user's inputs

        System.out.print("The " + getCountry(team) + " team is: Leg 1, T" +  getLeg1(team) + "; Leg 2, T" + getLeg2(team));
        System.out.println("; Leg 3, T" + getLeg3(team) + "; Leg 4, T" + getLeg4(team));
        //prints message with information about the relay team

        legalMessages(team); //calls the legalMessages procedure with team as an argument

    }//END relay
    
    /* Defines abstract data type UniversalRelayTeam with methods that:
        - set individual fields for the record type and return the record itself
        - get individual fields for the record type and return the value held in the field
        - create a new instance of the UniversalRelayTeam record with its field initialized
    */
    
    //this sets the value for a specific UniversalRelayTeam record's country field
    public static UniversalRelayTeam setCountry(UniversalRelayTeam u, String given_country)
    {
        u.country = given_country; //sets the country field to the value stored in given_country

        return u; //returns the record taken in by the function as an argument
    }//END setCountry

    //this function sets the value for a specific UniversalRelayTeam record's leg1 field
    public static UniversalRelayTeam setLeg1(UniversalRelayTeam u, int given_leg1)
    {
        u.leg1 = given_leg1; //sets the leg1 field to the value stored in given_leg1

        return u; //returns the record taken in by the function as an argument
    }//END setLeg1

    //this assigns a value to a specific UniversalRelayTeam record's leg2 field
    public static UniversalRelayTeam setLeg2(UniversalRelayTeam u, int given_leg2)
    {
        u.leg2 = given_leg2;  //sets the leg2 field to the value stored in given_leg2

        return u; //returns record taken in as an argument
    }//END setLeg2

    //this method sets the value for a  specific UniversalRelayTeam record's leg3 field
    public static UniversalRelayTeam setLeg3(UniversalRelayTeam u, int given_leg3)
    {
        u.leg3 = given_leg3;  //sets the leg3 field to the value stored in given_leg3

        return u; //returns the record taken in as an argument
    }//END setLeg3

    // sets the value for a specific UniversalRelayTeams record's leg4 field
    public static UniversalRelayTeam setLeg4(UniversalRelayTeam u, int given_leg4)
    {
        u.leg4 = given_leg4;  //sets the leg4 field to the value stored in given_leg4

        return u; //returns record 
    }//END setLeg4
    
    //returns the country field for a specific UniversalRelayTeams record
    public static String getCountry(UniversalRelayTeam u)
    {
        return u.country; //returns the country field 
    }//END getCountry
    
    //returns the leg1 field for a specific UniversalRelayTeam record
    public static int getLeg1(UniversalRelayTeam u)
    {
        return u.leg1; //returns the leg1 field
    }//END getLeg1
    
    //returns the leg2 field for a specific UniversalRelayTeam record
    public static int getLeg2(UniversalRelayTeam u)
    {
        return u.leg2; //returns the leg2 field
    }//END getLeg2

    //returns leg3 field for a specific UniversalRelayTeam record
    public static int getLeg3(UniversalRelayTeam u)
    {
        return u.leg3; //returns the leg3 field 
    }//END getLeg3

    //returns the leg4 field for a specific UniversalRelayTeam record
    public static int getLeg4(UniversalRelayTeam u)
    {
        return u.leg4; //returns the leg4 field
    }//END getLeg4
   
    //creates a universalRelayTeam record
    public static UniversalRelayTeam createTeam(String given_country, int given_leg1, int given_leg2, 
                                                int given_leg3, int given_leg4)
    {
        UniversalRelayTeam u = new UniversalRelayTeam(); //creates UniversalRelayTeam record u
            
        u = setCountry(u, given_country); //calls setCountry to set the country field of u to given_country
        u = setLeg1(u, given_leg1); // calls setLeg1 to set the country field of u to given_leg1
        u = setLeg2(u, given_leg2); // calls setLeg2 to set the country field of u to given_leg2  
        u = setLeg3(u, given_leg3); // calls setLeg3 to set the country field of u to given_leg3
        u = setLeg4(u, given_leg4); // calls setLeg4 to set the country field of u to given_leg4
        
        return u; //returns u

    }//END createTeam
}
