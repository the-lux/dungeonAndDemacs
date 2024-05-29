package application.model;


import application.config.Settings;

import java.util.Random;

    public class World {

        private enum Block { EMPTY, WALL, ENEMY_RED, ENEMY_YELLOW, ENEMY_BLUE, CHARACTER,DOOR};
        private final Block[][] blocks;
        private final Enemy[] enemies;

        private final Character character;

        private final int enemyNumber;

        private int enemyKilled=0;



        public World() {
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
            Random r=new Random();
            Cordinate playerCordinate;
            playerCordinate = new Cordinate(r.nextInt(1,blocks.length-1),r.nextInt(1,blocks.length-1));
            character= new Character(playerCordinate);
            blocks[playerCordinate.getX()][playerCordinate.getY()]=Block.CHARACTER;
            enemyNumber=r.nextInt(1,10);
            enemies=new Enemy[enemyNumber];
            for (int i=0; i<enemyNumber; i++){
                Cordinate enemyCordinate;
                do {
                    enemyCordinate = new Cordinate(r.nextInt(1,blocks.length-1), r.nextInt(1,blocks.length-1));
                }while (isCharacter(enemyCordinate));
                //sfrutto il do while per evitare che mi generi il nemico sovrascrivendo il personaggio
                int type=r.nextInt(1,4);
                enemies[i]= new Enemy (enemyCordinate, type,i);
                switch (type){
                    case 1:
                        blocks[enemyCordinate.getX()][enemyCordinate.getY()]=Block.ENEMY_RED;
                        break;
                    case 2:
                        blocks[enemyCordinate.getX()][enemyCordinate.getY()]=Block.ENEMY_YELLOW;
                        break;
                    case 3:
                        blocks[enemyCordinate.getX()][enemyCordinate.getY()]=Block.ENEMY_BLUE;
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo non valido");
                }
            }

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
        public boolean isWall(Cordinate p) {
            return isType(p, Block.WALL);
        }

        public boolean isEmpty(Cordinate p) {
            return isType(p, Block.EMPTY);
        }
        public boolean isRedEnemy(Cordinate p){return isType(p,Block.ENEMY_RED);}
        public boolean isYellowEnemy(Cordinate p){return isType(p,Block.ENEMY_YELLOW);}
        public boolean isBlueEnemy(Cordinate p){return isType(p,Block.ENEMY_BLUE);}
        public boolean isCharacter(Cordinate p){return isType(p,Block.CHARACTER);}
        public boolean isEnemy(Cordinate p){
            return isYellowEnemy(p) || isBlueEnemy(p) || isRedEnemy(p);
        }
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

        public Enemy getEnemy(int id) {
                return enemies[id];}
        public Character getCharacter (){
            return character;
        }
        public boolean roomCleaned(){
            return enemyKilled == enemyNumber;
        }
        public void moveCharacter(Cordinate p){
            //controllo che la posizione sia valida, e se è così lo faccio muovere
            if (!isInvalidPosition(p) && !isWall(p) ){
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
