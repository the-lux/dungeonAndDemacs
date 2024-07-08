package application.controller;


import application.view.TopSlider;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionAudioChangeListener implements ChangeListener {


    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof TopSlider topSlider) {
            switch(topSlider.getType()){//todo da finire
                case 0: //generale
                    System.out.println("Il valore del JSlider generale è: " + topSlider.getValue());
                    break;
                case 1://musica
                    System.out.println("Il valore del JSlider musica è: " + topSlider.getValue());
                    break;
                case 2://effetti
                    System.out.println("Il valore del JSlider effetti è: " + topSlider.getValue());
                    break;
            }
        }
        JSlider source = (JSlider) e.getSource();
        int value = source.getValue();

    }
}
