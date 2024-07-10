package application.model;

public class Character {
    private Cordinate place=new Cordinate(19,19);
    private boolean alive=true;
    private int health;
    private int damage;
    private int facing=0;//la direzione a cui è rivolto
    //todo cambiare i getter e setter restituendo utilizzando powerUpType
    private boolean invisible=false; //serve per implementare il powerup3
    private boolean shielded=false;
    private int powerUpType = -1;

    public int getPowerUpType() {
        return powerUpType;
    }

    public void setPowerUpType(int powerUpType) {
        this.powerUpType = powerUpType;
    }
    public Character(){
        health=6;
    };
    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible=invisible;
    }

    public boolean isShielded() {
        return shielded;
    }

    public void setShielded(boolean shielded) {
        this.shielded = shielded;
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
        this.damage += damage;
    }

    public int getHealth() {
        return health;
    }

   public void updateHealth(int hit){
        health+=hit;
   }
   public void fullHeal(){
        health=3;
   }
   public void damageCharacter(int hit){
        if (shielded){
            setShielded(false);
        } else {
            updateHealth(hit);
        }
   }
}
