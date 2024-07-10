package application.controller;

import application.view.PanelManager;
import application.view.TopButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof TopButton topButton) {
            switch(topButton.getType()){
                case 0:
                    PanelManager.getInstance().goWorld();
                    break;
                case 1:
                    PanelManager.getInstance().goOption();
                    break;
                case 2:
                    PanelManager.getInstance().goCredit();
                    break;
                case 3:
                    PanelManager.getInstance().close();
                    break;
            }
        }
    }
}
