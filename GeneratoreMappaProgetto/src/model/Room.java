package model;

public  class Room {
    /*private boolean up=false;
    private boolean below=false;//below
    private boolean left=false; //left
    private boolean right=false;//right
    private Room upLink;
    private Room belowLink;
    private Room leftLink;
    private Room rightLink;*/
    private boolean isStart = false;//Is first room
    private boolean isEnd=false;//Is Exit room
    private int nDoor = 0;
    private final boolean[] doors = new boolean[4];//0 up 1 right 2 below 3 left
    private final Room[]roomLink = new Room[4];
    protected Cordinate position;

    public Cordinate getPosition() {
        return position;
    }

    public void setPosition(int x,int y) {
        this.position = new Cordinate(x,y);
    }

    public boolean isUp() {
        return doors[0];
    }

    public void setUp(boolean up,Room upLink) {
        this.roomLink[0]=upLink;
        this.doors[0] = up;
        this.nDoor +=1;
    }

    public boolean isBelow() {
        return doors[2];
    }

    public void setBelow(boolean below,Room belowLink) {
        this.doors[2] = below;
        this.roomLink[2]=belowLink;
        this.nDoor +=1;
    }

    public boolean isLeft() {
        return doors[3];
    }

    public void setLeft(boolean left, Room leftLink) {
        this.roomLink[3]=leftLink;
        this.doors[3] = left;
        this.nDoor +=1;
    }

    public boolean isRight() {
        return doors[1];
    }

    public void setRight(boolean right, Room rightLink) {
        this.roomLink[1] =rightLink;
        this.doors[1] = right;
        this.nDoor +=1;
    }

    public Room getUpLink() {
        return roomLink[0];
    }
    public Room getBelowLink() {
        return roomLink[2];
    }
    public Room getLeftLink() {
        return roomLink[3];
    }
    public Room getRightLink() {
        return roomLink[1];
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
        return (nDoor==0);
    }
    public boolean[] getDoors(){
        return doors;
    }
    public int getnDoor() {
        return nDoor;
    }

    @Override
    public String toString() {
        return "Room{" +
                "up=" + doors[0] +
                ", below=" + doors[2] +
                ", left=" + doors[3] +
                ", right=" + doors[1] +
                ", isStart=" + isStart +
                ", isEnd=" + isEnd +
                ", nDoor=" + nDoor +
                '}';
    }
    public void setDoor(int dir,boolean bool,Room r){
        if(bool){
            doors[dir]=true;
            roomLink[dir]=r;
            nDoor ++;
        }
        else{
            doors[dir]=false;
            roomLink[dir]=null;
            nDoor --;
        }
    }
}
