package com.mycompany.theorchestrathingitself;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class Buttons2 extends JPanel {
    private JButton exportButton, importButton;
    private ArrayList<Dot> dots;

    public Buttons2(ArrayList<Dot> dots) {
        this.dots = dots;
        exportButton = new JButton("Export");
        exportButton.addActionListener(new ExportButtonListener());
        add(exportButton);
        importButton = new JButton("Import");
        importButton.addActionListener(new ImportButtonListener());
        add(importButton);
    }

    private class ExportButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Export File");
            int returnVal = chooser.showSaveDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    FileWriter writer = new FileWriter(file);
                    for (Dot dot : dots) {
                        writer.write(dot.getX() + "," + dot.getY() + "\n");
                    }
                    writer.close();
                } catch (IOException ex) {
                    System.out.println("Error writing to file");
                }
            }
        }
    }

    private class ImportButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Import File");
            int returnVal = chooser.showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try {
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        String[] parts = line.split(",");
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        dots.add(new Dot(x, y));
                    }
                    scanner.close();
                } catch (IOException ex) {
                    System.out.println("Error reading from file");
                }
            }
        }
    }
}
