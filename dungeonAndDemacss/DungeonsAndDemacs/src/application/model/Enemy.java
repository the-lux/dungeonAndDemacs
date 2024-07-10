package application.model;

import java.util.Random;

public class Enemy {
    protected Cordinate oldPlace; //la utilizzo per salvare la vecchia posizione e annullare il movimento se questo non dovesse essere valido
    protected Cordinate place;
    protected boolean alive;
    protected int health;
    protected int enemyType; //0 smart, 1 standard, 2+ boss
    protected int view;
    /* Nemici
    0 Ianni
    1 fuduli
    2 Van Bon
    3 Torpedine // standard
    4 Associazioni //segue intelligente
    */
    protected final int reference; //id che uso per riferirmi a quello specifico nemico in un gruppo di nemici;
    public Enemy(Cordinate p, int type, int i){
        alive=true;
        place=p;
        enemyType =type;
        reference=i;
        if (type!=1){
            view=3;
        } else {
            view=0;
        }
    }
    public int getView(){
        return view;
    }

    public int getHealth() {
        return health;
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
    public void smartMove(Cordinate player){
            oldPlace=place;//assegnamento per poter eventualmente fare la undo
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
    }
    public void undoMove(){
        place=oldPlace;
    }
}
