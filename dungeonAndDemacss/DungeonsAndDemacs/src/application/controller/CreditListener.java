package application.controller;


import application.view.CreditPanel;
import application.view.PanelManager;
import application.view.TopButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditListener implements ActionListener {

    public CreditListener(){}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton pressed){
            PanelManager.getInstance().goMenu();
        }
    }
}
