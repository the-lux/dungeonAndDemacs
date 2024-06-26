package application.controller;

import application.model.Game;
import application.view.WorldPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterListener extends KeyAdapter {
    private final WorldPanel worldPanel;
    public CharacterListener(WorldPanel eP){
        this.worldPanel =eP;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            System.out.println("Sto attaccando");
            Game.getGame().meleeAttack();
        }
        if(e.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);

        if(e.getKeyCode() == KeyEvent.VK_N) {
            Game.restartGame();
            worldPanel.reset();
            //enemyPanel.repaint(); superfluo perché in codice attuale la repaint viene SEMPRE chiamata alla fine
           //return;
        }

        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> Game.getGame().updateFacing(Game.MOVE_LEFT);
            case KeyEvent.VK_RIGHT -> Game.getGame().updateFacing(Game.MOVE_RIGHT);
            case KeyEvent.VK_DOWN -> Game.getGame().updateFacing(Game.MOVE_DOWN);
            case KeyEvent.VK_UP -> Game.getGame().updateFacing(Game.MOVE_UP);
        }

        switch(e.getKeyCode()){
            case KeyEvent.VK_W ->Game.getGame().move(Game.MOVE_UP);
            case KeyEvent.VK_A ->Game.getGame().move(Game.MOVE_LEFT);
            case KeyEvent.VK_S ->Game.getGame().move(Game.MOVE_DOWN);
            case KeyEvent.VK_D ->Game.getGame().move(Game.MOVE_RIGHT);
        }
        worldPanel.repaint();

    }
}
