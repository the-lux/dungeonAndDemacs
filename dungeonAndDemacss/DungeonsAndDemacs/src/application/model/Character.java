package application.model;

public class Character {
    private Cordinate place=new Cordinate(19,19);
    private boolean alive=true;
    private int health;
    private int damage;
    public Character(){};
    public Character (Cordinate p){
        place=p;
    }
    public void changePosition(Cordinate p){
        place=p;
    }
    public Cordinate getPlace(){
        return place;
    }
    public void killCharacter(){
        alive=false;
    }
    public boolean isAlive() {
        return alive;
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

    public void setHealth(int health) {
        this.health = health;
    }
}
