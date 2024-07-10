package application.view;

import application.controller.OptionListener;

import javax.swing.*;
import java.awt.*;

public class optionPanel extends JPanel {
    private JLabel optionLabel;
    private TopButton audioButton;
    private TopButton controlButton;
    private TopButton exitButton;
    private TopButton tutorialButton;
    private final Color white;
    private final Color black;
    public optionPanel () {
        optionLabel = new JLabel();
        audioButton = new TopButton(0);
        controlButton = new TopButton(1);
        exitButton = new TopButton(4);
        tutorialButton = new TopButton(3);
        white = new Color(195, 195, 195);
        black = new Color(0,0,0);

        setMaximumSize(new Dimension(60, 600));
        setMinimumSize(new Dimension(600, 600));

        optionLabel.setFont(new Font("Algerian", 0, 70));
        optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        optionLabel.setText("Opzioni");
        optionLabel.setForeground(black);
        optionLabel.setBackground(white);

        audioButton.setBackground(new Color(153, 153, 153));
        audioButton.setFont(new Font("Algerian", 0, 48));
        audioButton.setText("AUDIO");
        audioButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        audioButton.setHorizontalTextPosition(SwingConstants.CENTER);
        audioButton.setFocusable(false);
        audioButton.setForeground(black);
        audioButton.setBackground(white);

        controlButton.setBackground(new Color(153, 153, 153));
        controlButton.setFont(new Font("Algerian", 0, 48));
        controlButton.setText("Controlli");
        controlButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        controlButton.setFocusable(false);
        controlButton.setHorizontalTextPosition(SwingConstants.CENTER);
        controlButton.setForeground(black);
        controlButton.setBackground(white);


        exitButton.setBackground(new Color(153, 153, 153));
        exitButton.setFont(new Font("Algerian", 0, 48));
        exitButton.setText("EXIT");
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
        exitButton.setFocusable(false);
        exitButton.setBackground(white);
        exitButton.setForeground(black);

        tutorialButton.setBackground(new Color(153, 153, 153));
        tutorialButton.setFont(new Font("Algerian", 0, 48)); // NOI18N
        tutorialButton.setText("Tutorial");
        tutorialButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        tutorialButton.setFocusable(false);
        tutorialButton.setHorizontalTextPosition(SwingConstants.CENTER);
        tutorialButton.setForeground(black);
        tutorialButton.setBackground(white);


        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(optionLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(30, 30, 30))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(audioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(controlButton, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                                        //.addComponent(videoButton, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                                        .addComponent(tutorialButton, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                                .addGap(90, 90, 90))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(186, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(optionLabel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(audioButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(controlButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                //.addComponent(videoButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tutorialButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
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
    public void setController(OptionListener optionListener){
        audioButton.addActionListener(optionListener);
        controlButton.addActionListener(optionListener);
        exitButton.addActionListener(optionListener);
        tutorialButton.addActionListener(optionListener);
    }
}
