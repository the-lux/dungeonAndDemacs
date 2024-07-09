package application.controller;

import application.view.PanelManager;
import application.view.TopButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof TopButton topButton) {
            switch(topButton.getType()){
                case 0:
                    System.out.println("audio");
                    PanelManager.getInstance().goOptionAudio();
                    break;
                case 1:
                    System.out.println("control");
                    PanelManager.getInstance().goOptionControl();
                    break;
                case 2:
                    System.out.println("video");
                    PanelManager.getInstance().goOptionVideo();
                    break;
                case 3:
                    System.out.println("language");
                    PanelManager.getInstance().goOptionLanguage();
                    break;
                case 4:
                    System.out.println("exit");
                    PanelManager.getInstance().goMenu();
            }
        }
    }
}

