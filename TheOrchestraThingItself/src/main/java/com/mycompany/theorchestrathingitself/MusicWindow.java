package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MusicWindow extends JFrame {

    private ArrayList<Note> notes = new ArrayList<Note>();
    private StaffPanel staffPanel;
    private JLabel noteLabel;

    public MusicWindow() {
        setTitle("Music Window");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        staffPanel = new StaffPanel();
        add(staffPanel);

        noteLabel = new JLabel();
        noteLabel.setHorizontalAlignment(JLabel.CENTER);
        add(noteLabel, "South");

        staffPanel.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                int line = staffPanel.getNearestLine(e.getX(), e.getY());
                if (line != -1) {
                    notes.add(new Note(line));
                    staffPanel.repaint();
                    updateNoteLabel();
                }
            }
        });

        setVisible(true);
    }

    private void updateNoteLabel() {
        String text = "";
        for (Note note : notes) {
            text += note.toString() + " ";
        }
        noteLabel.setText(text);
    }

    private class StaffPanel extends JPanel {

        private final int TOP_MARGIN = 20;
        private final int BOTTOM_MARGIN = 20;
        private final int LEFT_MARGIN = 20;
        private final int RIGHT_MARGIN = 20;
        private final int LINE_SPACING = 10;
        private final int NUM_LINES = 5;
        private final int LINE_THICKNESS = 2;
        private final int NOTE_RADIUS = 10;
        private final int NOTE_SPACING = 5;
        private final int NOTE_OFFSET = 5;

        public StaffPanel() {
            setPreferredSize(new java.awt.Dimension(800, 600));
            setBackground(Color.WHITE);
        }

        public int getNearestLine(int x, int y) {
            if (x < LEFT_MARGIN || x > getWidth() - RIGHT_MARGIN) {
                return -1;
            }
            int line = (int) Math.round((double) (y - TOP_MARGIN) / LINE_SPACING);
            if (line < 0 || line >= NUM_LINES) {
                return -1;
            }
            return line;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int staffWidth = getWidth() - LEFT_MARGIN - RIGHT_MARGIN;
            int staffHeight = NUM_LINES * LINE_SPACING;
            int staffX = LEFT_MARGIN;
            int staffY = (getHeight() - staffHeight) / 2;

            g.setColor(Color.BLACK);
            g.fillRect(staffX, staffY, staffWidth, LINE_THICKNESS);
            g.fillRect(staffX, staffY + staffHeight - LINE_THICKNESS, staffWidth, LINE_THICKNESS);
            for (int i = 0; i < NUM_LINES; i++) {
                int lineY = staffY + i * LINE_SPACING;
                g.fillRect(staffX, lineY, LEFT_MARGIN - NOTE_OFFSET, LINE_THICKNESS);
                g.fillRect(staffX + staffWidth + NOTE_OFFSET, lineY, RIGHT_MARGIN - NOTE_OFFSET, LINE_THICKNESS);
                for (Note note : notes) {
                    if (note.getLine() == i) {
                        int noteX = staffX + LEFT_MARGIN + (note.getPosition() * (NOTE_RADIUS * 2 + NOTE_SPACING));
                        int noteY = lineY - NOTE_RADIUS;
                        g.setColor(Color.BLACK);
                        g.fillOval(noteX, noteY, NOTE_RADIUS * 2, NOTE_RADIUS * 2);
                        g.fillRect(noteX + NOTE_RADIUS * 2, noteY + NOTE_RADIUS - LINE_THICKNESS / 2, NOTE_SPACING, LINE_THICKNESS);
                    }
                }
            }
        }
    }

    private class Note {

        private int line;
        private int position;

        public Note(int line) {
            this.line = line;
            position = 0;
            for (Note note : notes) {
                if (note.getLine() == line && note.getPosition() >= position) {
                    position = note.getPosition() + 1;
                }
            }
        }

        public int getLine() {
            return line;
        }

        public int getPosition() {
            return position;
        }

        public String toString() {
            String[] pitches = {"C", "D", "E", "F", "G", "A", "B"};
            return pitches[position % pitches.length] + (position / pitches.length);
        }
    }

    public static void main(String[] args) {
        new MusicWindow();
    }
}
