package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Staff extends JPanel {

    private static final int HORIZONTAL_SPACING = 20;
    public static final int VERTICAL_SPACING = 20;
    public static final int NUM_LINES = 5;
    private static final int LINE_THICKNESS = 2;
    private static final Color LINE_COLOR = Color.BLACK;

    private int width;
    private int height;

    public Staff(int width, int height) {
        this.width = width;
        this.height = height;
        setSize(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(LINE_COLOR);

        // Draw vertical staff lines
        g.drawLine(HORIZONTAL_SPACING, 0, HORIZONTAL_SPACING, height);
        g.drawLine(width - HORIZONTAL_SPACING, 0, width - HORIZONTAL_SPACING, height);

        // Draw horizontal staff lines
        int startY = height / 2 - (NUM_LINES / 2) * VERTICAL_SPACING;
        for (int i = 0; i < NUM_LINES; i++) {
            int y = startY + i * VERTICAL_SPACING;
            g.fillRect(HORIZONTAL_SPACING, y, width - 2 * HORIZONTAL_SPACING, LINE_THICKNESS);
        }
    }
}
