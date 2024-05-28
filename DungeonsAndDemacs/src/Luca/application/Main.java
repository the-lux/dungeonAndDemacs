package Luca.application;
import Luca.application.controller.MainFrameController;
import application.model.MapGen;
import Luca.application.view.*;

//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        MapGen m = new MapGen();
        m.genMap(10);
        mainFrame f = new mainFrame();
        f.newGen(m.getRoot());
        MainFrameController fC = new MainFrameController(f,m);

        f.setVisible(true);
    }
}
