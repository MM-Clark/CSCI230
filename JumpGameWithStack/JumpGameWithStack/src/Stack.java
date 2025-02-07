// Written by M.M.Clark 
// 2/6/2025

public class Stack 
{
    private int head;
    private int max;
    private char[] stack;
    private final int DEFAULT_SIZE = 100;
    private String block = "[ ]";
    private String fire = "(._.)";

    public Stack(int s)
    {
        if(s<=0)
        {
            init(DEFAULT_SIZE);
            return;
        }
        init(s);
    }

    private void init(int s)
    {
        max = s;
        stack = new char[max];
        head = -1;
    }

    public void push(char in)
    {
        if(!isFull())
        {
            stack[++head] = in;
        }
        else
        {
            System.out.println("Stack Full");
        }
    }

    public char pop()
    {
        if(!isEmpty())
        {
            return stack[head--];
        }
        else
        {
            System.out.println("Stack empty");
            return ' ';
        }
    }

    public char peek()
    {
        if(!isEmpty())
            return stack[head];
        else
        {
            System.out.println("Stack empty");
            return ' ';
        }
    }

    public void print()
    {
        for(int i=head; i>-1;i--)
            System.out.print(stack[i]+" ");
        System.out.println();
    }

    public void printTower()
    {
        for(int i=head; i>-1; i--)
        {
            for(int k=0; k<4; k++)
            {
                System.out.print(block + " " + stack[i] + " " + block);
            }
            System.out.println();
        }
    }

    public void emptyStack()
    {
        for(int i=head; i>-1; i--)
        {
            pop();
            for(int k=0; k<i; k++)
            {
                System.out.print(fire + " " + stack[i] + " " + fire);
            }
            System.out.println("\n");
        }
    }

    public boolean isEmpty()
    {
        return head <= -1;
    }

    public boolean isFull()
    {
        return head >= max;
    }
}
