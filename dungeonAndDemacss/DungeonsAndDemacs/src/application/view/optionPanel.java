package application.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class optionPanel extends JPanel {
    private JLabel optionLabel;
    private JButton audioButton;
    private JButton controlButton;
    private JButton videoButton;
    private JButton languageButton;
    private JButton exitButton;
    public optionPanel () {
        optionLabel = new JLabel();
        audioButton = new JButton();
        controlButton = new JButton();
        videoButton = new JButton();
        languageButton = new JButton();
        exitButton = new JButton();

        setMaximumSize(new Dimension(60, 600));
        setMinimumSize(new Dimension(600, 600));

        optionLabel.setFont(new Font("Algerian", 0, 70));
        optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        optionLabel.setText("Opzioni");
        optionLabel.setForeground(Color.BLACK);

        audioButton.setBackground(new Color(153, 153, 153));
        audioButton.setFont(new Font("Algerian", 0, 48));
        audioButton.setText("AUDIO");
        audioButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        audioButton.setHorizontalTextPosition(SwingConstants.CENTER);
        audioButton.setFocusable(false);
        audioButton.setForeground(Color.BLACK);

        controlButton.setBackground(new Color(153, 153, 153));
        controlButton.setFont(new Font("Algerian", 0, 48));
        controlButton.setText("Controlli");
        controlButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        controlButton.setFocusable(false);
        controlButton.setHorizontalTextPosition(SwingConstants.CENTER);
        controlButton.setForeground(Color.BLACK);


        videoButton.setBackground(new Color(153, 153, 153));
        videoButton.setFont(new Font("Algerian", 0, 48));
        videoButton.setText("EXIT");
        videoButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        videoButton.setHorizontalTextPosition(SwingConstants.CENTER);
        videoButton.setFocusable(false);
        videoButton.setForeground(Color.BLACK);


        languageButton.setBackground(new Color(153, 153, 153));
        languageButton.setFont(new Font("Algerian", 0, 48)); // NOI18N
        languageButton.setText("Video");
        languageButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        languageButton.setFocusable(false);
        languageButton.setHorizontalTextPosition(SwingConstants.CENTER);
        languageButton.setForeground(Color.BLACK);

        exitButton.setBackground(new Color(153, 153, 153));
        exitButton.setFont(new Font("Algerian", 0, 48)); // NOI18N
        exitButton.setText("Lingua");
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        exitButton.setFocusable(false);
        exitButton.setHorizontalTextPosition(SwingConstants.CENTER);
        exitButton.setForeground(Color.BLACK);


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
                                        .addComponent(languageButton, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                                        .addComponent(exitButton, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
                                .addGap(90, 90, 90))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(videoButton, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(languageButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(exitButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addComponent(videoButton, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
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
}
