package application.model;

public class Cordinate{
    private int x;
    private int y;
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

    public void plusEqualX(int val){
        this.x+=val;
    }
    public void plusEqualY(int val){
        this.y+=val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cordinate)) {
            return false;
        }
        Cordinate cord2=(Cordinate) obj;
        return this.x==cord2.x && this.y==cord2.y;
    }
}
