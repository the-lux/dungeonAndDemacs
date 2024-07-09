package application.view;

import application.controller.WinLoseListener;

import javax.swing.*;
import java.awt.*;

public class LosePanel extends GradientPanel{
    private JLabel jLabel;
    private TopButton retryButton;
    private TopButton backButton;
    private TopButton exitButton;
    public LosePanel(){
        jLabel = new javax.swing.JLabel();
        retryButton = new TopButton(0);
        backButton = new TopButton(1);
        exitButton = new TopButton(2);
        int border=2;

        jLabel.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel.setText(" Sei stato bocciato");
        jLabel.setForeground(Color.black);

        retryButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        retryButton.setText("RIPROVA");
        retryButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        backButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        backButton.setText("TORNA AL MENÚ");
        backButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        exitButton.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        exitButton.setText("ESCI");
        exitButton.setBorder(BorderFactory.createLineBorder(Color.black,border));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                                        .addComponent(retryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(43, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel)
                                .addGap(45, 45, 45)
                                .addComponent(retryButton)
                                .addGap(45, 45, 45)
                                .addComponent(backButton)
                                .addGap(45, 45, 45)
                                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(153, Short.MAX_VALUE))
        );
    }
    public void setController(WinLoseListener listener){
        exitButton.addActionListener(listener);
        backButton.addActionListener(listener);
        retryButton.addActionListener(listener);
    }
    }