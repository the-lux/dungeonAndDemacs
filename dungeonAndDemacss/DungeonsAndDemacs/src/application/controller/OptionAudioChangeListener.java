package application.controller;


import application.config.AudioSettings;
import application.view.PanelManager;
import application.view.TopSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionAudioChangeListener implements ChangeListener {
    int oldValue, newValue;
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof TopSlider topSlider) {
            switch(topSlider.getType()){

                case 1://musica
                    //System.out.println("Il valore del JSlider musica è: " + topSlider.getValue());
                    newValue=topSlider.getValue();
                    oldValue= AudioSettings.getVolumeMusica();
                    AudioSettings.setVolumeMusica(newValue);
                    PanelManager.getInstance().adjustAudio(oldValue,AudioSettings.getVolumeMusica());
                    break;
                case 2://effetti
                    //System.out.println("Il valore del JSlider effetti è: " + topSlider.getValue());
                    newValue=topSlider.getValue();
                    AudioSettings.setVolumeEffetti(newValue);
                    break;
            }
        }

    }
}
