package application.view;
import application.GameLoop;
import application.config.Settings;
import application.controller.CharacterListener;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        this.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        WorldPanel m = new WorldPanel();
        add(m);
        setUndecorated(true);
        m.setFocusable(true);
        CharacterListener controller=new CharacterListener(m);
        m.addKeyListener(controller);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.startGame();
    }
}
