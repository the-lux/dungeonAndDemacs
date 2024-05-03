package model;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MapGen {
    private Room[][] map = new Room[28][28];
    protected Cordinate roomBorder;
    public Room genMap(int nRoom){//max840
        map = new Room[28][28];
        map[15][15] = new Room();
        map[15][15].setStart(true);
        roomBorder = new Cordinate();
        clearPathGen((int) (nRoom*0.60));
        return this.map[15][15];
    }
    private void clearPathGen(int nRoom){
        Cordinate current = new Cordinate(15,15);
        Cordinate next;
        Random r = new Random();
        for (int i=0; i<nRoom;i++){
            int dir;
            //Choice a direction
            do{
                next = new Cordinate(current);
                dir = r.nextInt(4);
                switch (dir){//direction: 0 up 1 right 2 below 3 left
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
                }
            }while (map[next.x][next.y]!=null); //while per evitare di creare una stanza in una posizione già occupata
            map[next.x][next.y]=new Room();
            switch (dir){//direction: 0 up 1 right 2 below 3 left
                case 0:
                    map[current.x][current.y].setUp(true,map[next.x][next.y]);
                    //map[current.x][current.y].setPosition(current.x,current.y);
                    map[next.x][next.y].setBelow(true,map[current.x][current.y]);
                    //map[next.x][next.y].setPosition(next.x,next.y);
                    break;
                case 1:
                    map[current.x][current.y].setRight(true,map[next.x][next.y]);
                    //map[current.x][current.y].setPosition(current.x,current.y);
                    map[next.x][next.y].setLeft(true,map[current.x][current.y]);
                    //map[next.x][next.y].setPosition(next.x,next.y);
                    break;
                case 2:
                    map[current.x][current.y].setBelow(true,map[next.x][next.y]);
                    //map[current.x][current.y].setPosition(current.x,current.y);
                    map[next.x][next.y].setUp(true,map[current.x][current.y]);
                    //map[next.x][next.y].setPosition(next.x,next.y);
                    break;
                case 3:
                    map[current.x][current.y].setLeft(true,map[next.x][next.y]);
                    //[current.x][current.y].setPosition(current.x,current.y);
                    map[next.x][next.y].setRight(true,map[current.x][current.y]);
                    //map[next.x][next.y].setPosition(next.x,next.y);
            }
            current = new Cordinate(next);
            if(current.isGreaterThan(roomBorder)) roomBorder = new Cordinate(current);
        }
        map[current.x][current.y].setEnd(true);
    }
    public Room getRoot(){
        return map[15][15];
    }

    @Override
    public String toString() {

        return "MapGen{" +
                "map=" + Arrays.toString(map) +
                '}';
    }

    /*private Cordinate genExit(){
        Random r = new Random();
        Cordinate c = new Cordinate();
        c.x = r.nextInt(28);
        c.y=r.nextInt(28);
        if()
    }*/
}
