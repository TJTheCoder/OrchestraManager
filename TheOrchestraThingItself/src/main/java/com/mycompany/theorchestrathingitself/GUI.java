/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.theorchestrathingitself;
import java.time.Duration;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.event.ChangeListener;

/**
 *
 * @author atxbr
 */
public class GUI extends javax.swing.JFrame {
    private File directory;
    private File[] files;
    private ArrayList<File> songs;
    private int songNumber;
    private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
    private Timer timer;
    private TimerTask task;
    private boolean running;
    private Media media;
    private MediaPlayer mediaPlayer;
    
    /**
     * Creates new form GUI
     * @throws java.io.IOException
     */
    public GUI() throws IOException {
        initComponents();
        
        songs = new ArrayList<File>();
        directory = new File("media");
        files = directory.listFiles();
        if (files != null){
            for (File file : files){
                songs.add(file);
                System.out.println(file);
            }
        }
        
        
        BufferedImage pause = ImageIO.read(new File("images\\pause.png"));
        BufferedImage play = ImageIO.read(new File("images\\play.png"));
        
        BufferedImage img = ImageIO.read(new File("images\\cover.png"));
        Image img1 = img.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        coverShow_label.setIcon(new ImageIcon(img1));
        coverShow2_label.setIcon(new ImageIcon(img1));
        
//        Duration total = Media.getDuration();
//        progressBar_slider.setMax(total.toSeconds);
//        MediaPlayer.currentTimeProperty().addListener(new Change)
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabs = new javax.swing.JTabbedPane();
        shuffle_panel = new javax.swing.JPanel();
        playList_list = new java.awt.List();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        coverShow2_label = new javax.swing.JLabel();
        albumName2_label = new javax.swing.JLabel();
        player_panel = new javax.swing.JPanel();
        progressBar_slider = new javax.swing.JSlider();
        skipFor_button = new javax.swing.JButton();
        coverShow_label = new javax.swing.JLabel();
        skipBack_button = new javax.swing.JButton();
        pausePlay_button2 = new javax.swing.JButton();
        volume_slider = new javax.swing.JSlider();
        albumName_label = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        shuffle_panel.setBackground(new java.awt.Color(0, 51, 102));

        jButton1.setText("Play");

        jButton2.setText("Shuffle");

        albumName2_label.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        albumName2_label.setForeground(new java.awt.Color(255, 255, 255));
        albumName2_label.setText("Butter");

        javax.swing.GroupLayout shuffle_panelLayout = new javax.swing.GroupLayout(shuffle_panel);
        shuffle_panel.setLayout(shuffle_panelLayout);
        shuffle_panelLayout.setHorizontalGroup(
            shuffle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(shuffle_panelLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(shuffle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(shuffle_panelLayout.createSequentialGroup()
                        .addGroup(shuffle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(shuffle_panelLayout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(albumName2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(coverShow2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(playList_list, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        shuffle_panelLayout.setVerticalGroup(
            shuffle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(shuffle_panelLayout.createSequentialGroup()
                .addGroup(shuffle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(shuffle_panelLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(albumName2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addGroup(shuffle_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(38, 38, 38)
                        .addComponent(playList_list, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
                    .addGroup(shuffle_panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(coverShow2_label, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        tabs.addTab("Shuffle", shuffle_panel);

        player_panel.setBackground(new java.awt.Color(0, 51, 102));

        progressBar_slider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                progressBar_sliderMouseDragged(evt);
            }
        });
        progressBar_slider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                progressBar_sliderMousePressed(evt);
            }
        });

        skipFor_button.setText(">>>");
        skipFor_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipFor_buttonActionPerformed(evt);
            }
        });

        skipBack_button.setText("<<<");
        skipBack_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                skipBack_buttonActionPerformed(evt);
            }
        });

        pausePlay_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausePlay_button2ActionPerformed(evt);
            }
        });

        albumName_label.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        albumName_label.setForeground(new java.awt.Color(255, 255, 255));
        albumName_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        albumName_label.setText("Butter");

        javax.swing.GroupLayout player_panelLayout = new javax.swing.GroupLayout(player_panel);
        player_panel.setLayout(player_panelLayout);
        player_panelLayout.setHorizontalGroup(
            player_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(player_panelLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addGroup(player_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player_panelLayout.createSequentialGroup()
                        .addComponent(skipBack_button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pausePlay_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(skipFor_button, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(382, 382, 382))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player_panelLayout.createSequentialGroup()
                        .addComponent(volume_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player_panelLayout.createSequentialGroup()
                        .addComponent(progressBar_slider, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player_panelLayout.createSequentialGroup()
                        .addComponent(coverShow_label, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(337, 337, 337))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player_panelLayout.createSequentialGroup()
                        .addComponent(albumName_label, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(360, 360, 360))))
        );
        player_panelLayout.setVerticalGroup(
            player_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, player_panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(coverShow_label, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(albumName_label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progressBar_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(player_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(skipBack_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skipFor_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pausePlay_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(106, 106, 106)
                .addComponent(volume_slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        tabs.addTab("Player", player_panel);
        tabs.addTab("Composer", jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 1009, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void skipFor_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipFor_buttonActionPerformed
        //MediaPlayer.back();
        
    }//GEN-LAST:event_skipFor_buttonActionPerformed

    private void skipBack_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_skipBack_buttonActionPerformed
        //MediaPlayer.next();
    }//GEN-LAST:event_skipBack_buttonActionPerformed

    private void pausePlay_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausePlay_button2ActionPerformed
        Image img2 = pause.getScaledInstance(48, 36, Image.SCALE_SMOOTH);
        Image img3 = play.getScaledInstance(48, 36, Image.SCALE_SMOOTH);
        if (skipFor_button.getIcon().equals(img2)) {
            skipFor_button.setIcon(new ImageIcon(img3));
//            MediaPlayer.pause();
        } else {
//            MediaPlayer.play();
            skipFor_button.setIcon(new ImageIcon(img2));
        }
    }//GEN-LAST:event_pausePlay_button2ActionPerformed

    private void progressBar_sliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressBar_sliderMouseDragged
        MediaPlayer.seek(Duration.seconds(progressBar_slider.getValue()));
        
    }//GEN-LAST:event_progressBar_sliderMouseDragged

    private void progressBar_sliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_progressBar_sliderMousePressed
        MediaPlayer.seek(Duration.seconds(progressBar_slider.getValue()));
    }//GEN-LAST:event_progressBar_sliderMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUI().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel albumName2_label;
    private javax.swing.JLabel albumName_label;
    private javax.swing.JLabel coverShow2_label;
    private javax.swing.JLabel coverShow_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton pausePlay_button2;
    private java.awt.List playList_list;
    private javax.swing.JPanel player_panel;
    private javax.swing.JSlider progressBar_slider;
    private javax.swing.JPanel shuffle_panel;
    private javax.swing.JButton skipBack_button;
    private javax.swing.JButton skipFor_button;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JSlider volume_slider;
    // End of variables declaration//GEN-END:variables
}
