package application.model;

public class Cordinate {
    public int x;//rig
    public int y;//colon
    public Cordinate(){}
    public Cordinate(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Cordinate(model.Cordinate c){
        this.x=c.x;
        this.y=c.y;
    }
    public boolean isGreaterThan(model.Cordinate c){
        return this.x > c.x || this.y > c.y;
    }
}