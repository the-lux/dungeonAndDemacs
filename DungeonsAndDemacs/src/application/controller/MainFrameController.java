package application.controller;

import model.MapGen;
import view.mainFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainFrameController {
    public MainFrameController(mainFrame f, MapGen m){
        f.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) {}
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    //f.removeAll();
                    f.getContentPane().removeAll();
                    f.setN(0);
                    f.newGen(m.genMap(10));
                    System.out.println(m.getRoot().toString());
                }
                if(e.getKeyCode() == KeyEvent.VK_P){//Se si preme p stampa il collegamento raw sulla consolle

                }
            }
        });
    }
}
