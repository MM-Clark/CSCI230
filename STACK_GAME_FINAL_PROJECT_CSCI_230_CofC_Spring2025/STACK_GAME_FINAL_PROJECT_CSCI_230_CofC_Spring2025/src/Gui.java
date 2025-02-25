// Written by Julian Maiorino, Michelle Clark
// CSCI 230 Spring 2025
// College of Charleston 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui implements ActionListener
{
    private JButton start;
    private JFrame frame;
    private JPanel startScreen;
    private JRadioButton yes;
    private JRadioButton no;

    private StackArray<Block> stackTower;

    public Gui() // creates GUI initially
    {
        frame = new JFrame();
        frame.setTitle("Start Screen");
        frame.setSize(900, 900);

        getStartPanel();

        // frame.pack();                         // if this is taken out, must put back in set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void getStartPanel() // start Screen JPanel
    {
        startScreen = new JPanel();
        startScreen.setLayout(new BoxLayout(startScreen, BoxLayout.Y_AXIS)); // to make stuff align vertically
        startScreen.setBackground(Color.BLACK);

        //startScreen.add(Box.createVerticalGlue());        //-------> in case tries to get uncentered

        JLabel welcome = new JLabel("Welcome to Stack Jenga Horror Game!"); // this text can definitely be edited
        welcome.setForeground(Color.RED); // so can any colors used, these are just filler for now
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally

        startScreen.add(welcome);

        startScreen.add(Box.createVerticalStrut(30)); // Add vertical space

        start = new JButton("START");
        start.setPreferredSize(new Dimension(1200, 500));
        start.setBackground(Color.RED);
        start.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
        start.addActionListener(this);
        startScreen.add(start);

        //startScreen.add(Box.createVerticalGlue());    //---> in case tries to get uncentered
        frame.add(startScreen);
        frame.setVisible(true);
    }

    private void getGuessPanel() // for when user is stacking the tower
    {
        JPanel guess = new JPanel();
        guess.setBackground(Color.WHITE);
        startScreen.setLayout(new BoxLayout(startScreen, BoxLayout.Y_AXIS)); // to make stuff align vertically

        //-----------*********will need tweaking to improve*******--------------------
        int min = 5; // definitely needs adjustment
        int max = 10; // also needs adjustment
        int rangeRandom = min + (int)(Math.random() * ((max - min) + 1));
        int stackSize = rangeRandom;
        stackTower = new StackArray<Block>(stackSize);

        JLabel prompt = new JLabel("A random number has been assigned to you. Build the tower to the number.");
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
        guess.add(prompt);

        guess.add(Box.createVerticalStrut(30)); // Add vertical space

        JLabel continueTower = new JLabel("\nDo you want to keep building the tower?"); // will fix dialogue with int i + for loop later
        continueTower.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally --> THIS NEEDS TO BE FIXED
        guess.add(continueTower);

        guess.add(Box.createVerticalStrut(30)); // Add vertical space

        yes = new JRadioButton("Yes! Keep Going");
        yes.addActionListener(this);
        guess.add(yes);

        no = new JRadioButton("No. Stop.");
        no.addActionListener(this);
        guess.add(no);

        ButtonGroup yesNo = new ButtonGroup();
        yesNo.add(yes);
        yesNo.add(no);

        guess.add(yes);
        guess.add(no);

        JLabel selectionLabel = new JLabel("Selected: ");
        guess.add(selectionLabel);

        frame.setVisible(false);
        frame.remove(startScreen);
        frame.add(guess);

        // frame.pack();
        frame.setVisible(true);
    }

    public void yesAction()
    {
        Block newBlock = new Block(1, "filler");
        stackTower.push(newBlock);

        // System.out.println("YES SELECTED");                              // >> works
    }

    public void noAction()
    {


        // System.out.println("NO SELECTED");                               // >> works
    }

    @Override
    public void actionPerformed(ActionEvent e) // for making buttons do things
    {
        if(e.getSource() == start) // start screen start button
            getGuessPanel();
        else if(e.getSource() == yes) // game screen radio button to keep building tower
            yesAction();
        else if(e.getSource() == no) // game screen radio button to stop building tower
            noAction();
    }
}
