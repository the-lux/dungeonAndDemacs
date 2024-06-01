package application.model;


import application.config.Settings;

import java.util.Random;

public class World {

    private enum Block { EMPTY, WALL, ENEMY, CHARACTER,DOOR_UP,DOOR_DOWN,
        DOOR_LEFT, DOOR_RIGHT};
    private Block[][] blocks;

    private Character character;

    private int enemyNumber;

    private int enemyKilled=0;

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
                        blocks[0][i]=Block.DOOR_UP;
                    } break;
                    case 1: for (int i=15; i<25; i++){
                        blocks[i][blocks.length-1]=Block.DOOR_RIGHT;
                    } break;
                    case 2: for (int i=15; i<25; i++){
                        blocks[blocks.length-1][i]=Block.DOOR_DOWN;
                    } break;
                    case 3: for (int i=15; i<25; i++){
                        blocks[i][0]=Block.DOOR_LEFT;
                    } break;
                }
            }
            direzione++;
        }
        //crea il PG
        Random random=new Random();
        Cordinate playerCordinate;
        playerCordinate = new Cordinate(random.nextInt(1,blocks.length-1),random.nextInt(1,blocks.length-1));
        character= new Character(playerCordinate);
        blocks[playerCordinate.getX()][playerCordinate.getY()]=Block.CHARACTER;
        //crea i nemici
        if(room.getSizeEnemyArrayList()>0){
            for (Enemy e : room.getEnemyArrayList()){
                Cordinate c = e.getPlace();
                blocks[c.getX()][c.getY()]=Block.ENEMY;
            }
        }
        else {
            genEnemy(random.nextInt(10));
        }

    }
    private void genEnemy(int enemyNumber){
        Random random=new Random();
        for (int i=0; i<enemyNumber; i++){
            Cordinate enemyCordinate;
            do {
                enemyCordinate = new Cordinate(random.nextInt(1,blocks.length-1), random.nextInt(1,blocks.length-1));
            }while (!isEmpty(enemyCordinate));
            //sfrutto il do while per evitare che mi generi il nemico sovrascrivendo il personaggio
            int type=random.nextInt(1,4);
            room.addEnemy(new Enemy (enemyCordinate, type,i));
            blocks[enemyCordinate.getX()][enemyCordinate.getY()]=Block.ENEMY;
        }
    }
    public void changeRoom(Cordinate p){
        if (isUpDoor(p)){
            room=room.getIndexRoom(0);
        } else if (isRightDoor(p)){
            room=room.getIndexRoom(1);
        } else if (isDownDoor(p)){
            room=room.getIndexRoom(2);
        } else if (isLeftDoor(p)){
            room=room.getIndexRoom(3);
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
    public boolean isDoor(Cordinate p){
        return (isRightDoor(p)|| isUpDoor(p) || isDownDoor(p)||isLeftDoor(p));
    }
    public boolean isEnemy(Cordinate p){return isType(p,Block.ENEMY);}

    private boolean isInvalidPosition(Cordinate p) {
        return (p.getX() < 0 || p.getX() >= blocks.length || p.getY() < 0 || p.getY() >= blocks.length);
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
    public boolean roomCleaned(){
        return enemyKilled == enemyNumber;
    }
    public void moveCharacter(Cordinate p){
        //controllo che la posizione sia valida, e se è così lo faccio muovere
        if (!isInvalidPosition(p) && !isWall(p)  ){
            setType(character.getPlace(),Block.EMPTY);
            character.changePosition(p);
            setType(character.getPlace(),Block.CHARACTER);
        }

    }
    public void killEnemy(Cordinate target){
        if (isEnemy(target)){
            setType(target,Block.EMPTY);
            enemyKilled++;
        }
    }
    public void eliminatePlayer(){
        //il personaggio non esiste più sulla mappa
        character.killCharacter();
        setType(character.getPlace(),Block.EMPTY);

    }
}