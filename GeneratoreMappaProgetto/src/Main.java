import model.MapGen;
import view.*;
import controller.newMapSpaceBarr;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main {
    public static void main(String[] args) {
        MapGen m = new MapGen();
        m.genMap(10);
        mainFrame f = new mainFrame(m.getRoot());
        f.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    f.removeAll();
                    f.revalidate();
                    f.repaint();
                    f.newGen(m.genMap(10));
                    System.out.println(m.getRoot().toString());
                }

            }
        });

        f.setVisible(true);
    }
}
