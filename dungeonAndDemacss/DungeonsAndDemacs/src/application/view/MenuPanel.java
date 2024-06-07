package application.view;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    public MenuPanel() {
        setBackground(Color.WHITE);
        // Crea il titolo
        JLabel titleLabel = new JLabel("DUNGEONS & DEMACS");
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 24));
        add(titleLabel);
        // Crea i bottoni
        JButton giocaButton = createButton("GIOCA");
        add(giocaButton);

        JButton opzioniButton = createButton("OPZIONI");
        add(opzioniButton);

        JButton creditiButton = createButton("CREDITI");
        add(creditiButton);

        JButton exitButton = createButton("EXIT");
        add(exitButton);
    }
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Algerian", Font.BOLD, 16));
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        return button;
    }
}
