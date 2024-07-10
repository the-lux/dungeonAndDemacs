package application.config;

public class Settings {
    public final static int WINDOW_SIZE = 600;
    public final static int WORLD_SIZE = 40;
    public final static int BLOCK_SIZE = WINDOW_SIZE / WORLD_SIZE; //15
    public final static int[] defaultCommand = {87,83,65,68,38,40,37,39,32};//key code of order: W,S,A,D,UP,Down,Left,Right,Space   EQUALS TO  ahead,back,leftMov,rightMov,up,below,leftLook,rightLook,attack
}