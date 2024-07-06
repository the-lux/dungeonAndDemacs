package application.view;

import application.config.Settings;
import application.controller.MenuListener;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private TopButton playButton;
    private TopButton optionButton;
    private TopButton creditButton;
    private TopButton exitButton;
    private JLabel titleLabel;
    private Color gray;
    private Color black;
    public MenuPanel() {
        playButton = new TopButton(0);
        optionButton = new TopButton(1);
        creditButton = new TopButton(2);
        exitButton = new TopButton(3);
        titleLabel = new JLabel();
        gray = new Color(195, 195, 195);
        black = new Color(0,0,0);
        int buttonBorder = 3;

        setFont(new Font("Algerian", 0, 10));
        setName("Dugeon&Demacs");
        setSize(new Dimension(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE));

        this.setFont(new Font("Algerian", 0, 12));
        this.setMaximumSize(new Dimension(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE));
        this.setMinimumSize(new Dimension(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE));
        this.setPreferredSize(new Dimension(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE));

        playButton.setFont(new Font("Algerian", 0, 48));
        playButton.setText("Gioca");
        playButton.setBorder(BorderFactory.createLineBorder(black, buttonBorder));
        playButton.setBackground(gray);
        playButton.setForeground(black);

        optionButton.setFont(new Font("Algerian", 0, 36));
        optionButton.setText("Opzioni");
        optionButton.setBorder(BorderFactory.createLineBorder(black, buttonBorder));
        optionButton.setBackground(gray);
        optionButton.setForeground(black);

        creditButton.setFont(new Font("Algerian", 0, 36));
        creditButton.setText("Crediti");
        creditButton.setBorder(BorderFactory.createLineBorder(black, buttonBorder));
        creditButton.setBackground(gray);
        creditButton.setForeground(black);

        exitButton.setFont(new Font("Algerian", 0, 36));
        exitButton.setText("Exit");
        exitButton.setBorder(BorderFactory.createLineBorder(black, buttonBorder));
        exitButton.setBackground(gray);
        exitButton.setForeground(black);


        titleLabel.setFont(new Font("Algerian", 0, 60));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setLabelFor(this);
        titleLabel.setText("Dungeon&Demacs");
        titleLabel.setForeground(black);

        GroupLayout jPanelLayout = new GroupLayout(this);
        this.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(titleLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(playButton, GroupLayout.PREFERRED_SIZE, 541, GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30))
                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanelLayout.createSequentialGroup()
                                                                .addGap(6, 6, 6)
                                                                .addComponent(creditButton, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(optionButton, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(titleLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(optionButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(creditButton)
                                        .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(179, Short.MAX_VALUE))
        );
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        // Crea un oggetto GradientPaint per il gradiente verticale
        GradientPaint gp = new GradientPaint(0, 0, new Color(240,22,14), 0, height, black);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
    public void setController(MenuListener menuListener){
        playButton.addActionListener(menuListener);
        optionButton.addActionListener(menuListener);
        creditButton.addActionListener(menuListener);
        exitButton.addActionListener(menuListener);
    }
}
