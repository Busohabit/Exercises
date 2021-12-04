/*
@Author - Musa Khan
@Date - 18/11/2021
@Version - Version 1 
@Purpose - It acts as a calculator uses recursion to parse an expression it takes in as a String input with the expressions
being given in Polish notation.
*/ 

import java.util.Scanner; // Needed to make Scanner available

class Calculator  
{
    public static void main (String [] a)
    {
        int answer; //delcares the variable answer to 0
        String str = userInput("Please input the expression"); 
        //takes in an input from the user and stores it in the variable str

        answer = calculateAnswer(str); 
        //calls the calculateAnswer function with str as an argument and stores it in the answer variable
        
        System.out.println("The answer is " + answer);
        //prints a message with the value held in the answer variale in it
        
        System.exit(0);
    }
        
    //returns the first element of a string
    public static String nextStringElem(String user_input) 
    {
        
        return user_input.substring(0,1); 
        //returns a substring containing the first element of the string given as an argument 
    
    }//END nextStringElem
    
    
    //returns everything but the first element of a string
    public static String restOfTheString(String user_input)
    {
        
        return user_input.substring(1);
        //returns a substring of the string given as an element holding everything but the first element of the string
    
    } //END restOfTheString
    
    //returns the user's input to a String
    public static String userInput(String message)
    {
        Scanner keyboard = new Scanner(System.in); //creates a new scanner object called keyboard
        String in; //declare String variable in
        
        System.out.println(message); //outputs the String value given as an argument of the function to the screen
        in = keyboard.nextLine(); //takes in an input from the user and stores it in the in variable
        
        return in; //returns the value held in the variable
        
    }//END userInput
    
    //converts a digit given in the expression to an integer
    public static int elemIsJustANumber(String user_input)
    {
        int output; //declares variable output as an integer
        
        switch (user_input) //for the different possible numbers it could be
        {
            case "0": 
                output = 0; //sets output to 0
                break; //stops it from executing any further instructions if the case is actually 0
            case "1":
                output = 1; //sets output to 1
                break; //stops it from executing any further instructions if the case is actually 1
            case "2":
                output = 2; //sets output to 2
                break; //stops it from executing any further instructions if the case is actually 2
            case "3":
                output = 3; //sets output to 3
                break; //stops it from executing any further instructions if the case is actually 3
            case "4":
                output = 4; //sets output to 4
                break; //stops it from executing any further instructions if the case is actually 4
            case "5":
                output = 5; //sets output to 5
                break; //stops it from executing any further instructions if the case is actually 5
            case "6":
                output = 6; //sets output to 6
                break; //stops it from executing any further instructions if the case is actually 6
            case "7":
                output = 7; //sets output to 7
                break; //stops it from executing any further instructions if the case is actually 7
            case "8":
                output = 8; //sets output to 8
                break; //stops it from executing any further instructions if the case is actually 8
            case "9":
                output = 9; //sets output to 9
                break; //stops it from executing any further instructions if the case is actually 9
            case "A":
                output = 10; //sets output to 10 
                break; //stops it from executing any further instructions if the case is actually 10
            case "B": 
                output = 11; //sets output to 11
                break; //stops it from executing any further instructions if the case is actually 11
            case "C":
                output = 12; //sets output to 12
                break; //stops it from executing any further instructions if the case is actually 12
            default:
                output = -1; //this represents a failure condition which takes place when the digit given is not recognised
            }
        
        return output; //returns the value held in the output variable
    
    }//END inputIsJustANumber

    //adds the digit to the next 3 numbers from it
    public static int addNext3(String str)
    {
        int num1; //declares variable num1 
        int num2; //declares variable num2
        int num3; //declares variable num3
        int sum; //declares variable sum

        if ((nextStringElem(str).equals("*"))) 
        {
            num1 = evaluateString(str);
            //sets num1 to the result of evaluateString(str)
        }
        else 
        {
            num1 = evaluateString(nextStringElem(str)); 
            //sets the variable num1 to the result of the evaluateString being called on the
            //first element of the string it takes in as an input found using the nextStringElem function 
        }

        num2 = num1 + 1; 
        //sets the variable num2 to num1 plus 1
        num3 = num2 + 1;
        //sets the variable num2 to num1 plus 1

        sum  = num1 + num2 + num3;
        //assigns the result of adding the values held in the num1, num2 and num3 variables to the sum variable


        return sum; //returns the value held in sum

    }//END addNext3
    
    //multiplies the digits together
    public static int multiply(String str)
    {

        int product; //declares variable product

        if (nextStringElem(str).equals("T")) 
        {
            product = evaluateString(str);
            //sets product to the result of the evaluateString being called on the result of nextStringElem(str)
        }
        else 
        {
            int num1 = evaluateString(nextStringElem(str)); 
            //declares and initializes the variable num1 to the result of the nextStringElem being called on the string
            //it takes as an argument
            int num2 = evaluateString(restOfTheString(str));
            //declares and initializes the variable num2 to the result of evaluateString being run on the rest of the given String

            product = num1 * num2; //multiplies the two values together and assigns the result to the product variable
        }
        return product; //returns the value held in the variable labelled product

    }//END multiply
    
    //recursively parses through the string value to determine the result of the expression it is given as an argument
    public static int evaluateString(String str)
    {
        int number = 0; //declares variable number and initializes it to 0
        int result = 0; //declares variable result and initlaizes it to 0

        if (nextStringElem(str).equals("T")) 
        {
            result = addNext3(restOfTheString(str)); 
            //calls the addNext3 function on the rest of the string and assigns the returned value to the result variable           
        }
        else if (nextStringElem(str).equals("*"))  //for multiplication 
        {
            if (restOfTheString(str).length() == 1) //makes sure there are numbers to multiply togethr
            {
                result = evaluateString(restOfTheString(str)); 
                //if there aren't any numbers to multiply togther it just returns the next number
            }
            else
            {
                result = multiply(restOfTheString(str)); 
                //calls the multiply function on the rest of the string and stores the returned value in result
            }
        }
        else
        {
            if (elemIsJustANumber(nextStringElem(str)) == -1) //runs if the number is not valid 
            {
                System.out.println("Input not recognised."); //tells the user that their input 
                System.out.println("Please try again."); // prints message to the screen
                String str2 = userInput("Please input the expression");
                //declare and intialises the variable str2 to an input given by the user
                evaluateString(str2); //recursively calls the evaluateString with the str2 variable as an argument
            }
            else
            {
                number =  elemIsJustANumber(nextStringElem(str)); 
                //assigns the result of the elemIsJustANumber function to the variable number
                return number; //returns the value held in the variable number
            }     
        }

        return result; //returns the value held in the variable result

    }//END evaluateString
    
    //it calculates the answer to the expression it takes in as an argument
    public static int calculateAnswer(String str)
    {
        int answer; //declares variable answer

        answer = evaluateString(str); 
        //assigns answer to the result of the function evaluateString being called on the string it takes in as an argument

        return answer; //returns the value held in answer

    }//END calculateAnswer
    
} //END Calculator
