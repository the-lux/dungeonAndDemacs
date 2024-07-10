package application.view;

import application.controller.CreditListener;

import javax.swing.*;
import java.awt.*;

public class TutorialPanel extends  GradientPanel{
    private final JButton exitButton;
    private final JPanel buttonPanel;
    private final JScrollPane jScrollPane;
    private final JTextArea jTextArea;
    public TutorialPanel(){
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
        jTextArea.setText("L'obbiettivo è quello di laurearsi ovvero:\n Sconfiggere tutti i nemici nelle stanze (associazioni, e torpedine) per poi sconfigere i boss (professori).\n  GPT +danno, Tessera Associazione ti da lo scudo, Sigaretta sei invisibile, caffè ti da + vita\n  Comandi movimento: W,S,A,D\n  Comandi visione con le frecce:UP,Down,Left,Right\n  Attacco(nella direzione della visione): Space.");
        jScrollPane.setViewportView(jTextArea);
        add(jScrollPane, BorderLayout.CENTER);
    }
    public void setController(CreditListener cL){
        exitButton.addActionListener(cL);
    }
}
