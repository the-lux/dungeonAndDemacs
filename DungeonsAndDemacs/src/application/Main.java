package application;
import controller.MainFrameController;
import model.MapGen;
import view.*;

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
