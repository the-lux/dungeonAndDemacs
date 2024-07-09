package application.view;

import application.controller.WinLoseListener;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends GradientPanel {
    private JLabel jLabel;
    private TopButton retryButton;
    private TopButton exitButton;
    private TopButton menuButton;
    private TopButton creditButton;
    public WinPanel (){
        jLabel = new javax.swing.JLabel();
        retryButton = new TopButton(0);
        exitButton = new TopButton(2);
        menuButton = new TopButton(1);
        creditButton = new TopButton(3);
        int border=2;

        jLabel.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel.setText("TI SEI LAUREATO!");
        jLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel.setForeground(Color.BLACK);

        retryButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        retryButton.setText("Gioca di nuovo");
        retryButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        exitButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        exitButton.setText("Esci");
        exitButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        menuButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        menuButton.setText("Torna al menÚ");
        menuButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        creditButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        creditButton.setText("Crediti");
        creditButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                                        .addComponent(retryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(menuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(creditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(retryButton)
                                .addGap(45, 45, 45)
                                .addComponent(menuButton)
                                .addGap(45, 45, 45)
                                .addComponent(creditButton)
                                .addGap(45, 45, 45)
                                .addComponent(exitButton)
                                .addContainerGap(14, Short.MAX_VALUE))
        );
    }
    public void setController(WinLoseListener listener){
        creditButton.addActionListener(listener);
        exitButton.addActionListener(listener);
        menuButton.addActionListener(listener);
        retryButton.addActionListener(listener);
    }
}
