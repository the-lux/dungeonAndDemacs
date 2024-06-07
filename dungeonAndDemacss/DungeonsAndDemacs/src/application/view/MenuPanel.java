package application.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        this.setLayout(new GridLayout(4, 1, 10, 10));
        Font algerianFont = new Font("Algerian", Font.BOLD, 18);
        JLabel titleLabel = new JLabel("DUNGEONS & DEMACS", SwingConstants.CENTER);
        titleLabel.setFont(algerianFont);
        this.add(titleLabel);
        JButton playButton = new JButton("GIOCA");
        playButton.setFont(algerianFont);
        this.add(playButton);
        JButton optionsButton = new JButton("OPZIONI");
        optionsButton.setFont(algerianFont);
        this.add(optionsButton);
        JPanel creditPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton creditButton = new JButton("CREDITI");
        creditButton.setFont(algerianFont);
        creditPanel.add(creditButton);
        JButton exitButton = new JButton("EXIT");
        exitButton.setFont(algerianFont);
        creditPanel.add(exitButton);
        this.add(creditPanel);
        /*setBackground(Color.WHITE);
        // Crea il titolo
        JLabel titleLabel = new JLabel("DUNGEONS & DEMACS");
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 24));
        add(titleLabel);
        //Setta il Layout a righe sx to dx
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // Crea i bottoni
        JButton giocaButton = createButton("GIOCA");
        giocaButton.setPreferredSize(new Dimension(100,40));
        add(giocaButton);

        JButton opzioniButton = createButton("OPZIONI");
        add(opzioniButton);

        JButton creditiButton = createButton("CREDITI");
        add(creditiButton);

        JButton exitButton = createButton("EXIT");
        add(exitButton);*/
    }
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Algerian", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//        button.setContentAreaFilled(true);
//        button.setFocusPainted(false);
//        button.setBackground(Color.WHITE);
//        button.setForeground(Color.BLACK);
        return button;
    }
}
