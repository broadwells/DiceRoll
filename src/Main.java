//author: Stephanie Broadwell
//lab #5

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        Random randRoll = new Random();     //initializing the random object to ensure a new first number each time
        System.out.println("Welcome!");
        System.out.println("Please enter the number of sides of the dice: ");
        int diceNum = scan.nextInt();

        scan.nextLine();        //garbage scanner to empty out scanner for next input
        boolean play = true;
        while (play) {
            System.out.println("Place your bets! \nReady to roll the die? (y/n): ");
            String roll = scan.nextLine();

            if (roll.equalsIgnoreCase("n")) {
                System.out.println("Are you sure? (y/n): ");    //validating if the user meant to end the program
                roll = scan.nextLine();
                if (roll.equalsIgnoreCase("y")) {
                    System.out.println("Goodbye!");
                    play = false;
                }
                else {
                    play = true;
                }
            }
            else if (roll.equalsIgnoreCase("y")) {
                int randNum1 = rollDice(diceNum, randRoll);     //passing the user input and random Object
                int randNum2 = rollDice(diceNum, randRoll);     //to the rollDice method twice for 2 outputs
                System.out.println(randNum1);
                System.out.println(randNum2);
                winDice(randNum1, randNum2);        //passing the random numbers to winDice method
                System.out.println("Roll again? (y/n): ");
                roll = scan.nextLine();
                if (roll.equalsIgnoreCase("n")){        //validating the user entered y/n
                    System.out.println("Are you sure? (y/n): ");
                    roll = scan.nextLine();
                    if (roll.equalsIgnoreCase("y")) {
                        System.out.println("Goodbye!");
                        play = false;
                    }
                    else if (roll.equalsIgnoreCase("n")){
                        play = true;
                        System.out.println("Please enter the number of sides of the dice: ");
                        diceNum = scan.nextInt();
                        scan.nextLine();
                    }
                    else {
                        System.out.println("Oops! Something went wrong!");
                        play = false;
                    }
                }
                else if (roll.equalsIgnoreCase("y")){
                    play = true;
                    System.out.println("Please enter the number of sides of the dice: ");
                    diceNum = scan.nextInt();
                    scan.nextLine();
                }
                else {
                    System.out.println("Oops! Something went wrong!");
                    play = false;
                }

            }
            else {
                System.out.println("Oops! Something went wrong! Want to try again? (y/n): ");
                roll = scan.nextLine();
                if (roll.equalsIgnoreCase("n")){
                    System.out.println("Goodbye!");
                    play = false;
                }
                else {
                    play = true;
                }
            }
        }
    }

    public static int rollDice(int dice, Random randRoll) {     //method to generate the random numbers
        int i = randRoll.nextInt(dice) + 1;
        return i;
    }

    public static void winDice(int num1, int num2) {      //determine if the user wins snake eyes/craps/boxcars or loses
        if ((num1 + num2) == 1) {
            System.out.println("Snake eyes!");
        }
        else if ((num1 + num2) == 7 || (num1 + num2) == 11) {
            System.out.println("Craps!");
        }
        else if ((num1 + num2) == 12) {
            System.out.println("Boxcars!");
        }
        else {
            System.out.println("You lose!");
        }
    }
}
