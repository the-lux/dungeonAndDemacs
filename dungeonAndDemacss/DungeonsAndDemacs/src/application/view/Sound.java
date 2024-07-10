package application.view;

import javax.sound.sampled.*;
import java.io.IOException;

public class Sound{
    private AudioInputStream audioIn;
    private Clip clip;
    private String clipName;
    public Sound(String name) { //Riceve come parametro il nome di una risorsa .wav da riprodurre.
        try {
            audioIn = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("../resources/Soundtrack/" + name));
            clip = AudioSystem.getClip();
            clipName=name;
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {

            DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
            if (!AudioSystem.isLineSupported(info)) {
              System.out.println("Line not supported for format: " + audioIn.getFormat());
            }
            clip = null;
        }
    }
    public void loop() { //Riproduzione continua
        if (clip != null)
            clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void play() { //Riproduce il file
        if (clip != null) {
            if (clip.getFramePosition() == clip.getFrameLength())
                clip.setFramePosition(0);
            clip.start();
        }
    }
    public void pause() { //Interrompe la riproduzione
        if (clip != null)
            clip.stop();
    }
    public void reduceVolume() { //Abbassa il volume
        if (clip != null) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float value = gainControl.getValue();
            value -= 1.0f;
            if (value >= gainControl.getMinimum())
                gainControl.setValue(value);
        }
    }
    public void incrementVolume() { //Aumenta il volume
        if (clip != null) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float value = gainControl.getValue();
            value += 1.0f;
            if (value <= gainControl.getMaximum())
                gainControl.setValue(value);
        }
    }

    public String getClipName() {
        return clipName;
    }
    public void adjustAudio(int oldVal, int newVal){
        if (newVal<oldVal){
            for (int i=0; i<oldVal-newVal; i++){
                reduceVolume();
            }
        } else if (newVal> oldVal){
            for (int i=0; i<newVal-oldVal; i++){
                incrementVolume();
            }
        }
    }
} //Chiude la definizione della classe Sound

