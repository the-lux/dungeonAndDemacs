package application.view;

import application.config.AudioSettings;
import application.config.Settings;
import application.model.Game;
import application.model.Cordinate;
import application.model.World;

import javax.swing.*;
import java.awt.*;

public class WorldPanel extends JPanel {
    public WorldPanel() {
        reset();
    }
    public void reset(){
        this.setBackground(Color.WHITE);
    }
    private void drawEnd(Graphics g, String messagge){
        Color red=new Color(240,22,14);
        this.setBackground(red);
        g.setFont(new Font("Algerian", Font.PLAIN, 30));
        g.setColor(Color.BLACK);
        g.drawString(messagge, Settings.WINDOW_SIZE/25-15, Settings.WINDOW_SIZE/2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Game game=Game.getGame();
        String message;
        if (!game.isAlive()) {
            //message="Bocciato. "+"Premi n per riprovare!";
            //drawEnd(g, message);
            PanelManager.getInstance().goLose();
            return;

        } else if (game.win()) {
            //message="Ti sei laureato! Premi n per ricominciare.";
            //drawEnd(g, message);
            PanelManager.getInstance().goWin();
            return;

        }
        World world = game.getWorld();
        for (int i = 0; i < world.getSize(); i++) {
            for (int j = 0; j < world.getSize(); j++) {
                Cordinate p = new Cordinate(i, j);
                if(world.isEmpty(p))
                    continue;
                Color c = Color.WHITE;
                if(world.isWall(p)) c = Color.DARK_GRAY;
                else if (world.isDoor(p)) c= Color.MAGENTA;
                else if (world.isStandardEnemy(p) ){ c=Color.ORANGE;}
                else if (world.isSmartEnemy(p)) {c=Color.RED;}
                else if (world.isCharacter(p)) {c=Color.GREEN;}
                else if (world.isPowerUp(p)) {c=Color.CYAN;}
                else if (world.isBoss(p)) {c=Color.BLACK;}
                else if (world.isTrap(p)) {c=Color.LIGHT_GRAY;}
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
    public void update(){
        this.repaint();
        Game game=Game.getGame();
        if (game.getWorld().hasEnemyHit()){
            Sound audio=new Sound("meleeAttack2.wav");
            audio.play();
            audio.adjustAudio(0, AudioSettings.getVolumeEffetti());
            game.getWorld().endEnemyHit();
        }
        if (game.isUsedPowerUp()){
            Sound audio=new Sound("powerup.wav");
            audio.play();
            audio.adjustAudio(0,AudioSettings.getVolumeEffetti());
            game.endUsedPowerUp();
        }
    }
    public void sfxMovementChar(){
        Sound audio=new Sound("charWalk.wav");
        audio.play();
        audio.adjustAudio(0,AudioSettings.getVolumeEffetti());
    }
    public void sfxAttack(){
        Sound audio=new Sound("meleeAttack1.wav");
        audio.play();
        audio.adjustAudio(0,AudioSettings.getVolumeEffetti());
    }
}
