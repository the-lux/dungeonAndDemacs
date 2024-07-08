package application.view;

import javax.swing.*;
import java.awt.*;

public class ControlOptionPanel extends JPanel {
    private JToggleButton LeftMovButton3;
    private JLabel LeftMovLabel;
    private JLabel actionsLabel;
    private JToggleButton aheadButton;
    private JLabel aheadLabel;
    private JToggleButton attackButton;
    private JLabel attackLabel;
    private JToggleButton backButton;
    private JLabel backLabel;
    private JToggleButton belowButton;
    private JLabel belowLabel;
    private JButton exitButton;
    private JToggleButton itemButton1;
    private JToggleButton itemButton2;
    private JToggleButton itemButton3;
    private JToggleButton itemButton4;
    private JLabel itemLabel1;
    private JLabel itemLabel2;
    private JLabel itemLabel3;
    private JLabel itemLabel4;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private GradientPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JToggleButton leftLookButton;
    private JLabel leftLookLabel;
    private JLabel lookLabel;
    private JLabel movmentLabel;
    private JButton resetButton;
    private JToggleButton rightLookButton;
    private JLabel rightLookLabel;
    private JToggleButton rightMovButton4;
    private JLabel rightMovLabel;
    private JToggleButton runButton;
    private JLabel runLabel;
    private JToggleButton upButton;
    private JLabel upLabel;
    private Color foreGroundColor;
    private Color backGroundColor;
    public ControlOptionPanel() {
        jPanel2 = new GradientPanel();
        resetButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        jLabel1 = new JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new JPanel();
        movmentLabel = new JLabel();
        aheadLabel = new JLabel();
        aheadButton = new JToggleButton();
        backButton = new JToggleButton();
        backLabel = new JLabel();
        LeftMovLabel = new JLabel();
        LeftMovButton3 = new JToggleButton();
        rightMovLabel = new JLabel();
        rightMovButton4 = new JToggleButton();
        runLabel = new JLabel();
        runButton = new JToggleButton();
        lookLabel = new JLabel();
        upButton = new JToggleButton();
        upLabel = new JLabel();
        belowButton = new JToggleButton();
        belowLabel = new JLabel();
        leftLookButton = new JToggleButton();
        leftLookLabel = new JLabel();
        rightLookButton = new JToggleButton();
        rightLookLabel = new JLabel();
        actionsLabel = new JLabel();
        attackLabel = new JLabel();
        attackButton = new JToggleButton();
        itemLabel1 = new JLabel();
        itemButton1 = new JToggleButton();
        itemButton2 = new JToggleButton();
        itemLabel2 = new JLabel();
        itemButton3 = new JToggleButton();
        itemLabel3 = new JLabel();
        itemButton4 = new JToggleButton();
        itemLabel4 = new JLabel();
        foreGroundColor = new Color(0,0,0);
        backGroundColor= new Color(195, 195, 195);

        setMaximumSize(new java.awt.Dimension(600, 600));
        setMinimumSize(new java.awt.Dimension(600, 600));
        setName("Option"); // NOI18N
        setPreferredSize(new java.awt.Dimension(600, 600));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new Color(240,22,14));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));


        resetButton.setBackground(backGroundColor);
        resetButton.setForeground(foreGroundColor);
        resetButton.setFont(new java.awt.Font("Algerian", 0, 24));
        resetButton.setText("Ripristina");
        resetButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        resetButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        resetButton.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(resetButton);

        exitButton.setBackground(backGroundColor);
        exitButton.setForeground(foreGroundColor);
        exitButton.setFont(new java.awt.Font("Algerian", 0, 24));
        exitButton.setText("EXIT");
        exitButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        exitButton.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(exitButton);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Comandi");
        jLabel1.setToolTipText("");
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setColumnHeaderView(jLabel1);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setRequestFocusEnabled(false);

        jPanel1.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N

        movmentLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        movmentLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        movmentLabel.setText("Movimento");

        aheadLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        aheadLabel.setText("Avanti");
        aheadLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        aheadButton.setBackground(new java.awt.Color(153, 153, 153));
        aheadButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        aheadButton.setText("W");
        aheadButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        aheadButton.setPreferredSize(new java.awt.Dimension(200, 30));
        aheadButton.setBackground(backGroundColor);
        aheadButton.setForeground(foreGroundColor);

        backButton.setBackground(new java.awt.Color(153, 153, 153));
        backButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        backButton.setText("S");
        backButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        backButton.setPreferredSize(new java.awt.Dimension(30, 30));
        backButton.setBackground(backGroundColor);
        backButton.setForeground(foreGroundColor);

        backLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        backLabel.setText("Indietro");
        backLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        LeftMovLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        LeftMovLabel.setText("Sinistra");
        LeftMovLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        LeftMovButton3.setBackground(new java.awt.Color(153, 153, 153));
        LeftMovButton3.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        LeftMovButton3.setText("A");
        LeftMovButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        LeftMovButton3.setPreferredSize(new java.awt.Dimension(30, 30));
        LeftMovButton3.setBackground(backGroundColor);
        LeftMovButton3.setForeground(foreGroundColor);

        rightMovLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        rightMovLabel.setText("Destra");
        rightMovLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        rightMovButton4.setBackground(new java.awt.Color(153, 153, 153));
        rightMovButton4.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        rightMovButton4.setText("D");
        rightMovButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rightMovButton4.setPreferredSize(new java.awt.Dimension(30, 30));

        runLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        runLabel.setText("Corri");
        runLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        runButton.setBackground(new java.awt.Color(153, 153, 153));
        runButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        runButton.setText("left shift");
        runButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        runButton.setPreferredSize(new java.awt.Dimension(200, 30));

        lookLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        lookLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lookLabel.setText("Guarda");

        upButton.setBackground(new java.awt.Color(153, 153, 153));
        upButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        upButton.setText("arrow up");
        upButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        upButton.setPreferredSize(new java.awt.Dimension(200, 30));

        upLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        upLabel.setText("Su");
        upLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        belowButton.setBackground(new java.awt.Color(153, 153, 153));
        belowButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        belowButton.setText("arrow below");
        belowButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        belowButton.setPreferredSize(new java.awt.Dimension(30, 30));

        belowLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        belowLabel.setText("Giù");
        belowLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        leftLookButton.setBackground(new java.awt.Color(153, 153, 153));
        leftLookButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        leftLookButton.setText("arrow left");
        leftLookButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        leftLookButton.setPreferredSize(new java.awt.Dimension(30, 30));

        leftLookLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        leftLookLabel.setText("Sinistra");
        leftLookLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        rightLookButton.setBackground(new java.awt.Color(153, 153, 153));
        rightLookButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        rightLookButton.setText("arrow right");
        rightLookButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rightLookButton.setPreferredSize(new java.awt.Dimension(30, 30));

        rightLookLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        rightLookLabel.setText("Destra");
        rightLookLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        actionsLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        actionsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        actionsLabel.setText("Azioni");

        attackLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        attackLabel.setText("Attacca");
        attackLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        attackButton.setBackground(new java.awt.Color(153, 153, 153));
        attackButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        attackButton.setText("Spacebar");
        attackButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        attackButton.setPreferredSize(new java.awt.Dimension(30, 30));

        itemLabel1.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        itemLabel1.setText("Oggetto 1");
        itemLabel1.setPreferredSize(new java.awt.Dimension(86, 30));

        itemButton1.setBackground(new java.awt.Color(153, 153, 153));
        itemButton1.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        itemButton1.setText("1");
        itemButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        itemButton1.setPreferredSize(new java.awt.Dimension(30, 30));

        itemButton2.setBackground(new java.awt.Color(153, 153, 153));
        itemButton2.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        itemButton2.setText("2");
        itemButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        itemButton2.setPreferredSize(new java.awt.Dimension(30, 30));

        itemLabel2.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        itemLabel2.setText("Oggetto 2");
        itemLabel2.setPreferredSize(new java.awt.Dimension(86, 30));

        itemButton3.setBackground(new java.awt.Color(153, 153, 153));
        itemButton3.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        itemButton3.setText("3");
        itemButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        itemButton3.setPreferredSize(new java.awt.Dimension(30, 30));

        itemLabel3.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        itemLabel3.setText("Oggetto 3");
        itemLabel3.setPreferredSize(new java.awt.Dimension(86, 30));

        itemButton4.setBackground(new java.awt.Color(153, 153, 153));
        itemButton4.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        itemButton4.setText("4");
        itemButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        itemButton4.setPreferredSize(new java.awt.Dimension(30, 30));

        itemLabel4.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        itemLabel4.setText("Oggetto 4");
        itemLabel4.setPreferredSize(new java.awt.Dimension(86, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(129, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(movmentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lookLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(upLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(belowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(belowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(LeftMovLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rightMovLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                                        .addComponent(runLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(rightMovButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(LeftMovButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(runButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(aheadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(20, 20, 20)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(backButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(aheadButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(leftLookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(leftLookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(rightLookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(rightLookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addComponent(actionsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(attackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(attackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(itemButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(itemButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(itemButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(itemButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(movmentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(aheadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(aheadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LeftMovLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(LeftMovButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rightMovLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rightMovButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(runLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(runButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lookLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(upLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(belowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(belowButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(leftLookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(leftLookButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rightLookLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rightLookButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(actionsLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(attackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(attackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(itemButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, 0))
        );
        jScrollPane1.setViewportView(jPanel1);
        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        // Crea un oggetto GradientPaint per il gradiente verticale
        GradientPaint gp = new GradientPaint(0, 0, new Color(240,22,14), 0, height, Color.black);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
}
