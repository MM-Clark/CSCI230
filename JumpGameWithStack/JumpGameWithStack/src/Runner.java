// Written by M.M. Clark
// 2/7/2025
import java.util.Scanner;

public class Runner {
    private Stack guessTower;
    private Stack actualTower;
    private Scanner keyboard = new Scanner(System.in);
    private int inputNum;
    private int guessNum;

    public void start()
    {
        guessTower = new Stack(-1);
        // for(int i=0; i<10; i++)
        //     tower.push('0');
        // tower.printTower();
        boolean run = true;
        welcome();
        while(run)
        {
            askForInput();
            int ending = build();
            // done with switch to make easier to expand to multiplayer functionality
            switch(ending)
            {
                case 1: 
                    oneWins();
                    break;
                case 2:
                    twoWins(); 
                    break;
                default: 
                    System.out.println("Something went wrong.");
            }
            run = playAgain();
        }
        endGame();
    }

    private void welcome()
    {
        System.out.println("Welcome to the stack tower game!");
        System.out.println("Directions: Get two players. \n1. Player One chooses a number unbeknownst to Player Two." +
            "\n2. Player Two will try to keep stacking the tower until it is as many blocks tall as Player Two's guessed number." 
            +"\n3. If Player Two is within two integers of the guess, Player two wins. Else, Player One wins.");
        System.out.println("\nGood luck!\n\n");
    }

    private void askForInput()
    {
        boolean inputted = false;
        while(!inputted)
        {
            System.out.println("PLAYER ONE: What number do you choose?");
            String inNum = keyboard.nextLine();
            try
            {
                inputNum = Integer.parseInt(inNum);
                inputted = true;
            } catch(NumberFormatException e)
            {
                System.out.println("Bad data entered. Enter a numerical integer.");
            }
            if(inputNum <= 0)
            {
                System.out.println("Bad data entered. Size must be greater than zero.");
                inputted = false;
            }
        }
        actualTower = new Stack(inputNum);
        char temp = '0';
        for(int i=0; i<inputNum; i++)
            actualTower.push(++temp);
        System.out.println("Data entered. Wiping the screen for Player Two.");

        // clear screen
        System.out.print("\033[H\033[2J"); // move pointer to left of screen
        System.out.flush(); // clear
    }

    // player two guessing and building tower loop
    private int build()
    {
        System.out.println("PLAYER TWO: Let's start guessing!");
        boolean over = false;
        guessNum = 0;
        char charInput = '0';
        while(!over)
        {
            System.out.println("Your current guess is " + guessNum + ". Guess one more?\nEnter y/n.");
            String in = keyboard.nextLine();
            if(in.equalsIgnoreCase("y")||in.contains("y"))
            {
                guessNum++;
                guessTower.push(++charInput);
                System.out.println("The growing tower: ");
                guessTower.printTower();
            }
            else
            {
                System.out.println("PLAYER TWO's final guess is " + guessNum);
                over = true;
            }
            if(guessNum > inputNum)
            {
                System.out.println("Oh no! You over shot it!");
                over = true;
            }
        }
        System.out.println("Guess num " + guessNum);
        System.out.println("Input num " + inputNum);

        int checker = inputNum - guessNum;
        if(checker <= 2 && checker >= 0)
            return 2;
        else
            return 1;
    }

    private void oneWins()
    {
        // pop stack sequence
        System.out.println("PLAYER TWO STACK REVEAL:");
        guessTower.emptyStack();
        System.out.println("PLAYER ONE STACK REVEAL: ");
        actualTower.emptyStack();

        System.out.println("------------Player One wins!--------");
    }

    private void twoWins()
    {
        System.out.println("Player Two wins!");
    }

    private boolean playAgain()
    {
        System.out.println("Play again? y/n");
        String input = keyboard.nextLine();
        if(input.equalsIgnoreCase("n"))
            return false;
        return true;
    }

    private void endGame()
    {

    }
}
