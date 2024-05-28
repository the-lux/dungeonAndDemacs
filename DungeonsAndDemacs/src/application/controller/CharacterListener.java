package application.controller;

import application.model.Game;
import application.view.EnemyPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CharacterListener extends KeyAdapter {
    private final EnemyPanel enemyPanel;
    public CharacterListener(EnemyPanel eP){
        this.enemyPanel=eP;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_A){
            Game.getGame().meleeAttack();
        }
        if(e.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);

        if(e.getKeyCode() == KeyEvent.VK_N) {
            Game.restartGame();
            enemyPanel.reset();
            //enemyPanel.repaint(); superfluo perché in codice attuale la repaint viene SEMPRE chiamata alla fine
           //return;
        }
        switch(e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> Game.getGame().move(Game.MOVE_LEFT);
            case KeyEvent.VK_RIGHT -> Game.getGame().move(Game.MOVE_RIGHT);
            case KeyEvent.VK_DOWN -> Game.getGame().move(Game.MOVE_DOWN);
            case KeyEvent.VK_UP -> Game.getGame().move(Game.MOVE_UP);
        }
        enemyPanel.repaint();

    }
}
