package com.mycompany.theorchestrathingitself;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Dot extends JPanel {

    private static final int RADIUS = 10;
    private static final int LINE_LENGTH = 20;
    private static final Color DOT_COLOR = Color.BLACK;
    private static final Color LINE_COLOR = Color.BLACK;
    private static final int MAX_DISTANCE = 15;

    private Staff staff;
    private List<Point> notes = new ArrayList<>();

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Point> getNotes() {
        return notes;
    }

    public void setNotes(List<Point> notes) {
        this.notes = notes;
    }

    public void clearNotes() {
        notes.clear();
        repaint();
    }

    public Dot(Staff staff) {
        this.staff = staff;
        setSize(staff.getSize());
        staff.addMouseListener(new StaffMouseListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(DOT_COLOR);

        for (Point note : notes) {
            int x = note.x - RADIUS;
            int y = note.y - RADIUS;
            g.drawOval(x, y, 2 * RADIUS, 2 * RADIUS);

            int lineY = findClosestLineY(note.y);
            g.setColor(LINE_COLOR);
            g.drawLine(staff.getWidth() / 2, lineY, staff.getWidth() / 2 + LINE_LENGTH, lineY);
            g.setColor(DOT_COLOR);
        }
    }

    private int findClosestLineY(int y) {
        int startY = staff.getHeight() / 2 - (Staff.NUM_LINES / 2) * Staff.VERTICAL_SPACING;
        int closestLineY = startY;

        for (int i = 0; i < Staff.NUM_LINES; i++) {
            int lineY = startY + i * Staff.VERTICAL_SPACING;
            if (Math.abs(lineY - y) < Math.abs(closestLineY - y)) {
                closestLineY = lineY;
            }
        }

        return closestLineY;
    }

    private class StaffMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            if (Math.abs(x - staff.getWidth() / 2) < MAX_DISTANCE && y > 0 && y < staff.getHeight()) {
                notes.add(new Point(x, y));
                repaint();
            }
        }
    }
}
