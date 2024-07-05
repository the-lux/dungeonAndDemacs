package application.model;


import application.config.Settings;

import java.util.ArrayList;
import java.util.Random;

public class World {

    private enum Block { EMPTY, WALL, ENEMY, CHARACTER,DOOR_UP,DOOR_DOWN, DOOR_LEFT, DOOR_RIGHT, POWERUP};
    private Block[][] blocks;

    private Character character=new Character();
    private MapGen m=new MapGen();

    private Room room; //stanza corrente

    public World() {
        room=m.genMap(10); //creo la mappa, carico la root nella room
        genWorld(room); //passo alla funzione che genera il mondo


    }
    private void genWorld(Room r){
        blocks = new Block[Settings.WORLD_SIZE][Settings.WORLD_SIZE]; //Matrice che rappresenta
        //il mondo di gioco
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (i == 0 || i == blocks.length - 1 || j == 0 || j == blocks.length - 1)
                    blocks[i][j] = Block.WALL;
                else
                    blocks[i][j] = Block.EMPTY;
            }

        }
        int direzione=0; //tiene traccia di dove fare le porte: 0=su, 1=DX, 2=sotto, 3=sx
        for (boolean b: r.getDoors()){
            if (b){
                switch (direzione){
                    case 0: for(int i=15; i<25; i++){
                        blocks[i][0]=Block.DOOR_UP;
                    } break;
                    case 1: for (int i=15; i<25; i++){
                        blocks[blocks.length-1][i]=Block.DOOR_RIGHT;
                    } break;
                    case 2: for (int i=15; i<25; i++){
                        blocks[i][blocks.length-1]=Block.DOOR_DOWN;
                    } break;
                    case 3: for (int i=15; i<25; i++){
                        blocks[0][i]=Block.DOOR_LEFT;
                    } break;
                }
            }
            direzione++;
        }
        //crea il PG
        blocks[character.getPlace().getX()][character.getPlace().getY()]=Block.CHARACTER;
        //crea i nemici
        if(!room.getEnemyArrayList().isEmpty()){//TODO bisogna stare attenti in futuro pk se sconfiggiamo tutti i nemici potrebbe ricrearli se li togliamo dalla lista
            for (Enemy e : room.getEnemyArrayList()){
                Cordinate c = e.getPlace();
                blocks[c.getX()][c.getY()]=Block.ENEMY;
            }
        }
        else {
            genEnemy(room.getRoomType());
        }
        Random rand=new Random();
        int chance=rand.nextInt(0,100); //simulo una probabilità del 10%
        if (chance < 10){
            Cordinate powerUpPlace;
            do {
                powerUpPlace= new Cordinate(rand.nextInt(1, blocks.length-1),rand.nextInt(1, blocks.length-1));
            } while (isOccupied(powerUpPlace));
            int type=rand.nextInt(1,4);
            r.setpUp(new PowerUp(type));
            blocks [powerUpPlace.getX()][powerUpPlace.getY()]=Block.POWERUP;
        }
    }
    /* Stanze
    -1 empty
    0 Ianni
    1 fuduli
    2 Van Bon
    3 minion torpedine e associazione
    4 loot
    5 mercante
    */
    /* Nemici
    0 Ianni
    1 fuduli
    2 Van Bon
    3 Torpedine
    4 Associazioni
    */
    private void genEnemy(int type){
        Random random=new Random();
        if(type==3){
            for (int i=0; i<random.nextInt(10,15); i++){
                Cordinate enemyCordinate;
                do {
                    enemyCordinate = new Cordinate(random.nextInt(1,blocks.length-1), random.nextInt(1,blocks.length-1));
                }while (!isEmpty(enemyCordinate));
                //sfrutto il do while per evitare che mi generi il nemico sovrascrivendo il personaggio
                room.addEnemy(new Enemy (enemyCordinate, random.nextInt(3,5),i));
                blocks[enemyCordinate.getX()][enemyCordinate.getY()]=Block.ENEMY;
            }
        } else if (type>=0 && type<=2) {
            Cordinate enemyCordinate;
            do {
                enemyCordinate = new Cordinate(random.nextInt(1,blocks.length-1), random.nextInt(1,blocks.length-1));
            }while (!isEmpty(enemyCordinate));
            //sfrutto il do while per evitare che mi generi il nemico sovrascrivendo il personaggio
            room.addEnemy(new Enemy (enemyCordinate, 0,0));
            blocks[enemyCordinate.getX()][enemyCordinate.getY()]=Block.ENEMY;
        }
    }
    public void changeRoom(Cordinate p){
        if (isUpDoor(p)){
            room=room.getIndexRoom(0);
            character.changePosition(new Cordinate(p.getX(),blocks.length-2));
        } else if (isRightDoor(p)){
            room=room.getIndexRoom(1);
            character.changePosition(new Cordinate(1,p.getY()));
        } else if (isDownDoor(p)){
            room=room.getIndexRoom(2);
            character.changePosition(new Cordinate(p.getX(),1));
        } else if (isLeftDoor(p)){
            room=room.getIndexRoom(3);
            character.changePosition(new Cordinate(blocks.length-2,p.getY()));
        }
        genWorld(room);
    }
    private boolean isType(Cordinate p, Block block) {
        if(isInvalidPosition(p))
            throw new IllegalArgumentException("Invalid position " + p);
        return blocks[p.getX()][p.getY()] == block;
    }

    private void setType(Cordinate p, Block type) {
        if(isInvalidPosition(p))
            throw new IllegalArgumentException("Invalid position " + p);
        blocks[p.getX()][p.getY()] = type;
    }
    public void setEnemy(Cordinate p){
        if(isInvalidPosition(p))
            throw new IllegalArgumentException("Invalid position " + p);
        blocks[p.getX()][p.getY()] = Block.ENEMY;
    }
    public boolean isWall(Cordinate p) {
        return isType(p, Block.WALL);
    }

    public boolean isEmpty(Cordinate p) {
        return isType(p, Block.EMPTY);
    }
    public boolean isCharacter(Cordinate p){return isType(p,Block.CHARACTER);}
    public boolean isRightDoor(Cordinate p) {return isType(p,Block.DOOR_RIGHT);}
    public boolean isLeftDoor(Cordinate p) {return isType(p,Block.DOOR_LEFT);}
    public boolean isUpDoor (Cordinate p) {return isType(p,Block.DOOR_UP);}
    public boolean isDownDoor(Cordinate p) {return isType(p,Block.DOOR_DOWN);}
    public boolean isPowerUp (Cordinate p) {return isType(p,Block.POWERUP);}
    public boolean isDoor(Cordinate p){
        return (isRightDoor(p)|| isUpDoor(p) || isDownDoor(p)||isLeftDoor(p));
    }
    public boolean isEnemy(Cordinate p){return isType(p,Block.ENEMY);}

    private boolean isInvalidPosition(Cordinate p) {
        return (p.getX() < 0 || p.getX() >= blocks.length || p.getY() < 0 || p.getY() >= blocks.length);
    }
    public boolean isOccupied(Cordinate p){
        //viene usata dalla generazione dei powerup
        return isCharacter(p) || isDoor (p) || isEnemy(p) || isWall(p);
    }
    public boolean isAlreadyUsed(Cordinate p){
        return isEnemy(p)||isDoor(p)||isWall(p)||isPowerUp(p);
    }
    public int getSize() {
        return blocks.length;
    }

        /*public int getEnemyNumber() {
            return enemyNumber;
        }
         */

    public Character getCharacter (){
        return character;
    }
    public Room getRoom() {
        return room;
    }
    public boolean roomCleaned(){
        return room.isAllDefeated();
    }
    public void moveCharacter(Cordinate p){
        //controllo che la posizione sia valida, e se è così lo faccio muovere
        if (!isInvalidPosition(p) && !isWall(p)  && !isEnemy(p) ){
            setType(character.getPlace(),Block.EMPTY);
            character.changePosition(p);
            setType(character.getPlace(),Block.CHARACTER);
        }

    }
    public void enemyMovement(){
        ArrayList<Enemy> list=room.getEnemyArrayList();
        for (Enemy e: list){
            int type=e.getEnemyType();
            if (type==1){
                e.standardMove();
            } else{
                if (checkForPlayer(e.getPlace(),e.getView())){
                    e.smartMove(character.getPlace());
                } else {
                    e.standardMove();
                }

            }
        }
        manageEnemy();
    }

    public boolean checkForPlayer(Cordinate enemyPosition,int raggio){
        //La funzione verifica che nei dintorni del nemico ci sia il player
        //qui inizializzo il punto d'inizio e fine di ricerca, impostando lower bound e upper bound per non sforare.
        int beginX=enemyPosition.getX()-raggio;
        if (beginX < 0) beginX = 0;
        int beginY= enemyPosition.getY()-raggio;
        if (beginY<0) beginY = 0;
        int endX=enemyPosition.getX()+raggio;
        if (endX > blocks.length-1) endX = blocks.length - 1;
        int endY= enemyPosition.getY()+raggio;
        if (endY > blocks.length-1) endY = blocks.length - 1;
        //se raggio=1 non ho problemi coi muri, diversamente devo pensare un meccanismo per impedirmi di vedere attraverso
        for (int x=beginX; x<=endX; x++) {
            for (int y =beginY; y <= endY; y++) {
                if (isCharacter(new Cordinate(x, y))) return true;
                }
        }

        return false;
    }
    public void killEnemy(Cordinate target){
        if (isEnemy(target)){
            setType(target,Block.EMPTY);
            room.removeEnemy(target);
        }
    }
    public void manageEnemy(){
        ArrayList<Enemy> list=room.getEnemyArrayList();
        //System.out.println("Posizione del player x"+character.getPlace().getX()+"y:"+character.getPlace().getY());
        for (Enemy e: list){
            Cordinate posizione=e.getPlace();
            //System.out.println("Posizione del nemico x:"+posizione.getX()+"y:"+posizione.getY());
            if (posizione.equals(character.getPlace())){
                System.out.println("Vita attuale:"+character.getHealth());
                character.updateHealth(-1);
                System.out.println("Vita dopo il contatto:"+character.getHealth());
                if (character.getHealth() <= 0){
                    this.eliminatePlayer();
                } else {
                    e.undoMove();
                }
            }
            else if (isAlreadyUsed(posizione)){
                e.undoMove();
            }
            //qui metto la posizione vecchia a empty e la nuova a enemy: se il movimento risulta essere non valido
            //oldPlace e place avranno lo stesso valore
            setType(e.getOldPlace(),Block.EMPTY);
            setType(e.getPlace(),Block.ENEMY);
        }
    }
    public void eliminatePlayer(){
        //il personaggio non esiste più sulla mappa
        character.killCharacter();
        setType(character.getPlace(),Block.EMPTY);

    }
    public void usePowerUp(){
        room.getpUp().effect();
    }
}