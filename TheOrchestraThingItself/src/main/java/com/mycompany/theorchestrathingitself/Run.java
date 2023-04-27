package com.mycompany.theorchestrathingitself;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Run {

  public static void main(String[] args) {
    JFrame frame = new JFrame("The Orchestra Thing Itself");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Create the staff and dot panels
    Staff staff = new Staff(800, 400);
    Dot dot = new Dot(staff);

    // Add the staff and dot panels to the frame
    frame.add(staff, BorderLayout.CENTER);
    frame.add(dot, BorderLayout.CENTER);

    // Pack and display the frame
    frame.pack();
    frame.setVisible(true);
  }

}
