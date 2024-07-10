package application.config;

public class AudioSettings {

    private static int volumeGenerale=0, volumeMusica=0, volumeEffetti=0; //0 perché è il valore iniziale dell'audio in Sound

    public static int getVolumeGenerale() {
        return volumeGenerale;
    }


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
    public static void increaseVolumes(int increase){
        volumeMusica+=increase;
        volumeEffetti+=increase;
    }
}
