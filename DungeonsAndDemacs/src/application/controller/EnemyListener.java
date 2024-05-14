package application.controller;

import application.model.Game;
import application.view.EnemyPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EnemyListener extends KeyAdapter {
    private final EnemyPanel enemyPanel;
    public EnemyListener (EnemyPanel eP){
        this.enemyPanel=eP;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q)
            System.exit(0);

        if(e.getKeyCode() == KeyEvent.VK_N) {
            Game.restartGame();
            enemyPanel.reset();
            enemyPanel.repaint();
           //return;
        }
    }
}
