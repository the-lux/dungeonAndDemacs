package application.view;

import application.config.Settings;
import application.model.Game;
import application.model.Position;
import application.model.World;

import javax.swing.*;
import java.awt.*;

public class EnemyPanel extends JPanel {
    public EnemyPanel () {
        reset();
    }
    public void reset(){
        this.setBackground(Color.WHITE);
    }
    private void drawEnd(Graphics g, String messagge){
        this.setBackground(Color.DARK_GRAY);
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.setColor(Color.WHITE);
        g.drawString(messagge, Settings.WINDOW_SIZE/20, Settings.WINDOW_SIZE/20);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game game=Game.getGame();
        /* if (!game.isAlive()) {
            drawEnd(g, "Game over! Press n to start a new game");
            return;
        } else if (game.win()) {
            drawEnd(g, "You win! Press n to start a new game");
            return;
        }
         */

        World world = game.getWorld();
        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                Position p = new Position(i, j);
                if(world.isEmpty(p))
                    continue;
                Color c = Color.BLACK;
                if(world.isWall(p)) c = Color.DARK_GRAY;
                else if (world.isRedEnemy(p) ){ c=Color.RED;}
                else if (world.isBlueEnemy(p)) {c=Color.BLUE;}
                else if (world.isYellowEnemy(p)) {c=Color.YELLOW;}
                g.setColor(c);
                g.fillRect(i * Settings.BLOCK_SIZE, j * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
                            Settings.BLOCK_SIZE);
            }
        }

    }
}
