package application.config;

public class AudioSettings {

    private static int volumeMusica=0, volumeEffetti=0; //0 perché è il valore iniziale dell'audio in Sound

    public static int getVolumeEffetti() {
        return volumeEffetti;
    }
    public static void setVolumeEffetti(int vol) {
        volumeEffetti = vol;
    }

    public static int getVolumeMusica() {
        return volumeMusica;
    }

    public static void setVolumeMusica(int vol) {
        volumeMusica = vol;
    }
}
