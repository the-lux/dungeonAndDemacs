package application.model;

import java.util.Random;

/*
TODO: Ogni tipo di nemico una classe che estende Enemy
TODO: Enemy classe astratta? (Potrebbe non convenire)
TODO: Implementare logica dei nemici
 */
public class Enemy {
    private Cordinate oldPlace; //la utilizzo per salvare la vecchia posizione e annullare il movimento se questo non dovesse essere valido
    private Cordinate place;
    private boolean alive;
    private int health;
    private int damage;
    private int enemyType; //ogni nemico sarà di uno specifico tipo
    /* Nemici
    0 Ianni
    1 fuduli
    2 Van Bon
    3 Torpedine
    4 Associazioni
    */
    private final int reference; //id che uso per riferirmi a quello specifico nemico in un gruppo di nemici;

    public Enemy(Cordinate p, int type, int i){
        alive=true;
        place=p;
        enemyType=type;
        reference=i;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setDead(){
        alive=false;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(int enemyType) {
        if (enemyType>=1 && enemyType<3)
            this.enemyType = enemyType;
    }

    public Cordinate getPlace() {
        return place;
    }

    public Cordinate getOldPlace() {
        return oldPlace;
    }

    public void setPlace(Cordinate place) {
        this.place = place;
    }

    public void standardMove(){
        oldPlace=place;
        Random random=new Random();
        int direction=random.nextInt(0,3);
        switch (direction){
            case 0:
                this.setPlace(new Cordinate(place.getX(), place.getY()-1));
                break;
            case 1:
                this.setPlace(new Cordinate(place.getX()+1, place.getY()));
                break;
            case 2:
                this.setPlace(new Cordinate(place.getX(), place.getY()+1));
                break;
            case 3:
                this.setPlace(new Cordinate(place.getX()-1,place.getY()));
                break;
        }
    }
    public void smartMove(boolean found){
        if (found){
            oldPlace=place;
            System.out.println("Movimento in fase di implementazione :D");
            //TODO:move towards player
        } else {
            standardMove();
        }

    }
    public void undoMove(){
        place=oldPlace;
    }
}
