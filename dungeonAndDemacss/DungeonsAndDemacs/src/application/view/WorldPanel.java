package application.view;

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
    CharacterView cv=new CharacterView();
    public void reset(){
        this.setBackground(Color.WHITE);
    }
    private void drawEnd(Graphics g, String messagge){
        this.setBackground(Color.DARK_GRAY);
        g.setFont(new Font("arial", Font.PLAIN, 20));
        g.setColor(Color.WHITE);
        g.drawString(messagge, Settings.WINDOW_SIZE/20, Settings.WINDOW_SIZE/20);
    }

    public void setCharacterView(CharacterView characterView)
    {
        this.cv=characterView;                               //PROVA
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
        if(cv!=null)
        {
            Image characterImage=cv.getImage();
            int x=getWidth()/2 -characterImage.getWidth(null)/2;
            int y=getHeight()/2 -characterImage.getHeight(null)/2; //PROVA
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
                }
                g.drawImage(cv.getImage(),world.getCharacter().getPlace().getX()*Settings.BLOCK_SIZE,world.getCharacter().getPlace().getY()*Settings.BLOCK_SIZE,Settings.BLOCK_SIZE*2,Settings.BLOCK_SIZE*2,null);
            }
        }

    }
    public void update(){
        this.repaint();
    }
}
