package application.view;

import application.config.AudioSettings;
import application.config.Settings;
import application.model.Game;
import application.model.Cordinate;
import application.model.World;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class WorldPanel extends JPanel {
    CharacterView cv;
    public final BufferedImage[] heartImage = new BufferedImage[3];
    public final BufferedImage[] powerUpImage = new BufferedImage[4];
    public WorldPanel(CharacterView cv) {
        this.cv = cv;
        loadHeart();
        loadPowerUp();
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
            PanelManager.getInstance().goLose();
            return;

        } else if (game.win()) {
            PanelManager.getInstance().goWin();
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
        showHeart(g,game.getWorld().getCharacter().getHealth());
        //LEGGENDA: 1=GPT(+danno), 2=Tessera Associazione(Scudo), 3=Sigaretta(invisibile), 4=caffè vita
        int powerUpType = world.getCharacter().getPowerUpType();
        if(powerUpType>0&&powerUpType<4){
            showPowerUp(g,powerUpType-1);
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
    private void loadHeart(){
        try {
            heartImage[0] = ImageIO.read(getClass().getResourceAsStream("../resources/heart_full.png"));
            heartImage[1] = ImageIO.read(getClass().getResourceAsStream("../resources/heart_half.png"));
            heartImage[2] = ImageIO.read(getClass().getResourceAsStream("../resources/heart_empty.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadPowerUp(){
        try {
            powerUpImage[0] = ImageIO.read(getClass().getResourceAsStream("../resources/power_up_ gpt_damage.png"));
            powerUpImage[1] = ImageIO.read(getClass().getResourceAsStream("../resources/power_up_shield_card.png"));
            powerUpImage[2] = ImageIO.read(getClass().getResourceAsStream("../resources/power_up_invisible_siga.png"));
            powerUpImage[3] = ImageIO.read(getClass().getResourceAsStream("../resources/power_up_health_coffee.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showPowerUp(Graphics g, int type){
        try {
            switch(type){
                case 1://GPT(+danno)
                    g.drawImage(powerUpImage[1],200,590,64,64,null);
                    break;
                case 2://Tessera Associazione (scudo)
                    g.drawImage(powerUpImage[1],200,590,64,64,null);
                    break;
                case 3://Sigaretta(invisibile)
                    g.drawImage(powerUpImage[1],200,590,64,64,null);
                    break;
                case 4://caffè vita
                    g.drawImage(powerUpImage[1],200,590,64,64,null);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        } catch(IllegalArgumentException e){
            System.out.println("L'id del powerup non è valido");
        }
    }
    private void showHeart(Graphics g, int heart){
        switch (heart){
            case 1://mezzo cuore
                g.drawImage(heartImage[1],20,590,null);
                g.drawImage(heartImage[2],70,590,null);
                g.drawImage(heartImage[2],120,590,null);
                break;
            case 2://un solo cuore
                g.drawImage(heartImage[0],20,590,null);
                g.drawImage(heartImage[2],70,590,null);
                g.drawImage(heartImage[2],120,590,null);
                break;
            case 3://uno e mezzo cuore
                g.drawImage(heartImage[0],20,590,null);
                g.drawImage(heartImage[1],70,590,null);
                g.drawImage(heartImage[2],120,590,null);
                break;
            case 4://2 cuore
                g.drawImage(heartImage[0],20,590,null);
                g.drawImage(heartImage[0],70,590,null);
                g.drawImage(heartImage[2],120,590,null);
                break;
            case 5://2 mezzo cuore
                g.drawImage(heartImage[0],20,590,null);
                g.drawImage(heartImage[0],70,590,null);
                g.drawImage(heartImage[1],120,590,null);
                break;
            case 6://3 cuori
                g.drawImage(heartImage[0],20,590,null);
                g.drawImage(heartImage[0],70,590,null);
                g.drawImage(heartImage[0],120,590,null);
                break;
        }
    }
}
