package Luca.application.view;

import Luca.application.model.Room;

import javax.swing.*;
import java.awt.*;
public class RoomPanel extends JPanel {
    //private Room[][] map;
    //protected boolean[] type;//[0] up, [1] right, [2] below, [3] left
    //protected String[] filePath = new String[4];//0 OneDoor, 1 ITwoDoor, 2 LTwoDoor, 3 TDoor, 4 ADoor
    //protected int nRoom;
    protected Room room;
    protected int n;
    public RoomPanel(Room room,int n){
        this.room=room;
        this.n=n;
        this.setMaximumSize(new Dimension(64,64));
        this.setPreferredSize(new Dimension(64,64));
        /*filePath[0]="/resurces/OneDoor.png";
        filePath[1]="/resurces/ITwoDoor.png";
        filePath[2]="/resurces/LTwoDoor.png";
        filePath[3]="/resurces/TDoor.png";
        filePath[4]="/resurces/ADoor.png";*/
    }
    //barr = width 26 height 3
    //gap = 12 x 3
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 10));
        if(room.isStart()){
            g.setColor(Color.red);
            g.fillRect(3,3,58,58);
        } else if (room.isEnd()) {
            g.setColor(Color.blue);
            g.fillRect(3,3,58,58);
        }
        paintClosedRoom(g);
        paintOpenRoom(g);
    }
    protected void paintOpenRoom(Graphics g){
        int[][] gapPos = new int[][]{ //x,y,w,h
                {27,1,12,3},//up
                {61,27,3,12},//right
                {27,61,12,3},//below
                {1,27,3,12}};//left
        g.setColor(Color.white);
        for(int i=0; i<4;i++){
            if(room.getDoors()[i]){
                g.fillRect(gapPos[i][0],gapPos[i][1],gapPos[i][2],gapPos[i][3]);
            }
        }
    }
    protected void paintClosedRoom(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1,1,64,3);//upper
        g.fillRect(1,61,64,4);//lower
        g.fillRect(1,1,3,64);//left
        g.fillRect(61,1,4,64);//right
        g.setColor(Color.black);
        g.drawString(String.valueOf(n),30,30);
    }
    /*protected void paintRoom(){
        switch (nRoom){
            case 1:
                ImageIcon icon = new ImageIcon(filePath[1]);
                JLabel label = new JLabel();
                for (int i=0; i<type.length&& !type[i];i++){
                    Image rotatedImage = rotateImage(icon.getImage(), 90);
                }
                label.setIcon(icon);
                this.add(label);
                break;
            case 2:

        }
    }
    private static Image rotateImage(Image originalImage, double angleDegrees) {
        // Calcola la trasformazione
        AffineTransform tx = new AffineTransform();
        tx.rotate(Math.toRadians(angleDegrees), originalImage.getWidth(null) / 2.0, originalImage.getHeight(null) / 2.0);
        // Applica la trasformazione all'immagine
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        return op.filter(((BufferedImage) originalImage), null);
    }*/

}

