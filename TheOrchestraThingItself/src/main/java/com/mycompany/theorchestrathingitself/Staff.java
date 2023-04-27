package com.mycompany.theorchestrathingitself;

import java.awt.Graphics;
import javax.swing.JPanel;

public class Staff extends JPanel {

  private int width;
  private int height;

  public Staff(int width, int height) {
    this.width = width;
    this.height = height;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the vertical lines
    g.drawLine(50, 50, 50, height - 50);
    g.drawLine(width - 50, 50, width - 50, height - 50);

    // Draw the horizontal lines
    int space = (height - 100) / 4; // There should be 5 lines, so divide by 4
    for (int i = 0; i < 5; i++) {
      int y = 50 + i * space;
      g.drawLine(50, y, width - 50, y);
    }
  }

}
