// Written by M.M.Clark 
// 2/6/2025
import java.util.Scanner;

public class Runner 
{
    private String in;
    private String out;
    private Stack reverser;
    private Scanner keyboard = new Scanner(System.in);
    public void runStart()  
    {
        boolean run = true;
        while(run)
        {
            System.out.println("Welcome to the stack applications program!\nPlease enter the number of what you want to do (1/2/3).");
            System.out.println("1. Run word reverser with stack");
            System.out.println("2. Run parentheses checker with stack");
            System.out.println("3. Run word reverser without stack.");

            // this could be an int but can also stay string b/c using as option, not calculation
            String option = keyboard.nextLine();

            switch(option)
            {
                case "1":
                    runWordReverser();
                    break;
                case "2":
                    runParenthesesChecker();
                    break;
                case "3":
                    wordReverserNoStack();
                    break;
                default:
                    System.out.println("Bad input.");
            }
            
            System.out.println("Returned from shutting down program.\nWould you like to start another application?");
            System.out.println("Enter y/n");

            option = keyboard.nextLine();
            if(option.equalsIgnoreCase("n"))
                run = false;
        }
        // Shutdown procedure
        System.out.println("Shutting down. Goodnight.");
        keyboard.close();
    }

    // checks matching parentheses by pushing (, [, { to stack and checking matches to pop
    // if stack not empty or trying to return beyond empty, returns that parentheses are bad
    public void runParenthesesChecker()
    {
        boolean done = false;
        String ch;
        while(!done)
        {
            System.out.println("enter line to be checked");
            in = keyboard.nextLine();
            int lengthS = in.length(); 
            reverser = new Stack(lengthS);

            int badPos = -1;
            for(int i=0;i<lengthS;i++)
            {
                char temp = in.charAt(i);
                switch(temp)
                {
                    case '(':
                    case '[':
                    case '{':
                        reverser.push(temp);
                        break;

                    case ')': 
                    case '}': 
                    case ']':
                        char compare = reverser.peek();
                        if(temp==')' && compare=='('||temp==']' && compare=='['||temp=='}' && compare=='{')
                        reverser.pop();
                        else
                            badPos = i;
                        break;
                    default:
                }

                reverser.print();
            }
            
            if(badPos > -1)
                System.out.println("Bad parentheses at positon " + badPos + " which is a " + in.charAt(badPos));
            else
                System.out.println("Good to go.");

            System.out.println("run again? enter y/n");
            ch = keyboard.nextLine();
            if(ch.equalsIgnoreCase("n"))
                done = true;
        }
    }

    // uses char stack to reverse a string by pushing all chars to stack and popping/appending to word
    // does not corrupt original string in
    public void runWordReverser()
    {
        boolean done = false;
        String ch;
        while(!done)
        {
            System.out.println("Enter word to reverse");
            in = keyboard.nextLine();

            System.out.println("Reversing...");
            int lengthS = in.length();
            reverser = new Stack(lengthS);
            for(int i=0;i<lengthS;i++)
            {
                char temp = in.charAt(i);
                reverser.push(temp);
            }
        
            out = "";
            for(int i=0;i<lengthS;i++)
            {
                char outChar = reverser.pop();
                out += outChar;
            }
            System.out.println("Reversed word: " + out);

            System.out.println("Run again? Enter y/n");
            ch = keyboard.nextLine();
            if(ch.equalsIgnoreCase("n"))
                done = true;
        }
    }

    // reverses word using stringbuilder and switching chars progressively inward of arr, less intuitive but less steps than using stack for this
    // changes original string in to reversal
    public void wordReverserNoStack()
    {
        boolean run = true;
        String ch = " ";
        while(run)
        {
            System.out.println("Welcome to the word reverser\nEnter word to be reversed");
            in = keyboard.nextLine();
            int i = 0;
            int j = in.length()-1;
            while(i<j)
            {
                in = swap(i, j);
                i++;
                j--;
            }
            System.out.println("Finished! String reversed as: "+in+"\n");

            System.out.println("Run again? Enter y/n");
            ch = keyboard.nextLine();
            if(ch.equalsIgnoreCase("n"))
                run = false;
        }
    }

    public String swap(int i, int j)
    {
        StringBuilder temp = new StringBuilder(in);
        char c1 = in.charAt(i), c2 = in.charAt(j);
        temp.setCharAt(i, c2);
        temp.setCharAt(j, c1);
        return temp.toString();
    }
}
