package com.mycompany.theorchestrathingitself;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MusicSheetComponent extends JPanel implements PropertyChangeListener {

    private NoteSequence noteSequence;

    public MusicSheetComponent(NoteSequence noteSequence) {
        this.noteSequence = noteSequence;
        this.noteSequence.addNoteSequenceChangedListener(this);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            NoteSequence noteSequence = new NoteSequence(); // the model
            f.setLayout(new BorderLayout()); // how should the screen be layouted
            f.add(new MusicSheetComponent(noteSequence), BorderLayout.CENTER); // the sheet component is the view, it renders whatever the model
            // tells
            f.add(new JButton(new AbstractAction("Add Note") {
                @Override
                public void actionPerformed(ActionEvent e) {
                    noteSequence.addNote(new NoteSequence.Note((int) (Math.random() * 5)));   // add a note on a random line
                }
            }), BorderLayout.SOUTH);
            f.setSize(320, 240);
            f.setVisible(true);
        });
    }

    @Override
    protected void paintComponent(Graphics g2d) {
        super.paintComponent(g2d);
        Graphics2D g = (Graphics2D) g2d; // graphics2d has more functions
        int w = getWidth();
        int h = getHeight();
        int lines = 5;
        int spacing = h / lines;
        paintSheetBackground(g, w, h, spacing);
        drawNotes(g, spacing);
    }

    private void paintSheetBackground(Graphics2D g, int w, int h, int spacing) {
        g.setColor(Color.white);
        g.fillRect(0, 0, w, h);

        g.setColor(Color.black);
        for (int i = 0; i < 5; i++) {
            final int y2 = i * spacing;
            g.drawLine(0, y2, w, y2);
        }
    }

    private void drawNotes(Graphics2D g, int heigtSpacing) {
        int xSpacing = 30;
        int x = 0;
        for (NoteSequence.Note note : noteSequence.getNotes()) {
            int y = (int) (note.getLine() * heigtSpacing);
            g.fillOval(x, y - 3, 7, 6); // -3 because note should sit on line
            x += xSpacing;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (NoteSequence.PROP_NOTE_ADDED.equals(evt.getPropertyName()) || NoteSequence.PROP_NOTE_REMOVED.equals(evt.getPropertyName())) {
            repaint();
        }
    }
}
