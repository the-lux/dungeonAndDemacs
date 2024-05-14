package application.model;


import application.config.Settings;

import java.util.Random;

    public class World {

        private enum Block { EMPTY, WALL, ENEMY_RED, ENEMY_YELLOW, ENEMY_BLUE}
        private final Block[][] blocks;
        private final Enemy[] enemies;

        private final int enemyNumber;

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
            enemyNumber=r.nextInt(1,10);
            enemies=new Enemy[enemyNumber];
            for (int i=0; i<enemyNumber; i++){
                Position enemyPosition;
                do {
                    enemyPosition = new Position(r.nextInt(blocks.length), r.nextInt(blocks.length));
                }while (isWall(enemyPosition));
                //sfrutto il do while per evitare che mi generi il nemico sul muro
                int type=r.nextInt(1,4);
                enemies[i]= new Enemy (enemyPosition, type,i);
                switch (type){
                    case 1:
                        blocks[enemyPosition.x()][enemyPosition.y()]=Block.ENEMY_RED;
                        break;
                    case 2:
                        blocks[enemyPosition.x()][enemyPosition.y()]=Block.ENEMY_YELLOW;
                        break;
                    case 3:
                        blocks[enemyPosition.x()][enemyPosition.y()]=Block.ENEMY_BLUE;
                        break;
                    default:
                        throw new IllegalArgumentException("Tipo non valido");
                };
            }


        }
        private boolean isType(Position p, Block block) {
            if(isInvalidPosition(p))
                throw new IllegalArgumentException("Invalid position " + p);
            return blocks[p.x()][p.y()] == block;
        }

        private void setType(Position p, Block type) {
            if(isInvalidPosition(p))
                throw new IllegalArgumentException("Invalid position " + p);
            blocks[p.x()][p.y()] = type;
        }
        public boolean isWall(Position p) {
            return isType(p, Block.WALL);
        }

        public boolean isEmpty(Position p) {
            return isType(p, Block.EMPTY);
        }
        public boolean isRedEnemy(Position p){return isType(p,Block.ENEMY_RED);}
        public boolean isYellowEnemy(Position p){return isType(p,Block.ENEMY_YELLOW);}
        public boolean isBlueEnemy(Position p){return isType(p,Block.ENEMY_BLUE);}
        private boolean isInvalidPosition(Position p) {
            return (p.x() < 0 || p.x() >= blocks.length || p.y() < 0 || p.y() >= blocks.length);
        }
        public int getSize() {
            return blocks.length;
        }

        public int getEnemyNumber() {
            return enemyNumber;
        }

        public Enemy getEnemy(int id) {
                return enemies[id];}
    }
