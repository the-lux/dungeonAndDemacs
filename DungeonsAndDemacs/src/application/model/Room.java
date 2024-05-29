package application.model;

public  class Room {
    private boolean isStart;//Is first room
    private boolean isEnd;//Is Exit room
    private int nDoor;
    private final boolean[] doors;//0 up 1 right 2 below 3 left
    private final Room[]roomLink;
    private Cordinate position;
    private int type;
    /*
    -1 empty
    0 Ianni
    1 feduli
    2 Van Bon
    3 loot
    4 minion
    5 mercante
    */

    public Room() {
        this.roomLink = new Room[4];
        this.doors = new boolean[4];
        this.isEnd=false;
        this.isStart = false;
        this.nDoor = 0;
        this.type = -1;
    }
    public Cordinate getDirRelativeCord(int dir){
        try {
            Cordinate next = new Cordinate(this.position);
            switch (dir){
                case 0:
                    next.x --;
                    break;
                case 1:
                    next.y ++;
                    break;
                case 2:
                    next.x ++;
                    break;
                case 3:
                    next.y --;
                    break;
                default:
                    throw new IllegalArgumentException("Il valore non è compreso tra 0 e 3");
            }
            return next;
        } catch (IllegalArgumentException e) {
            System.out.println("Valore non compreso");
            return null;
        }
    }
    public Cordinate getPosition() {
        return position;
    }
    //TODO creare un nuovo metodo di overload per setIndexDoor che accetta anche le cord
    public void setPosition(Cordinate c) {
        this.position = new Cordinate(c);
    }
    public void setPosition(int x,int y) {
        this.position = new Cordinate(x,y);
    }

    public boolean isUp() {
        return doors[0];
    }

    public void setUp(boolean up,Room upLink) {//if boolean is false link is null
        if (up){
            this.roomLink[0]=upLink;
            this.doors[0] = up;
            this.nDoor ++;
        }
        else {
            this.roomLink[0]=null;
            this.doors[0] = up;
            this.nDoor --;
        }
    }

    public boolean isBelow() {
        return doors[2];
    }

    public void setBelow(boolean below,Room belowLink) {//if boolean is false link is null
        if(below){
            this.doors[2] = below;
            this.roomLink[2]=belowLink;
            this.nDoor ++;
        }
        else {
            this.doors[2] = below;
            this.roomLink[2]=null;
            this.nDoor --;
        }
    }

    public boolean isLeft() {
        return doors[3];
    }

    public void setLeft(boolean left, Room leftLink) {
        if(left){
            this.roomLink[3]=leftLink;
            this.doors[3] = left;
            this.nDoor ++;
        }
        else {
            this.roomLink[3]=null;
            this.doors[3] = left;
            this.nDoor --;
        }
    }

    public boolean isRight() {
        return doors[1];
    }

    public void setRight(boolean right, Room rightLink) {
        if(right){
            this.roomLink[1] =rightLink;
            this.doors[1] = right;
            this.nDoor ++;
        }
        else {
            this.roomLink[1] =null;
            this.doors[1] = right;
            this.nDoor --;
        }
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
    public int getNDoor() {
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
    public void setIndexDoor(int dir, boolean bool, Room roomLink){
        try {
            // Controllo se il valore è nel range desiderato
            if (dir < 0 || dir > 3) {
                // Se non è nel range, solleva un'eccezione
                throw new IllegalArgumentException("Il valore non è compreso tra 0 e 3");
            }
            // Se è nel range
            if(bool){
                this.doors[dir]=true;
                this.roomLink[dir]=roomLink;
                nDoor ++;
            }
            else{
                this.doors[dir]=false;
                this.roomLink[dir]=null;
                nDoor --;
            }
        } catch (IllegalArgumentException e) {
            return;
        }

    }
    public boolean getIndexDoors(int dir){//dir must be an integer dir>=0 && dir<=3
        try {
            // Controllo se il valore è nel range desiderato
            if (dir < 0 || dir > 3) {
                // Se non è nel range, solleva un'eccezione
                if(dir==-1)
                    return false;
                else
                    throw new IllegalArgumentException("Il valore non è compreso tra 0 e 3");
            }
            // Se è nel range, restituisco true
            return doors[dir];
        } catch (IllegalArgumentException e) {
            // Se viene sollevata un'eccezione, restituisco false
            return false;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}