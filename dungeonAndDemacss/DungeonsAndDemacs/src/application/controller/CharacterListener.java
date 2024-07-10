package application.controller;

import application.config.Settings;

import application.model.Game;
import application.view.CharacterView;
import application.view.PanelManager;
import application.view.WorldPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterListener extends KeyAdapter {
    private final WorldPanel worldPanel;
    private final CharacterView characterView;
    private final int[] commandKeyCode;
    public CharacterListener(WorldPanel wP,CharacterView cv){
        this.characterView=cv;
        this.worldPanel =wP;
        //int [] temp = Settings.defaultCommand;//key code of order: W,S,A,D,UP,Down,Left,Right,Space
        //In qualsiasi modo non riesce a leggere il messaggio di testo o file di byte
        /*CommandFileReader commandFileReader = new CommandFileReader();
        try {
            temp = commandFileReader.read();
        }catch (IOException e){
            e.printStackTrace();
        }*/
        commandKeyCode = Settings.defaultCommand;
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
        worldPanel.repaint();//sebbene sia chiamata in update, la chiamo anche qui per rendere più fluidi i movimenti
    }
    public void update(){
        Game.getGame().update(); //update logico dello stato del gioco
        worldPanel.update(); //update grafico
    }
}
