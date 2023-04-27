package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Staff extends JPanel {
    private static final int SPACING = 30;
    private static final int MARGIN = 50;
    private static final int LINE_THICKNESS = 2;
    private static final Color LINE_COLOR = Color.BLACK;
    private static final Color DOT_COLOR = Color.RED;

    private ArrayList<Point> dots = new ArrayList<Point>();

    public Staff() {
        setBackground(Color.WHITE);
        setPreferredSize(getPreferredSize());
        addMouseListener(new StaffMouseListener(this));
    }

    public void addDot(Point point) {
        int y = point.y - MARGIN - LINE_THICKNESS / 2;
        int line = y / SPACING;
        int remainder = y % SPACING;
        int x = point.x;

        if (line < 0 || line > 4) {
            return; // ignore dots above or below staff
        }

        if (remainder < SPACING / 2) {
            y = line * SPACING + MARGIN;
        } else {
            y = (line + 1) * SPACING + MARGIN;
        }

        dots.add(new Point(x, y));
        repaint();
    }

    public void clearDots() {
        dots.clear();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawStaff(g);
        drawDots(g);
    }

    private void drawStaff(Graphics g) {
        g.setColor(LINE_COLOR);
        int y = MARGIN;
        for (int i = 0; i < 5; i++) {
            g.fillRect(MARGIN, y, getWidth() - MARGIN * 2, LINE_THICKNESS);
            y += SPACING;
        }
    }

    private void drawDots(Graphics g) {
        g.setColor(DOT_COLOR);
        for (Point dot : dots) {
            g.fillOval(dot.x - 5, dot.y - 5, 10, 10);
        }
    }

    @Override
    public java.awt.Dimension getPreferredSize() {
        return new java.awt.Dimension(800, 200);
    }
}
