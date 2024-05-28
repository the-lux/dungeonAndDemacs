package application.model;

public class Cordinate {
    private int x;//rig
    private int y;//colon
    public Cordinate(){}
    public Cordinate(int x,int y){
        this.x=x;
        this.y=y;
    }
    public Cordinate(Luca.application.model.Cordinate c){
        this.x=c.x;
        this.y=c.y;
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

    public boolean isGreaterThan(Luca.application.model.Cordinate c){
        return this.x > c.x || this.y > c.y;
    }
}
