package application.controller;

import application.view.PanelManager;
import application.view.TopButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OptionControlListener implements ActionListener {
    String text;
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() instanceof TopButton topButton) {
            switch (topButton.getType()) {
                case -1://exit
                    PanelManager.getInstance().goOption();
                    break;
                case -2://reset
                    System.out.println("Testo cambiato in "+text);
                    break;
                default:
                    topButton.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyPressed(KeyEvent e) {
                            text = KeyEvent.getKeyText(e.getKeyCode());
                            topButton.setText(text);
                            topButton.removeKeyListener(this); // Rimuovi il KeyListener
                            System.out.println("Testo cambiato in "+text+" = ");
                            System.out.println(e.getKeyCode());
                        }
                    });
                    break;
            }
        }
    }
}
