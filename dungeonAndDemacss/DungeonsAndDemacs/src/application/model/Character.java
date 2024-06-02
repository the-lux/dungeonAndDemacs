package application.model;

public class Character {
    private Cordinate place=new Cordinate(19,19);
    private boolean alive=true;
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
}
