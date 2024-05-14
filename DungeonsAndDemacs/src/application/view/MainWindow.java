package application.view;

import application.config.Settings;
import application.controller.EnemyListener;

import javax.swing.*;
import java.awt.*;

public class MainWindow {
    public static void launch(){
        JFrame f=new JFrame();
        f.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
        EnemyPanel enemyPanel=new EnemyPanel();
        f.add(enemyPanel);
        f.setUndecorated(true);
        enemyPanel.setFocusable(true);
        JOptionPane.showMessageDialog(f, "Press n to start a new game"+System.lineSeparator()+ "Press q to quit", "Istruzioni", JOptionPane.INFORMATION_MESSAGE);
        enemyPanel.addKeyListener(new EnemyListener(enemyPanel));
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
