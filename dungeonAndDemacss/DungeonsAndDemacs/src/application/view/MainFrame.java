package application.view;
import application.GameLoop;
import application.config.Settings;
import application.controller.CharacterListener;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        PanelMenager.getInstance().start(this);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
