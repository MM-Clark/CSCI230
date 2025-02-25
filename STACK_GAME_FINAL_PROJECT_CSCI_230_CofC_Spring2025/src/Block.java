// Written by Julian Maiorino, Michelle Clark
// CSCI 230 Spring 2025
// College of Charleston 

public class Block 
{
    private int val; // maybe could have a rotation of 3-5 associated with each block, whichever is
                     // top of stack when player loses determines jumpscare img/sprite?
    private String data; // not sure about this field yet

    public Block() // not committed to constructor parameters yet
    {

    }

    public void setVal(int v)
    {
        val = v;
    }
    
    public int getVal()
    {
        return val;
    }

    public void setData(String d)
    {
        data = d;
    }

    public String getData()
    {
        return data;
    }
}
