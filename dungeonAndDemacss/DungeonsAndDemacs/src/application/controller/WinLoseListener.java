package application.controller;

import application.view.PanelManager;
import application.view.TopButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinLoseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof TopButton topButton) {
            switch (topButton.getType()) {
                case 0:
                    PanelManager.getInstance().goWord();
                    break;
                case 1:
                    PanelManager.getInstance().goMenu();
                    break;
                case 2:
                    PanelManager.getInstance().close();
                    break;
                case 3:
                    PanelManager.getInstance().goCredit();
                    break;
            }
        }
    }
}
