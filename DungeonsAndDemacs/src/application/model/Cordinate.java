package application.model;

public class Cordinate {
    private int x;//rig
    private int y;//colon
    public Cordinate(){}
    public Cordinate(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Cordinate(Cordinate c){
        this.x=c.x;
        this.y=c.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void increaseX(int val){
        this.x=x+val;
    }
    public void increaseY(int val){
        this.y=y+val;
    }

    public boolean isGreaterThan(Cordinate c){
        return this.x > c.x || this.y > c.y;
    }
}
