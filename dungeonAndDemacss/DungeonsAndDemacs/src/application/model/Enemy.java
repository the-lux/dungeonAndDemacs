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
                setPlace(new Cordinate(place.getX(), place.getY()-1));
                break;
            case 1:
                setPlace(new Cordinate(place.getX()+1, place.getY()));
                break;
            case 2:
                setPlace(new Cordinate(place.getX(), place.getY()+1));
                break;
            case 3:
                setPlace(new Cordinate(place.getX()-1,place.getY()));
                break;
        }
    }
    public Cordinate smartMove(boolean found,Cordinate player){
        if (found){
            oldPlace=place; //assegnamento per poter eventualmente fare la undo
            int xPlayer= player.getX();
            int yPlayer= player.getY(); //salvo in delle variabili le cordinate x e y del player
            int xEnemy=place.getX();
            int yEnemy=place.getY(); //stessa cosa con la posizione del nemico
            //il seguente corpo di if distingue i vari casi di posizione del player rispetto al nemico
            //leggenda: xPlayer>xEnemy il player è a destra; yPlayer>yEnemy il player è sotto
            if (xPlayer>xEnemy){
                if (yPlayer==yEnemy){
                    setPlace(new Cordinate(xEnemy+1,yEnemy));
                }
                else if (yPlayer>yEnemy){
                    setPlace(new Cordinate (xEnemy+1,yEnemy+1));
                } else {
                    setPlace(new Cordinate(xEnemy+1,yEnemy-1));
                }
            } else if (xPlayer<xEnemy){
                if (yPlayer==yEnemy){
                    setPlace(new Cordinate (xEnemy-1,yEnemy));
                } else if (yPlayer>yEnemy) {
                    setPlace(new Cordinate (xEnemy-1,yEnemy+1));
                } else {
                    setPlace (new Cordinate (xEnemy-1,yEnemy-1));
                }
            } else {
                if (yPlayer>yEnemy){
                    setPlace(new Cordinate (xEnemy,yEnemy+1));
                } else {
                    setPlace(new Cordinate(xEnemy,yEnemy-1));
                }
            }
        } else {
            standardMove();
        }
        return place;
    }
    public void undoMove(){
        place=oldPlace;
    }
}
