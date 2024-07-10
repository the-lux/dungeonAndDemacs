package application.view;

import application.controller.CreditListener;

import javax.swing.*;
import java.awt.*;

public class CreditPanel extends GradientPanel {
    private final JButton exitButton;
    private final JPanel buttonPanel;
    private final JScrollPane jScrollPane;
    private final JTextArea jTextArea;
    public CreditPanel(){
        buttonPanel = new GradientPanel();
        exitButton = new JButton();
        jScrollPane = new JScrollPane();
        jTextArea = new JTextArea();
        int buttonBorder=2;
        Color black=new Color(0,0,0);
        setLayout(new BorderLayout());

        exitButton.setFont(new Font("Algerian", 0, 48));
        exitButton.setText("EXIT");
        exitButton.setBorder(BorderFactory.createLineBorder(black, buttonBorder));

        GroupLayout jPanel1Layout = new GroupLayout(buttonPanel);
        buttonPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(20, 20, 20))
        );

        add(buttonPanel, BorderLayout.PAGE_END);

        jTextArea.setEditable(false);
        jTextArea.setBackground(Color.red);
        jTextArea.setForeground(Color.white);
        jTextArea.setFont(new Font("Times New Roman", 0, 24));
        jTextArea.setText("Realizzazione e logica: Romano Luca, Isabella Mariano Vincenzo, Perrelli Salvatore\nSprite: Perrelli Salvatore\nNemici: Isabella Mariano Vincenzo\nBoss: Isabella Mariano Vincenzo\nMenù: Romano Luca, Isabella Mariano Vincenzo\nGenerazione mappa: Romano Luca\nPower up: Isabella Mariano Vincenzo\nCaricamento audio: Isabella Mariano Vincenzo \nDesign delle stanze: Perrelli Salvatore\nCaricamento delle stanze: Perrelli Salvatore\nAutori delle tracce audio utilizzate:\n finalBoss->Dialga's Fight to the Finish: Remaster by Zame (https://www.youtube.com/channel/UCKKKbeAhjKYJfOy5Opg8lcQ)\n menu->Personality Test (Remastered) by Zame (https://www.youtube.com/channel/UCKKKbeAhjKYJfOy5Opg8lcQ)\n charWalk->Footstep_Dirt_02.wav by LittleRobotSoundFactory -- https://freesound.org/s/270413/ -- License: Attribution 4.0\n meleeAttack1-> Sword_Clash (43).wav by JohnBuhr -- https://freesound.org/s/326855/ -- License: Creative Commons 0\n win-> Jingle_Win_00.wav by LittleRobotSoundFactory -- https://freesound.org/s/270528/ -- License: Attribution 4.0\n lose-> Game Over Again.mp3 by Baltiyar13 -- https://freesound.org/s/564046/ -- License: Creative Commons 0\n powerUp-> Powerup03.wav by jeremysykes -- https://freesound.org/s/341240/ -- License: Creative Commons 0\n bossWalking-> Retro, Boss Step 02.wav by MATRIXXX_ -- https://freesound.org/s/441364/ -- License: Creative Commons 0\n meleeAttack2-> Hard Swing 1 by magnuswaker -- https://freesound.org/s/523230/ -- License: Creative Commons 0\n boss1-> Big bad boss by Victor_Natas -- https://freesound.org/s/613151/ -- License: Attribution 4.0 \n Room-B)Amp-Plains: Remastered by Zame (https://www.youtube.com/channel/UCKKKbeAhjKYJfOy5Opg8lcQ)\n Un ringraziamento speciale a Luca,Francesco e Roberta per il nome del gruppo");
        jScrollPane.setViewportView(jTextArea);
        add(jScrollPane, BorderLayout.CENTER);
    }
    public void setController(CreditListener cL){
        exitButton.addActionListener(cL);
    }
    }


