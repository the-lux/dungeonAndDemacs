package application.model;
import java.util.ArrayList;
import java.util.Random;
public class MapGen {
    private Room[][] map = new Room[28][28];
    private ArrayList<Cordinate> queue;
    Random rN = new Random();
    public Room genMap(int nRoom){//max840 ritorna la root
        map = new Room[28][28];
        //crea la stanza iniziale
        map[15][15] = new Room();
        map[15][15].setStart(true);
        map[15][15].setPosition(15,15);
        map[15][15].setRoomType(rN.nextInt(0,2));
        queue = new ArrayList<>();
        int p = (int) (nRoom*0.40);
        clearPathGen(p);
        genMoreRoom(nRoom-p);
        return this.map[15][15];
    }
    private void clearPathGen(int nRoom){
        Cordinate current = new Cordinate(15,15);
        Cordinate next = null;
        for (int i=0; i<nRoom;i++){
            int dir;
            //Choice a direction
            do{
                next = new Cordinate(current);
                dir = rN.nextInt(4);
                switch (dir){//direction: 0 up 1 right 2 below 3 left
                    case 0:
                        next.plusEqualX(-1);
                        break;
                    case 1:
                        next.plusEqualY(1);
                        break;
                    case 2:
                        next.plusEqualX(1);
                        break;
                    case 3:
                        next.plusEqualY(-1);
                }
            }while (map[next.getX()][next.getY()]!=null); //while per evitare di creare una stanza in una posizione già occupata
            setSonRoom(next,current,dir, rN.nextInt(2));//setta il figlio e il tipo di stanza
            queue.add(current);//aggiunge alla coda le stanze principali
            current = new Cordinate(next);
        }
        queue.add(next);
        map[current.getX()][current.getY()].setEnd(true);//setta la stanza finale
        map[current.getX()][current.getY()].setRoomType(2); //setta il bos
    }
    /*
    /* Stanze
    NUOVI INDICI:
    0=più nemici
    1=1 nemico
    2+=Boss(Ianni,Fuduli e Van Bon)
    -1 empty
    */

    private void genMoreRoom(int nRoom){
        while (nRoom>0&& !queue.isEmpty()){
            Cordinate current = queue.removeFirst();//ho sbagliato con remove last va messo removeFirst
            Cordinate next;
            if (map[current.getX()][current.getY()].getNDoor()<4){//aggiunto una if per salatare la stanza se ha già 4 porte aperte
                int randomNRoom = rN.nextInt(5-map[current.getX()][current.getY()].getNDoor());
                for (int i = 0; i < 4 && randomNRoom>0&&nRoom>0; i++) { //aggiunto nRoom>0 perchè c'è la possibilità che verso la fine della funzione crei più stanze
                    next = map[current.getX()][current.getY()].getDirRelativeCord(i);
                    if(map[next.getX()][next.getY()]==null){
                        setSonRoom(current,i, rN.nextInt(2));
                        queue.add(current);
                        randomNRoom --;
                        nRoom--;
                    }
                }
            }
        }
    }
    private void setSonRoom(Cordinate son,Cordinate father,int dir,int type){
        map[son.getX()][son.getY()]=new Room();//crea una nuova stanza
        map[father.getX()][father.getY()].setIndexDoor(dir,true,map[son.getX()][son.getY()]);//collega la stanza corrente alla nuova
        map[son.getX()][son.getY()].setIndexDoor(((dir + 2) % 4),true,map[father.getX()][father.getY()]);//collega la nuova stanza
        map[son.getX()][son.getY()].setPosition(son.getX(),son.getY());//setta la posizione del figlio
        map[son.getX()][son.getY()].setRoomType(type);
    }
    private void setSonRoom(Cordinate father,int dir,int type){
        Cordinate son = new Cordinate(map[father.getX()][father.getY()].getDirRelativeCord(dir));
        map[son.getX()][son.getY()]=new Room();//crea una nuova stanza
        map[father.getX()][father.getY()].setIndexDoor(dir,true,map[son.getX()][son.getY()]);//collega la stanza corrente alla nuova
        map[son.getX()][son.getY()].setIndexDoor(((dir + 2) % 4),true,map[father.getX()][father.getY()]);//collega la nuova stanza
        map[son.getX()][son.getY()].setPosition(son.getX(),son.getY());
        map[son.getX()][son.getY()].setRoomType(type);
    }

    public Room getRoot(){
        return map[15][15];
    }

    public Room getCordRoom(Cordinate c){
        return map[c.getX()][c.getY()];
    }
}

