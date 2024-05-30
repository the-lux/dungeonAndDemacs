package application.view;

import application.config.Settings;
import application.model.Game;
import application.model.Cordinate;
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
        String message;
        if (!game.isAlive()) {
            message="Bocciato :)"+" Premi n per riprovare!";
            drawEnd(g, message);
            return;
        } else if (game.win()) {
            drawEnd(g, "Ti sei laureato! Premi n per ricominciare");
            return;
        }


        World world = game.getWorld();
        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                Cordinate p = new Cordinate(i, j);
                if(world.isEmpty(p))
                    continue;
                Color c = Color.BLACK;
                if(world.isWall(p)) c = Color.DARK_GRAY;
                else if (world.isDoor(p)) c= Color.MAGENTA;
                else if (world.isRedEnemy(p) ){ c=Color.RED;}
                else if (world.isBlueEnemy(p)) {c=Color.BLUE;}
                else if (world.isYellowEnemy(p)) {c=Color.YELLOW;}
                else if (world.isCharacter(p)) {c=Color.GREEN;}
                g.setColor(c);
                if (!world.isCharacter(p)) {
                    g.fillRect(i * Settings.BLOCK_SIZE, j * Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,
                            Settings.BLOCK_SIZE);
                } else {
                    g.fillOval(i*Settings.BLOCK_SIZE, j*Settings.BLOCK_SIZE, Settings.BLOCK_SIZE,Settings.BLOCK_SIZE);
                }
            }
        }

    }
}
