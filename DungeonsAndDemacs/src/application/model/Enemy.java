package application.model;

public class Enemy {
    private Position place;
    private boolean alive;

    private int enemyType; //ogni nemico sarà di uno specifico tipo
    private final int reference; //id che uso per riferirmi a quello specifico nemico in un gruppo di nemici;

    public Enemy(Position p, int type, int i){
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
}
