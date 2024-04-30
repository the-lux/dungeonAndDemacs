package view;

import model.Room;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {
    //Room root;
    GridBagLayout gridBagLayout;
    GridBagConstraints constraints;
    public mainFrame(Room root){
        //this.root = root;
        setTitle("Map generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Creazione di un nuovo layout manager GridBagLayout
        gridBagLayout = new GridBagLayout();
        getContentPane().setLayout(gridBagLayout);
        // Creazione di un nuovo GridBagConstraints per impostare i vincoli
        constraints = new GridBagConstraints();
        constraints.gridx = 1; // Posizione X nella griglia
        constraints.gridy = 1; // Posizione Y nella griglia
        constraints.gridwidth = 1; // Larghezza nella griglia
        constraints.gridheight = 1; // Altezza nella griglia
        generateMapPanel(root,constraints,-1);
        pack();
        setLocationRelativeTo(null);
    }
    public void newGen(Room r){
        generateMapPanel(r,constraints,-1);
    }
    //funzione ricorsiva per generare la mappa come se fosse un albero
    private void generateMapPanel(Room r,GridBagConstraints c, int come){ //l'intero come serve per sapere da dove arriva per saltare la porta. 0 up 1 right 2 below 3 left
        if (r.isEmpty())
            return;
        RoomPanel roomPanel = new RoomPanel(r);
        roomPanel.repaint();
        getContentPane().add(roomPanel, c);
        if(r.isUp()&&come!=0){

            c.gridy--;
            generateMapPanel(r.getUpLink(),c,2);
        }
        if(r.isRight()&&come!=1){
            c.gridx ++;
            generateMapPanel(r.getRightLink(),c,3);
        }
        if (r.isBelow()&&come!=2){
            c.gridy ++;
            generateMapPanel(r.getBelowLink(),c,0);
        }
        if (r.isLeft()&&come!=3){
            c.gridx --;
            generateMapPanel(r.getLeftLink(),c,1);
        }
    }
}
