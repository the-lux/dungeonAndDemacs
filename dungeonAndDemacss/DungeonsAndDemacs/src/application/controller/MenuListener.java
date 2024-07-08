package application.controller;

import application.view.PanelMenager;
import application.view.TopButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MenuListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof TopButton topButton) {
            switch(topButton.getType()){
                case 0:
                    System.out.println("play");
                    PanelMenager.getInstance().goWord();
                    break;
                case 1:
                    System.out.println("option");
                    PanelMenager.getInstance().goOption();
                    break;
                case 2:
                    System.out.println("Credit");
                    PanelMenager.getInstance().goCredit();
                    break;
                case 3:
                    System.out.println("exit");
                    PanelMenager.getInstance().close();
                    break;
            }
        }
    }
}
