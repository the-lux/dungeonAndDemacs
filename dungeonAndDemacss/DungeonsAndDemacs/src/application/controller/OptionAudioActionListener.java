package application.controller;

import application.view.PanelMenager;
import application.view.TopButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionAudioActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton jButton){
            PanelMenager.getInstance().goOption();
        }
    }
}
