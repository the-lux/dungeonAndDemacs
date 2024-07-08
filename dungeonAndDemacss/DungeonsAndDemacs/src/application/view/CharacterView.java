package application.view;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;



public class CharacterView {
    public final BufferedImage[] immagini = new BufferedImage[8];

    int currentDirection;

    public CharacterView() {
        try {
            immagini[0] = ImageIO.read(getClass().getResourceAsStream("../resources/up_1.png"));
            immagini[1] = ImageIO.read(getClass().getResourceAsStream("../resources/up_2.png"));
            immagini[2] = ImageIO.read(getClass().getResourceAsStream("../resources/right_1.png"));
            immagini[3] = ImageIO.read(getClass().getResourceAsStream("../resources/right_2.png"));
            immagini[4] = ImageIO.read(getClass().getResourceAsStream("../resources/down_1.png"));
            immagini[5] = ImageIO.read(getClass().getResourceAsStream("../resources/down_2.png"));
            immagini[6] = ImageIO.read(getClass().getResourceAsStream("../resources/left_1.png"));
            immagini[7] = ImageIO.read(getClass().getResourceAsStream("../resources/left_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Image getImage() {
        return immagini[currentDirection];
    }

    public void updateDirection(int direction) {
        this.currentDirection = direction;
    }




}

