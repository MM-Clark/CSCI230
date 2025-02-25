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

    public Gui() // creates GUI initially
    {
        frame = new JFrame();
        frame.setTitle("Start Screen");
        // frame.setSize(900, 900);

        JPanel startScreen = getStartPanel();
        frame.add(startScreen);

        frame.pack();                         // if this is taken out, must put back in set size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel getStartPanel() // start Screen JPanel
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

        return startScreen;
    }

    private void getGuessPanel() // for when user is stacking the tower
    {
        JPanel guess = new JPanel();
        guess.setBackground(Color.WHITE);
        startScreen.setLayout(new BoxLayout(startScreen, BoxLayout.Y_AXIS)); // to make stuff align vertically

        JLabel prompt = new JLabel("A random number has been assigned to you. Build the tower to the number.");
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally
        guess.add(prompt);

        startScreen.add(Box.createVerticalStrut(30)); // Add vertical space

        JLabel continueTower = new JLabel("\nDo you want to keep building the tower?"); // will fix dialogue with int i + for loop later
        continueTower.setAlignmentX(Component.CENTER_ALIGNMENT); // Center horizontally --> THIS NEEDS TO BE FIXED
        guess.add(continueTower);

        frame.setVisible(false);
        frame.remove(startScreen);
        frame.add(guess);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == start)
            getGuessPanel();
    }
}
