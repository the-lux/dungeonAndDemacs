package application.controller;

import application.config.AudioSettings;
import application.config.Settings;
import application.model.CommandFileReader;
import application.model.Game;
import application.view.CharacterView;
import application.view.PanelManager;
import application.view.WorldPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Arrays;

public class CharacterListener extends KeyAdapter {
    private final WorldPanel worldPanel;
    private final CharacterView characterView;
    private final int[] commandKeyCode;
    public CharacterListener(WorldPanel wP,CharacterView cv){
        this.characterView=cv;
        this.worldPanel =wP;
        int [] temp = Settings.defaultCommand;//key code of order: W,S,A,D,UP,Down,Left,Right,Space
        /*CommandFileReader commandFileReader = new CommandFileReader();
        try {
            temp = commandFileReader.read();
        }catch (IOException e){
            e.printStackTrace();
        }*/
        commandKeyCode = temp;
        System.out.println(Arrays.toString(commandKeyCode));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==commandKeyCode[0]){
            Game.getGame().move(Game.MOVE_UP);
            characterView.updateDirection(0);
        } else if (e.getKeyCode()==commandKeyCode[1]) {
            Game.getGame().move(Game.MOVE_DOWN);
            characterView.updateDirection(4);
        } else if (e.getKeyCode()==commandKeyCode[2]) {
            Game.getGame().move(Game.MOVE_LEFT);
            characterView.updateDirection(6);
        } else if (e.getKeyCode()==commandKeyCode[3]) {
            Game.getGame().move(Game.MOVE_RIGHT);
            characterView.updateDirection(2);
        } else if (e.getKeyCode()==commandKeyCode[4]) {
            Game.getGame().updateFacing(Game.MOVE_UP);
        } else if (e.getKeyCode()==commandKeyCode[5]) {
            Game.getGame().updateFacing(Game.MOVE_DOWN);
        } else if (e.getKeyCode()==commandKeyCode[6]) {
            Game.getGame().updateFacing(Game.MOVE_LEFT);
        } else if (e.getKeyCode()==commandKeyCode[7]) {
            Game.getGame().updateFacing(Game.MOVE_RIGHT);
        } else if (e.getKeyCode()==commandKeyCode[8]) {
            Game.getGame().meleeAttack();
        } else if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
            PanelManager.getInstance().goMenu();
        }
        if (e.getKeyCode()==commandKeyCode[8]){
            worldPanel.sfxAttack();
        } else {
            worldPanel.sfxMovementChar();
        }
        /*if (e.getKeyCode() == KeyEvent.VK_W &&e.getKeyCode() == KeyEvent.VK_DOWN){
            System.out.println("prova");
        }
        switch(e.getKeyCode()) {
            case commandKeyCode[0]:
                Game.getGame().meleeAttack();
                break;
            case KeyEvent.VK_N:
                Game.restartGame();
                worldPanel.reset();
                break;
            case KeyEvent.VK_LEFT:
                Game.getGame().updateFacing(Game.MOVE_LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                Game.getGame().updateFacing(Game.MOVE_RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                Game.getGame().updateFacing(Game.MOVE_DOWN);
                break;
            case KeyEvent.VK_UP :
                Game.getGame().updateFacing(Game.MOVE_UP);
                break;
            case KeyEvent.VK_W:
                Game.getGame().move(Game.MOVE_UP);
                characterView.updateDirection(0);
                break;
            case KeyEvent.VK_D:
                Game.getGame().move(Game.MOVE_RIGHT);
                characterView.updateDirection(2);
                break;
            case KeyEvent.VK_S:
                Game.getGame().move(Game.MOVE_DOWN);
                characterView.updateDirection(4);
                break;
            case KeyEvent.VK_A:
                Game.getGame().move(Game.MOVE_LEFT);
                characterView.updateDirection(6);
                break;
        }
        /*prova = KeyEvent.getKeyText(e.getKeyCode());
        if(prova.equals(command[0])){//ahead
            Game.getGame().move(Game.MOVE_UP);
            characterView.updateDirection(0);
        } else if (prova.equals(command[1])) {//back

        }*/
        worldPanel.repaint();//sebbene sia chiamata in update, la chiamo anche qui per rendere più fluidi i movimenti
    }
    public void update(){
        Game.getGame().update(); //update logico dello stato del gioco
        worldPanel.update(); //update grafico
    }
}
