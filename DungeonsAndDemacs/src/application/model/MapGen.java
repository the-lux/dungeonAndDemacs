package application.model;
import java.util.ArrayList;
import java.util.Random;
public class MapGen {
    private Room[][] map = new Room[28][28];
    private ArrayList<Cordinate> queue;
    Random rN = new Random();
    public Room genMap(int nRoom){//max840
        map = new Room[28][28];
        map[15][15] = new Room();
        map[15][15].setStart(true);
        map[15][15].setPosition(15,15);
        queue = new ArrayList<>();
        int p = (int) (nRoom*0.40);
        clearPathGen(p);
        genMoreRoom(nRoom-p);
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
                        next.increaseX(-1);
                        break;
                    case 1:
                        next.increaseY(1);
                        break;
                    case 2:
                        next.increaseX(1);
                        break;
                    case 3:
                        next.increaseY(-1);
                }
            }while (map[next.getX()][next.getY()]!=null); //while per evitare di creare una stanza in una posizione giÃ  occupata
            setSonRoom(next,current,dir,rN.nextInt(6));
            queue.add(current);//aggiunge alla coda le stanze principali
            current = new Cordinate(next);
        }
        map[current.getX()][current.getY()].setEnd(true);
    }
    private void genMoreRoom(int nRoom){
        while (nRoom>0&& !queue.isEmpty()){
            Cordinate current = queue.removeLast();
            Cordinate next;
            int randomNRoom = rN.nextInt(5-map[current.getX()][current.getY()].getNDoor());
            for (int i = 0; i < 4 && randomNRoom>0; i++) {
                next = map[current.getX()][current.getY()].getDirRelativeCord(i);
                if(map[next.getX()][next.getY()]==null){
                    setSonRoom(current,i,rN.nextInt(6));
                    queue.add(current);
                    randomNRoom --;
                    nRoom--;
                }
            }
        }
    }
    /*metodo ricorsivo per generare le stanze aggiuntive
    private void genMoreRoom(int nRoom,Room r){
        if(r.isEmpty()||nRoom==0||r.getNDoor()==4) return;
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
            }
        }
        else if (a==2){//due stanze aggiuntive

        }
        //altrimenti nessuna
    }*/
    private void setSonRoom(Cordinate son,Cordinate father,int dir,int type){
        map[son.getX()][son.getY()]=new Room();//crea una nuova stanza
        map[father.getX()][father.getY()].setIndexDoor(dir,true,map[son.getX()][son.getY()]);//collega la stanza corrente alla nuova
        map[son.getX()][son.getY()].setIndexDoor(((dir + 2) % 4),true,map[father.getX()][father.getY()]);//collega la nuova stanza
        map[son.getX()][son.getY()].setType(type);
        map[son.getX()][son.getY()].setPosition(son.getX(),son.getY());
    }
    private void setSonRoom(Cordinate father,int dir,int type){
        Cordinate son = new Cordinate(map[father.getX()][father.getY()].getDirRelativeCord(dir));
        map[son.getX()][son.getY()]=new Room();//crea una nuova stanza
        map[father.getX()][father.getY()].setIndexDoor(dir,true,map[son.getX()][son.getY()]);//collega la stanza corrente alla nuova
        map[son.getX()][son.getY()].setIndexDoor(((dir + 2) % 4),true,map[father.getX()][father.getY()]);//collega la nuova stanza
        map[son.getX()][son.getY()].setType(type);
        map[son.getX()][son.getY()].setPosition(son.getX(),son.getY());
    }
    public Room getRoot(){
        return map[15][15];
    }


    /*private Cordinate genExit(){
        Random r = new Random();
        Cordinate c = new Cordinate();
        c.x = r.nextInt(28);
        c.y=r.nextInt(28);
        if()
    }*/
}



