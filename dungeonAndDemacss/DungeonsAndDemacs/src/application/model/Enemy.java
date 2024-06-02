package application.model;

/*
TODO: Ogni tipo di nemico una classe che estende Enemy
TODO: Enemy classe astratta? (Potrebbe non convenire)
TODO: Implementare logica dei nemici
TODO: Assai probabile che il movimento e il comportamento dei nemici dipenda da un Thread
 */
public class Enemy {
    private Cordinate place;
    private boolean alive;
    private int health;
    private int damage;
    private int enemyType; //ogni nemico sarà di uno specifico tipo
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

    public void setPlace(Cordinate place) {
        this.place = place;
    }
}
