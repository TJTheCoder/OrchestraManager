package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Dot extends JPanel {

  private Staff staff;
  private ArrayList<Point> notes;

  public Dot(Staff staff) {
    this.staff = staff;
    this.notes = new ArrayList<>();

    this.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int space = (staff.getHeight() - 100) / 4;
        int staffY = staff.getY() + 50;

        // Snap the note to the nearest staff line
        int line = (int) Math.round((y - staffY) / (double) space);
        int noteY = staffY + line * space;

        // Add the note to the list
        notes.add(new Point(x, noteY));
        repaint();
      }
    });
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    // Draw each note as a quarter note
    g.setColor(Color.BLACK);
    for (Point note : notes) {
      int x = note.x;
      int y = note.y;
      g.drawOval(x, y, 30, 30);
      g.drawLine(x + 30, y + 15, x + 30, y - 15);
    }
  }

  public void clearNotes() {
    notes.clear();
    repaint();
  }

  public ArrayList<Point> getNotes() {
    return notes;
  }

}
