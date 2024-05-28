package application.model;

public class Character {
    private Position place;
    private boolean alive=true;
    public Character (Position p){
        place=p;
    }
    public void changePosition(Position p){
        place=p;
    }
    public Position getPlace(){
        return place;
    }
    public void killCharacter(){
        alive=false;
    }

    public boolean isAlive() {
        return alive;
    }
}
