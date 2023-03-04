import java.util.Random;
import java.util.Scanner;
public class Ass02_Craps
{
    public static void main(String[] args)
    {
        int point = 0; //other values that don't sum up to craps and natural. Keep rolling dice
        int die1 = 0;
        int die2 = 0;
        Random rnd = new Random();
        int rndDice = rnd.nextInt(12) + 1;
        int diceTotal;
        boolean stillPlaying = false;
        String userResponse = "";
        Scanner in = new Scanner(System.in);
        String trash = "";
        boolean rightInput = true;

           do
           {   point = 0;
               die1 = 0;
               die2 = 0;
               diceTotal = 0;
               die1 = rnd.nextInt(6) + 1;
               die2 = rnd.nextInt(6) + 1;
               diceTotal = die1 + die2;



               //check for a craps roll
                if (diceTotal == 2 || diceTotal == 3 || diceTotal == 12)
                    {
                        System.out.println("You rolled a " + die1 + " and a " + die2);
                        System.out.println("You rolled a " + diceTotal + ": You crapped out!");
                    }
                else if (diceTotal == 7 || diceTotal == 11) //check for a natural roll
                    {
                        System.out.println("You rolled a " + die1 + " and a " + die2);
                        System.out.println("You rolled a natural " + diceTotal + ": You win!");
                    }
                else //Dice roll is a point
                    {
                        System.out.println("You rolled a " + die1 + " and a " + die2);
                        System.out.println("You rolled a point " + diceTotal + ": Roll again");
                        point = die1 + die2;

                        while (diceTotal != 7 || diceTotal != point)
                        {
                            die1 = rnd.nextInt(6) + 1;
                            die2 = rnd.nextInt(6) + 1;
                            diceTotal = die1 + die2;
                            if (diceTotal == point)
                                {
                                    System.out.println("You rolled " + diceTotal + " again, You win!");
                                    break;
                                }
                            else if (diceTotal == 7)
                                {
                                    System.out.println("You rolled a " + diceTotal + "; You lose");
                                    break;
                                }
                            else
                                {
                                    System.out.println("You rolled a " + die1 + " and a " + die2);
                                    System.out.println("You rolled a point " + diceTotal + ": Roll again");
                                    point = die1 + die2;
                                }
                        }
                    }


                   System.out.println("Want to play again? [Y/N]"); //Prompt users to play game again or not
                   userResponse = in.nextLine(); //User input assigned to boolean variable

                   if (userResponse.equalsIgnoreCase("Y")) //Convert user input to either case
                   {
                       stillPlaying = true; //Change of boolean variable from false because user chose Y or y
                   }
                   else if(userResponse.equalsIgnoreCase("N"))
                   {
                       stillPlaying = false;
                   }
                   else
                   {
                       trash = in.nextLine();
                       System.out.println("Bad input");
                   }




              /* do //Start of Do While loop for testing playerA input
               {
                   System.out.println("Want to play again? "); //Prompt users to play game again or not
                   if (in.hasNextInt()) //Check if user input is an integer and not string
                   {
                       trash = in.nextLine(); //Assignment of bad input from user
                       System.out.println(trash + " is invalid input."); //Output statement of bad input to user
                   }
                   else //Other choice on good input
                   {
                       playerA = in.nextLine(); //Assignment of correct user input
                       correctInputPlayerA = true; //Reassign variable condition to end loop
                   }
               } while (!correctInputPlayerA); //Boolean check for continuing user prompt*/

               /* do {
                    System.out.println("Want to play again? [Y/N]"); //Prompt users to play game again or not
                    //userResponse = in.nextLine(); //User input assigned to boolean variable

                    if (userResponse.equalsIgnoreCase("Y")) //Convert user input to either case
                        {
                            stillPlaying = true; //Change of boolean variable from false because user chose Y or y
                        }
                    else if (userResponse.equalsIgnoreCase("N"))
                        {
                            stillPlaying = false;
                        }
                    else
                        {
                            trash = in.nextLine();
                            rightInput = false;
                            System.out.println(userResponse + " is an invalid answer. Want to play again? [Y/N]");
                        }
                    } while (!rightInput);*/
           }while (stillPlaying);


    }
}