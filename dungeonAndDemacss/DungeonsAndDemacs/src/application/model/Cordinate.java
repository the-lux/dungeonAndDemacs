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

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public void plusEqualX(int val){
        this.x+=val;
    }
    public void plusEqualY(int val){
        this.y+=val;
    }

    public boolean isGreaterThan(Cordinate c){
        return this.x > c.x || this.y > c.y;
    }
}