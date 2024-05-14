package Luca.application.view;

import Luca.application.model.Room;

import javax.swing.*;
import java.awt.*;

public class mainFrame extends JFrame {
    //Room root;
    GridBagLayout gridBagLayout;
    GridBagConstraints constraints;
    private int n =0;
    public mainFrame(){
        //this.root = root;
        setTitle("Map generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void newGen(Room r){
        // Creazione di un nuovo layout manager GridBagLayout
        gridBagLayout = new GridBagLayout();
        getContentPane().setLayout(gridBagLayout);
        // Creazione di un nuovo GridBagConstraints per impostare i vincoli
        constraints = new GridBagConstraints();
        constraints.gridx = 5; // Posizione X nella griglia
        constraints.gridy = 5; // Posizione Y nella griglia
        constraints.gridwidth =1; // Larghezza nella griglia
        constraints.gridheight = 1; // Altezza nella griglia
        generateMapPanel(r,constraints,-1);
        pack();
        setLocationRelativeTo(null);
    }
    //funzione ricorsiva per generare la mappa come se fosse un albero
    private void generateMapPanel(Room r,GridBagConstraints c, int come){ //l'intero come serve per sapere da dove arriva per saltare la porta. 0 up 1 right 2 below 3 left
        RoomPanel roomPanel = new RoomPanel(r,n++);
        roomPanel.repaint();
        getContentPane().add(roomPanel, c);
        if (r.getIndexDoors(come)&&r.getNDoor()==1){
            System.out.println("tappo");
            return;
        }
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

    public void setN(int n) {
        this.n = n;
    }
}
