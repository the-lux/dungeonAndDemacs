package application.view;

import application.controller.OptionControlListener;

import javax.swing.*;
import java.awt.*;

public class ControlOptionPanel extends JPanel {
    private TopButton leftMovButton;
    private JLabel leftMovLabel;
    private JLabel actionsLabel;
    private TopButton aheadButton;
    private JLabel aheadLabel;
    private TopButton attackButton;
    private JLabel attackLabel;
    private TopButton backButton;
    private JLabel backLabel;
    private TopButton belowButton;
    private JLabel belowLabel;
    private TopButton exitButton;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private GradientPanel jPanel2;
    private JScrollPane jScrollPane1;
    private TopButton leftLookButton;
    private JLabel leftLookLabel;
    private JLabel lookLabel;
    private JLabel movmentLabel;
    private TopButton resetButton;
    private TopButton rightLookButton;
    private JLabel rightLookLabel;
    private TopButton rightMovButton;
    private JLabel rightMovLabel;
    private TopButton upButton;
    private JLabel upLabel;
    private Color foreGroundColor;
    private Color backGroundColor;
    public ControlOptionPanel() {
        jPanel2 = new GradientPanel();
        resetButton = new TopButton(-2);
        exitButton = new TopButton(-1);
        jLabel1 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jPanel1 = new JPanel();
        movmentLabel = new JLabel();
        aheadLabel = new JLabel();
        aheadButton = new TopButton(0);
        backButton = new TopButton(1);
        backLabel = new JLabel();
        leftMovLabel = new JLabel();
        leftMovButton = new TopButton(2);
        rightMovLabel = new JLabel();
        rightMovButton = new TopButton(3);
        lookLabel = new JLabel();
        upButton = new TopButton(5);
        upLabel = new JLabel();
        belowButton = new TopButton(6);
        belowLabel = new JLabel();
        leftLookButton = new TopButton(7);
        leftLookLabel = new JLabel();
        rightLookButton = new TopButton(8);
        rightLookLabel = new JLabel();
        actionsLabel = new JLabel();
        attackLabel = new JLabel();
        attackButton = new TopButton(9);
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
        jPanel2.setBackground(Color.red);


        resetButton.setBackground(backGroundColor);
        resetButton.setForeground(foreGroundColor);
        resetButton.setFont(new java.awt.Font("Algerian", 0, 24));
        resetButton.setText("Ripristina");
        resetButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        resetButton.setHorizontalTextPosition(SwingConstants.CENTER);
        resetButton.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(resetButton);

        exitButton.setBackground(backGroundColor);
        exitButton.setForeground(foreGroundColor);
        exitButton.setFont(new java.awt.Font("Algerian", 0, 24));
        exitButton.setText("EXIT");
        exitButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        exitButton.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel2.add(exitButton);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Comandi");
        jLabel1.setToolTipText("");
        jLabel1.setOpaque(true);
        jLabel1.setBackground(new Color(240,22,14));
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setColumnHeaderView(jLabel1);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setMaximumSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(600, 600));
        jScrollPane1.setRequestFocusEnabled(false);

        jPanel1.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N

        movmentLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        movmentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        movmentLabel.setText("Movimento");

        aheadLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        aheadLabel.setText("Avanti");
        aheadLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        aheadButton.setBackground(new java.awt.Color(153, 153, 153));
        aheadButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        aheadButton.setText("W");
        aheadButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        aheadButton.setPreferredSize(new java.awt.Dimension(200, 30));
        aheadButton.setBackground(backGroundColor);
        aheadButton.setForeground(foreGroundColor);

        backButton.setBackground(new java.awt.Color(153, 153, 153));
        backButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        backButton.setText("S");
        backButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        backButton.setPreferredSize(new java.awt.Dimension(30, 30));
        backButton.setBackground(backGroundColor);
        backButton.setForeground(foreGroundColor);

        backLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        backLabel.setText("Indietro");
        backLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        leftMovLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        leftMovLabel.setText("Sinistra");
        leftMovLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        leftMovButton.setBackground(new java.awt.Color(153, 153, 153));
        leftMovButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        leftMovButton.setText("A");
        leftMovButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        leftMovButton.setPreferredSize(new java.awt.Dimension(30, 30));
        leftMovButton.setBackground(backGroundColor);
        leftMovButton.setForeground(foreGroundColor);

        rightMovLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        rightMovLabel.setText("Destra");
        rightMovLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        rightMovButton.setBackground(new java.awt.Color(153, 153, 153));
        rightMovButton.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        rightMovButton.setText("D");
        rightMovButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rightMovButton.setPreferredSize(new java.awt.Dimension(30, 30));

        lookLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        lookLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lookLabel.setText("Guarda");

        upButton.setBackground(new java.awt.Color(153, 153, 153));
        upButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        upButton.setText("arrow up");
        upButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        upButton.setPreferredSize(new java.awt.Dimension(200, 30));

        upLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        upLabel.setText("Su");
        upLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        belowButton.setBackground(new java.awt.Color(153, 153, 153));
        belowButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        belowButton.setText("arrow below");
        belowButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        belowButton.setPreferredSize(new java.awt.Dimension(30, 30));

        belowLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        belowLabel.setText("Giù");
        belowLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        leftLookButton.setBackground(new java.awt.Color(153, 153, 153));
        leftLookButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        leftLookButton.setText("arrow left");
        leftLookButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        leftLookButton.setPreferredSize(new java.awt.Dimension(30, 30));

        leftLookLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        leftLookLabel.setText("Sinistra");
        leftLookLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        rightLookButton.setBackground(new java.awt.Color(153, 153, 153));
        rightLookButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        rightLookButton.setText("arrow right");
        rightLookButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        rightLookButton.setPreferredSize(new java.awt.Dimension(30, 30));

        rightLookLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        rightLookLabel.setText("Destra");
        rightLookLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        actionsLabel.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        actionsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        actionsLabel.setText("Azioni");

        attackLabel.setFont(new java.awt.Font("Algerian", 0, 24)); // NOI18N
        attackLabel.setText("Attacca");
        attackLabel.setPreferredSize(new java.awt.Dimension(86, 30));

        attackButton.setBackground(new java.awt.Color(153, 153, 153));
        attackButton.setFont(new java.awt.Font("Algerian", 0, 23)); // NOI18N
        attackButton.setText("Spacebar");
        attackButton.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        attackButton.setPreferredSize(new java.awt.Dimension(30, 30));

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
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                                .addComponent(upButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(belowLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(belowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(leftMovLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(rightMovLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(20, 20, 20)
                                                                .addComponent(rightMovButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(leftMovButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(aheadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(aheadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                .addComponent(attackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(24, 24, 24)
                                                .addComponent(attackButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(movmentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(aheadLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(aheadButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(leftMovLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(leftMovButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rightMovLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rightMovButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                .addContainerGap())
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
    public void setController(OptionControlListener oCL){
        resetButton.addActionListener(oCL);
        exitButton.addActionListener(oCL);
        aheadButton.addActionListener(oCL);
        backButton.addActionListener(oCL);
        leftMovButton.addActionListener(oCL);
        rightMovButton.addActionListener(oCL);
        upButton.addActionListener(oCL);
        belowButton.addActionListener(oCL);
        leftLookButton.addActionListener(oCL);
        rightLookButton.addActionListener(oCL);
        attackButton.addActionListener(oCL);
    }
}
