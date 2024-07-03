package application.view;
import application.config.Settings;
import application.controller.CharacterListener;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        this.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        ControlOptionPanel m = new ControlOptionPanel();
        add(m);
        m.repaint();
        setUndecorated(true);
        m.setFocusable(true);
        //m.addKeyListener(new CharacterListener(m));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
