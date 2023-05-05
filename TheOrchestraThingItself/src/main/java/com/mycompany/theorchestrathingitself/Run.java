package com.mycompany.theorchestrathingitself;

import javax.swing.JFrame;

public class Run {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Music Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Staff staff = new Staff(800, 600);
        Dot dot = new Dot(staff);
        Buttons buttons = new Buttons(dot);

        frame.add(staff);
        frame.add(dot);
        frame.add(buttons);

        frame.pack();
        frame.setVisible(true);
    }
}
