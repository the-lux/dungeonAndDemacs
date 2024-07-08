package application.controller;

import application.model.Game;
import application.model.Room;
import application.view.CharacterView;
import application.view.WorldPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterListener extends KeyAdapter {
    private final WorldPanel worldPanel;
    private final CharacterView characterView; //PROVA
    public CharacterListener(WorldPanel wP,CharacterView cv){
        this.characterView=cv;
        this.worldPanel =wP;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //if (e.getKeyCode() == KeyEvent.VK_W &&)
        switch(e.getKeyCode()) {
            case KeyEvent.VK_SPACE:
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
        worldPanel.repaint();//sebbene sia chiamata in update, la chiamo anche qui per rendere più fluidi i movimenti
    }
    public void update(){
        Game.getGame().update(); //update logico dello stato del gioco
        worldPanel.update(); //update grafico
    }
}
