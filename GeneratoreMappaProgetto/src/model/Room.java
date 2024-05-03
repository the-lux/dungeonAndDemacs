package model;

public  class Room {
    private boolean up=false;
    private boolean below=false;//below
    private boolean left=false; //left
    private boolean right=false;//right
    private boolean isStart = false;//Is first room
    private boolean isEnd=false;//Is Exit room
    private int nDoor = 0;
    private Room upLink;
    private Room belowLink;
    private Room leftLink;
    private Room rightLink;
    //protected Cordinate position;

    /*public Cordinate getPosition() {
        return position;
    }

    public void setPosition(int x,int y) {
        this.position = new Cordinate(x,y);
    }*/

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up,Room upLink) {
        this.upLink=upLink;
        this.up = up;
        this.nDoor +=1;
    }

    public boolean isBelow() {
        return below;
    }

    public void setBelow(boolean below,Room belowLink) {
        this.below = below;
        this.belowLink=belowLink;
        this.nDoor +=1;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left, Room leftLink) {
        this.leftLink=leftLink;
        this.left = left;
        this.nDoor +=1;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right, Room rightLink) {
        this.rightLink =rightLink;
        this.right = right;
        this.nDoor +=1;
    }

    public Room getUpLink() {
        return upLink;
    }
    public Room getBelowLink() {
        return belowLink;
    }
    public Room getLeftLink() {
        return leftLink;
    }
    public Room getRightLink() {
        return rightLink;
    }
    public boolean isStart() {
        return isStart;
    }
    public void setStart(boolean start) {
        isStart = start;
    }
    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd(boolean end) {
        isEnd = end;
    }
    public boolean isEmpty(){
        return !(up | right | below | left);
    }
    public boolean[] getType(){
        boolean[] type= new boolean[4];
        type[0]=this.up;
        type[1]=this.right;
        type[2]=this.below;
        type[3]=this.left;
        return type;
    }
    public int getnDoor() {
        return nDoor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "up=" + up +
                ", below=" + below +
                ", left=" + left +
                ", right=" + right +
                ", isStart=" + isStart +
                ", isEnd=" + isEnd +
                ", nDoor=" + nDoor +
                '}';
    }
    /*public void setDoor(int dir){
        switch (dir){//direction: 0 up 1 right 2 below 3 left
            case 0:
                up = true;
                break;
            case 1:
                right = true;
                break;
            case 2:
                below = true;
                break;
            case 3:
                left = true;
        }
    }*/
}
