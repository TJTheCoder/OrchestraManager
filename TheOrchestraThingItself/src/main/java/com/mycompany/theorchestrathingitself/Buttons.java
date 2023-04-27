package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

public class Buttons extends JPanel {

  private Rectangle clearButton;
  private Rectangle playButton;
  private boolean playClicked;
  private Staff staff;
  private Dot dot;

  public Buttons(Staff staff, Dot dot) {
    this.staff = staff;
    this.dot = dot;
    this.clearButton = new Rectangle(50, 20, 80, 40);
    this.playButton = new Rectangle(150, 20, 80, 40);
    this.playClicked = false;

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (clearButton.contains(x, y)) {
          dot.clearNotes();
        } else if (playButton.contains(x, y)) {
          playClicked = true;
          repaint();
        }
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw the buttons
    g.setColor(Color.BLACK);
    g.drawRect(clearButton.x, clearButton.y, clearButton.width, clearButton.height);
    g.drawString("Clear", clearButton.x + 20, clearButton.y + 25);

    g.drawRect(playButton.x, playButton.y, playButton.width, playButton.height);
    g.drawString("Play", playButton.x + 20, playButton.y + 25);

    // If the play button has been clicked, draw the vertical line
    if (playClicked) {
      g.setColor(Color.RED);
      int startX = staff.getX() + 50;
      int startY = staff.getY() + 10;
      int endY = staff.getY() + staff.getHeight() - 10;
      for (int x = startX; x < staff.getX() + staff.getWidth() - 50; x++) {
        g.drawLine(x, startY, x, endY);
        try {
          Thread.sleep(2);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
      playClicked = false;
    }
  }
}
