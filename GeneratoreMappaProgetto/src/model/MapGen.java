package model;

//import java.util.ArrayList;
//import javax.swing.text.Position;
import java.util.Arrays;
import java.util.Random;

public class MapGen {
    private Room[][] map = new Room[28][28];
    Random rN = new Random();
    public Room genMap(int nRoom){//max840
        map = new Room[28][28];
        map[15][15] = new Room();
        map[15][15].setStart(true);
        int p = (int) (nRoom*0.40);
        clearPathGen(p);
        //genMoreRoom(nRoom-p,map[15][15]);
        return this.map[15][15];
    }
    private void clearPathGen(int nRoom){
        Cordinate current = new Cordinate(15,15);
        Cordinate next;
        for (int i=0; i<nRoom;i++){
            int dir;
            //Choice a direction
            do{
                next = new Cordinate(current);
                dir = rN.nextInt(4);
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
            map[current.x][current.y].setDoor(dir,true,map[next.x][next.y]);
            map[next.x][next.y].setDoor(dir,true,map[current.x][current.y]);
            /*switch (dir){//direction: 0 up 1 right 2 below 3 left
                case 0:
                    map[current.x][current.y].setUp(true,map[next.x][next.y]);
                    map[next.x][next.y].setBelow(true,map[current.x][current.y]);
                    break;
                case 1:
                    map[current.x][current.y].setRight(true,map[next.x][next.y]);
                    map[next.x][next.y].setLeft(true,map[current.x][current.y]);
                    break;
                case 2:
                    map[current.x][current.y].setBelow(true,map[next.x][next.y]);
                    map[next.x][next.y].setUp(true,map[current.x][current.y]);
                    break;
                case 3:
                    map[current.x][current.y].setLeft(true,map[next.x][next.y]);
                    map[next.x][next.y].setRight(true,map[current.x][current.y]);
            }*/
            map[current.x][current.y].setPosition(current.x,current.y);
            current = new Cordinate(next);
        }
        map[current.x][current.y].setEnd(true);
    }
    //metodo ricorsivo per generare le stanze aggiuntive
    private void genMoreRoom(int nRoom,Room r){
        if(r.isEmpty()||nRoom==0||r.getnDoor()==4) return;
        int a =rN.nextInt(3);
        Cordinate current = new Cordinate(r.getPosition());
        if(a==1){//una sola stanza aggiuntiva
            if(map[current.x--][current.y]==null){//sopra

            }
            else if(map[current.x][current.y++]==null){//destra

            }
            else if(map[current.x++][current.y]==null){//sotto

            }
            else if(map[current.x][current.y--]==null){//sinistra

            }
            /*for(int i=0; i<4;i++){
                if(!r.getDoors()[i]){
                    map[r.getPosition().x][r.getPosition().y]
                }
            }*/
        }
        else if (a==2){//due stanze aggiuntive

        }
        //altrimenti nessuna
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
