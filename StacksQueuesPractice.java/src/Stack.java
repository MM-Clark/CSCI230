// Written by M.M.Clark 
// 2/6/2025
public class Stack 
{
    private int head;
    private int max;
    private char[] stack;
    private int DEFAULT_SIZE;

    public Stack(int s)
    {
        if(s<=0)
        {
            init(DEFAULT_SIZE);
            return;
        }
        init(s);
    }
    public void init(int s)
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

    public boolean isEmpty()
    {
        return head <= -1;
    }

    public boolean isFull()
    {
        return head >= max;
    }
}
