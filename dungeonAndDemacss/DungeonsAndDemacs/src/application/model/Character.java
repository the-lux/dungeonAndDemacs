package application.model;

public class Character {
    private Cordinate place=new Cordinate(19,19);
    private boolean alive=true;
    private int health;
    private int damage;
    private int facing=0; //la direzione a cui è rivolto
    public Character(){
        health=3;
    };
    public Character (Cordinate p){
        place=p;
        health=3;
    }
    public void changePosition(Cordinate p){
        place=p;
    }
    public Cordinate getPlace(){
        return place;
    }
    public int getFacing() {
        return facing;
    }
    public void killCharacter(){
        alive=false;
    }
    public boolean isAlive() {
        return alive;
    }
    public void changeFacing(int direction){
        facing=direction;
    }
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

   public void updateHealth(int hit){
        health+=hit;
   }
}
