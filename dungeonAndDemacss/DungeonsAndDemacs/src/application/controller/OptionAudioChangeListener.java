package application.controller;


import application.config.AudioSettings;
import application.view.PanelManager;
import application.view.TopSlider;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class OptionAudioChangeListener implements ChangeListener {
    int oldValue, newValue, oldGeneralValue;
    @Override
    public void stateChanged(ChangeEvent e) {
        if(e.getSource() instanceof TopSlider topSlider) {
            newValue=topSlider.getValue();
            switch(topSlider.getType()){
                case 0: //generale
                    //System.out.println("Il valore del JSlider generale è: " + topSlider.getValue());
                    oldGeneralValue= AudioSettings.getVolumeGenerale();
                    System.out.println("Il vecchio valore generale è" +oldGeneralValue);
                    System.out.println("Il valore in new value è: "+newValue);
                    AudioSettings.setVolumeGenerale(newValue);
                    System.out.println("Il nuovo valore generale è" +newValue);
                    System.out.println("Dunque, la differenza è" + (newValue-oldGeneralValue));
                    AudioSettings.increaseAllVolumes(newValue-oldGeneralValue);
                    PanelManager.getInstance().adjustAudio(0,AudioSettings.getVolumeMusica());
                    break;
                case 1://musica
                    //System.out.println("Il valore del JSlider musica è: " + topSlider.getValue());
                    oldValue= AudioSettings.getVolumeMusica();
                    AudioSettings.setVolumeMusica(newValue);
                    PanelManager.getInstance().adjustAudio(0,AudioSettings.getVolumeMusica());
                    break;
                case 2://effetti
                    //System.out.println("Il valore del JSlider effetti è: " + topSlider.getValue());
                    oldValue= AudioSettings.getVolumeEffetti();
                    AudioSettings.setVolumeEffetti(newValue);
                    break;
            }
             //dopo aver fatto le modifiche
            //mi assicuro che anche l'audio della schermata sia aggiornato
        }
        //JSlider source = (JSlider) e.getSource();
        //int value = source.getValue();

    }
}
