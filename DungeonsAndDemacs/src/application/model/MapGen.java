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
            setSonRoom(next,current,dir);
            queue.add(current);//aggiunge alla coda le stanze principali
            current = new Cordinate(next);
        }
        map[current.x][current.y].setEnd(true);
    }
    private void genMoreRoom(int nRoom){
        while (nRoom>0&& !queue.isEmpty()){
            Cordinate current = queue.removeLast();
            Cordinate next;
            int randomNRoom = rN.nextInt(5-map[current.x][current.y].getNDoor());
            for (int i = 0; i < 4 && randomNRoom>0; i++) {
                //TODO c'è un while true
                next = map[current.x][current.y].getDirRelativeCord(i);
                if(map[next.x][next.y]==null){
                    setSonRoom(current,i);
                    queue.add(current);
                    randomNRoom --;
                    nRoom--;
                }
            }
        }
    }
    //metodo ricorsivo per generare le stanze aggiuntive
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
            }*/
        }
        else if (a==2){//due stanze aggiuntive

        }
        //altrimenti nessuna
    }
    private void setSonRoom(Cordinate son,Cordinate father,int dir){
        map[son.x][son.y]=new Room();//crea una nuova stanza
        map[father.x][father.y].setIndexDoor(dir,true,map[son.x][son.y]);//collega la stanza corrente alla nuova
        map[son.x][son.y].setIndexDoor(((dir + 2) % 4),true,map[father.x][father.y]);//collega la nuova stanza
        map[son.x][son.y].setPosition(son.x,son.y);
    }
    private void setSonRoom(Cordinate father,int dir){
        Cordinate son = new Cordinate(map[father.x][father.y].getDirRelativeCord(dir));
        map[son.x][son.y]=new Room();//crea una nuova stanza
        map[father.x][father.y].setIndexDoor(dir,true,map[son.x][son.y]);//collega la stanza corrente alla nuova
        map[son.x][son.y].setIndexDoor(((dir + 2) % 4),true,map[father.x][father.y]);//collega la nuova stanza
        map[son.x][son.y].setPosition(son.x,son.y);
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

