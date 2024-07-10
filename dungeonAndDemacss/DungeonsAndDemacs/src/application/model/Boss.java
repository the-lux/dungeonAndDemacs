package application.model;

import java.util.Random;

public class Boss extends Enemy{
    /*
    0 Ianni
    1 fuduli
    2 Van Bon*/
    public Boss(Cordinate p){
        super(p,2,0);
        health=3;
    }
    public void move(Cordinate playerPosition){
        super.smartMove(playerPosition);
    }
    public boolean attack(){
        Random random=new Random();
        //l'attacco ha una probabilità ogni volta di essere eseguito del 30%, che diventa 45 e 60 man mano che il boss perde vita
        //inoltre, mi assicuro che non avvenga nessun attacco se il boss non si è mosso
        if ( oldPlace!=place && random.nextInt(0,100) < 30+15*(3-health)){
            return true;
        } return false;
        //restituisco true se l'attacco può essere fatto, false altrimenti
    }
    public void updateHealth(int hit){
        health+=hit;
    }
}
