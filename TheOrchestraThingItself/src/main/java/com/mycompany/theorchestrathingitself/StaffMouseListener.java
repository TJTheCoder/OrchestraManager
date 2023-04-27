package com.mycompany.theorchestrathingitself;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StaffMouseListener extends MouseAdapter {

    private Staff staff;
    private int dotRadius;
    private int staffLineDistance;

    public StaffMouseListener(Staff staff, int dotRadius, int staffLineDistance) {
        this.staff = staff;
        this.dotRadius = dotRadius;
        this.staffLineDistance = staffLineDistance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();

        // calculate the closest staff line to the click point
        int staffLine = Math.round((float) (clickPoint.y - staff.getY()) / staffLineDistance);

        // make sure the click point is within the bounds of the staff
        if (staffLine >= 0 && staffLine <= 4) {
            // calculate the y-coordinate of the closest staff line
            int lineY = staff.getY() + staffLine * staffLineDistance;

            // calculate the x-coordinate of the closest staff line or space
            int lineX = Math.round((float) (clickPoint.x - staff.getX()) / staffLineDistance) * staffLineDistance + staff.getX();

            // make sure the click point is within the bounds of the staff
            if (lineX >= staff.getX() && lineX <= staff.getX() + staff.getWidth()) {
                // add a dot to the closest staff line or space
                staff.addDot(lineX, lineY, dotRadius);
                staff.repaint();
            }
        }
    }
}
