package application.model;

public class Boss extends Enemy{
    public Boss(Cordinate p){
        super(p,2,0);
        health=3;
    }
    public void move(Cordinate playerPosition){
        super.smartMove(playerPosition);
    }
    public void attack(){
        System.out.println("Attacco in fase di implementazione");
        //TODO: logica dell'attacco del boss
    }
    public void updateHealth(int hit){
        health+=hit;
    }
}
