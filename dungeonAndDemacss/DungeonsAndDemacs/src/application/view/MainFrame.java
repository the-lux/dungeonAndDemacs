package application.view;
import application.config.Settings;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        this.setSize(Settings.WINDOW_SIZE, Settings.WINDOW_SIZE);
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        PanelMenager.getInstance().start(this);
        /*WorldPanel m = new WorldPanel();
        add(m);
        m.setFocusable(true);
        CharacterListener controller=new CharacterListener(m);
        m.addKeyListener(controller);*/
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
