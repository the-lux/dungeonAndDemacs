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
                    PanelManager.getInstance().goOptionAudio();
                    break;
                case 1:
                    PanelManager.getInstance().goOptionControl();
                    break;
                case 2:
                    PanelManager.getInstance().goOptionVideo();
                    break;
                case 3:
                    PanelManager.getInstance().goOptionTutorial();
                    break;
                case 4:
                    PanelManager.getInstance().goMenu();
            }
        }
    }
}

