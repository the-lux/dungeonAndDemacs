package application.model;

public class Cordinate {
    public int x;//rig
    public int y;//colon
    public Cordinate(){}
    public Cordinate(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Cordinate(Cordinate c){
        this.x=c.x;
        this.y=c.y;
    }
    public boolean isGreaterThan(Cordinate c){
        return this.x > c.x || this.y > c.y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void increaseX(int x){

    }
    public void increaseY(int x){

    }
}