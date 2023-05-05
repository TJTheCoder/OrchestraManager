package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Buttons extends JPanel {

    private static final int BUTTON_WIDTH = 80;
    private static final int BUTTON_HEIGHT = 40;
    private static final Color CLEAR_COLOR = Color.RED;
    private static final Color PLAY_COLOR = Color.GREEN;

    private JButton clearButton;
    private JButton playButton;
    private Dot dot;

    public Buttons(Dot dot) {
        this.dot = dot;
        setPreferredSize(new Dimension(dot.getWidth(), BUTTON_HEIGHT));
        clearButton = createButton("Clear", CLEAR_COLOR);
        playButton = createButton("Play", PLAY_COLOR);
        add(clearButton);
        add(playButton);

        clearButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dot.clearNotes();
            }
        });

        playButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playNotes();
            }
        });
    }

    private JButton createButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        return button;
    }

    private void playNotes() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int x = dot.getWidth() / 2;
                int startY = dot.getStaff().getHeight() / 2 - (Staff.NUM_LINES / 2) * Staff.VERTICAL_SPACING;
                int endY = startY + (Staff.NUM_LINES - 1) * Staff.VERTICAL_SPACING;

                for (int y = startY; y <= endY; y += Staff.VERTICAL_SPACING) {
                    Graphics g = dot.getGraphics();
                    g.setColor(Color.BLUE);
                    g.drawLine(x, y, x, y + Staff.VERTICAL_SPACING);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
