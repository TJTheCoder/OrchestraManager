package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SheetMusicMaker extends JPanel {

    private static final int STAFF_WIDTH = 700;
    private static final int STAFF_HEIGHT = 200;
    private static final int NOTE_SIZE = 10;
    private static final int LINE_SPACING = 20;
    private static final int BUFFER_MARGIN = 50;

    private ArrayList<Point> notes = new ArrayList<Point>();
    private Staff staff;

    public SheetMusicMaker() {
        this.setPreferredSize(new Dimension(STAFF_WIDTH + 2 * BUFFER_MARGIN, STAFF_HEIGHT + 2 * BUFFER_MARGIN));
        this.addMouseListener(new NoteMouseListener());
        this.staff = new Staff(BUFFER_MARGIN, BUFFER_MARGIN + STAFF_HEIGHT / 2, STAFF_WIDTH, LINE_SPACING);
    }

    private class NoteMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Point notePosition = staff.getClosestNotePosition(e.getPoint());
            if (notePosition != null) {
                notes.add(notePosition);
                repaint();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        staff.draw(g);
        for (Point note : notes) {
            g.setColor(Color.BLACK);
            g.fillOval(note.x - NOTE_SIZE / 2, note.y - NOTE_SIZE / 2, NOTE_SIZE, NOTE_SIZE);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sheet Music Maker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new SheetMusicMaker());
        frame.pack();
        frame.setVisible(true);
    }

}
