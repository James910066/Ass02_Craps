import java.util.Random;
import java.util.Scanner;
public class Ass02_Craps
{
    public static void main(String[] args)
    {
        //Declaration and assignment of all variables
        int point = 0;
        int die1 = 0;
        int die2 = 0;
        Random rnd = new Random(); //Number generator for dice roll
        int diceTotal;
        boolean stillPlaying = false; //Variable for checking if user is still playing loop
        String userResponse = ""; //Variable for user input
        Scanner in = new Scanner(System.in); //Scanner for user input
        String trash = ""; //Empty variable assignment for bad user input
        boolean wrongInput = false; //Variable for validating user input loop

           do //Start of the game loop
           {
               die1 = rnd.nextInt(6) + 1; //Set range for dice roll from 1 to 6
               die2 = rnd.nextInt(6) + 1; //Set range for dice roll from 1 to 6
               diceTotal = die1 + die2; //Variable assigned to sum of both dice

               //check for a craps roll
                if (diceTotal == 2 || diceTotal == 3 || diceTotal == 12) //Check dice total for craps
                    {
                        System.out.println("You rolled a " + die1 + " and a " + die2); //Output statement for what user rolled on each die
                        System.out.println("You rolled a " + diceTotal + ": You crapped out!"); //Output statement showing total of dice and player crapping out
                    }
                else if (diceTotal == 7 || diceTotal == 11) //check dice total for a natural
                    {
                        System.out.println("You rolled a " + die1 + " and a " + die2); //Output statement for what user rolled on each die
                        System.out.println("You rolled a natural: " + diceTotal + " You win!"); //Output statement showing total of dice and player rolling a natural
                    }
                else //Dice roll is a point
                    {
                        System.out.println("You rolled a " + die1 + " and a " + die2); //Output statement for what user rolled on each die
                        System.out.println("You rolled Point: " + diceTotal + " You get to Roll again"); //Output statement showing dice total and player rolling point
                        point = die1 + die2; //Set point variable to new dice total

                        while (diceTotal != 7 || diceTotal != point) //Loop while total dice roll is not 7 or equal to the point roller prior
                        {
                            die1 = rnd.nextInt(6) + 1; //Roll of die 1 with number generator
                            die2 = rnd.nextInt(6) + 1; //Roll of die 2 with number generator
                            diceTotal = die1 + die2; //Set variable to total of both dice
                            if (diceTotal == point) //Check if player rolled to match point
                                {
                                    System.out.println("You rolled " + diceTotal + " again, You win!"); //Output statement showing total that player rolled matching point and winning
                                    break; //Jump out of inner loop for rolling point into outer loop to start game again where user is asked to play again
                                }
                            else if (diceTotal == 7) //check if player rolled a 7
                                {
                                    System.out.println("You rolled a " + diceTotal + "; You lose"); //Output statment showing dice total and that they lost for rolling a 7
                                    break; //Jump out of inner loop for rolling point into outer loop to start game again where user is asked to play again
                                }
                            else //Player rolled other value that is not point or a 7
                                {
                                    System.out.println("You rolled a " + die1 + " and a " + die2); //Output statement showing what the player rolled for each die
                                    System.out.println("You rolled a total of " + diceTotal + ". You get to Roll again"); //Output Statement showing total of dice rolled and telling user to roll again
                                }
                        }
                    }
                //Loop for checking user input
               do { //Start of loop
                   System.out.print("Want to play again? [Y/N] "); //Prompt users to play game again or not
                   userResponse = in.nextLine(); //User input assigned to boolean variable

                   if (userResponse.equalsIgnoreCase("Y")) //Check if user want to play again
                       {
                           stillPlaying = true; //Change of boolean variable from false because user chose Y or y
                           wrongInput = false; //Jump out of inner loop to outer loop for playing game again
                       }
                   else if(userResponse.equalsIgnoreCase("N")) //Check if user chose to quit game
                       {
                           stillPlaying = false; //Boolean variable changed to false for quiting game
                           wrongInput = false; //Jump out of inner loop
                       }
                   else //Bad user input goes here
                       {
                           trash = in.nextLine(); //Set variable to bad user input for output statement
                           wrongInput = true; //Change boolean variable so loop continues to ask for correct input
                           System.out.println(trash + " is invalid choice. Choose [Y/N]"); //Output statement to notify user of bad input
                       }

               } while (wrongInput); //Boolean loop condition used to keep asking user for correct input
           } while (stillPlaying); //Boolean loop condition stating true to keep playing until user chooses N
    }
}
