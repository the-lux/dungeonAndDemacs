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
            setSonRoom(next,current,dir);
            queue.add(current);//aggiunge alla coda le stanze principali
            //TODO inserisce delle stanze alternate tra: stanze con molti minion, un miniboss(or prof depotenziato),
            current = new Cordinate(next);
        }
        queue.add(next);
        map[current.getX()][current.getY()].setEnd(true);//setta la stanza finale
        //TODO inserisce il boss finale
    }
    /*
    -1 empty
    0 Ianni
    1 fuduli
    2 Van Bon
    3 minion
    4 loot
    5 mercante
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
                        setSonRoom(current,i);
                        queue.add(current);
                        //TODO aggiunge stanze tra: un miniboss(or prof depotenziato) 50/50 con stanza molti minion,
                        // stanze tesoro (prob più bassa)

                        randomNRoom --;
                        nRoom--;
                    }
                }
            }
        }
        //aggiunge alla fine una stanza del tesoro sicura
    }
    /*metodo ricorsivo per generare le stanze aggiuntive
    private void genMoreRoom(int nRoom,Room r){
        if(r.isEmpty()||nRoom==0||r.getNDoor()==4) return;
        int a =rN.nextInt(3);
        Cordinate current = new Cordinate(r.getPosition());
        if(a==1){//una sola stanza aggiuntiva
            if(map[current.getX()--][current.getY()]==null){//sopra

            }
            else if(map[current.getX()][current.getY()++]==null){//destra

            }
            else if(map[current.getX()++][current.getY()]==null){//sotto

            }
            else if(map[current.getX()][current.getY()--]==null){//sinistra

            }
            /*for(int i=0; i<4;i++){
                if(!r.getDoors()[i]){
                    map[r.getPosition().getX()][r.getPosition().getY()]
                }
            }
        }
        else if (a==2){due stanze aggiuntive

        }
        altrimenti nessuna
    }*/
    private void setSonRoom(Cordinate son,Cordinate father,int dir){
        map[son.getX()][son.getY()]=new Room();//crea una nuova stanza
        map[father.getX()][father.getY()].setIndexDoor(dir,true,map[son.getX()][son.getY()]);//collega la stanza corrente alla nuova
        map[son.getX()][son.getY()].setIndexDoor(((dir + 2) % 4),true,map[father.getX()][father.getY()]);//collega la nuova stanza
        map[son.getX()][son.getY()].setPosition(son.getX(),son.getY());//setta la posizione del figlio
    }
    private void setSonRoom(Cordinate father,int dir){
        Cordinate son = new Cordinate(map[father.getX()][father.getY()].getDirRelativeCord(dir));
        map[son.getX()][son.getY()]=new Room();//crea una nuova stanza
        map[father.getX()][father.getY()].setIndexDoor(dir,true,map[son.getX()][son.getY()]);//collega la stanza corrente alla nuova
        map[son.getX()][son.getY()].setIndexDoor(((dir + 2) % 4),true,map[father.getX()][father.getY()]);//collega la nuova stanza
        map[son.getX()][son.getY()].setPosition(son.getX(),son.getY());
    }

    public Room getRoot(){
        return map[15][15];
    }

    public Room getCordRoom(Cordinate c){
        return map[c.getX()][c.getY()];
    }

    /*private Cordinate genExit(){
        Random r = new Random();
        Cordinate c = new Cordinate();
        c.getX() = r.nextInt(28);
        c.getY()=r.nextInt(28);
        if()
    }*/
}

