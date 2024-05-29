package application.model;

public class Game {

    public final static int MOVE_RIGHT = 0;
    public final static int MOVE_LEFT = 1;
    public final static int MOVE_UP = 2;
    public final static int MOVE_DOWN = 3;

    private int facing=0;

    private static Game game = null;

    private boolean win;
    private final World world;

    private Game() {
        win = false;
        world = new World();
    }

    public World getWorld() {
            return world;
        }

        public static Game getGame() {
                if (game == null) {
                    game = new Game();
                }
                return game;
        }

        public static void restartGame() {
            game = new Game();
        }

        public boolean win() {
            return win;
        }
        public boolean isAlive() {return world.getCharacter().isAlive();}
        public void move(int direction){
            Cordinate newP = switch (direction) {
                case MOVE_RIGHT -> new Cordinate(world.getCharacter().getPlace().getX() + 1, world.getCharacter().getPlace().getY());
                case MOVE_LEFT -> new Cordinate(world.getCharacter().getPlace().getX() - 1, world.getCharacter().getPlace().getY());
                case MOVE_UP -> new Cordinate(world.getCharacter().getPlace().getX() , world.getCharacter().getPlace().getY()-1);
                case MOVE_DOWN ->new Cordinate(world.getCharacter().getPlace().getX() , world.getCharacter().getPlace().getY()+1);
                default -> null;
            };
            //if per evitare comportamenti anomali della funzione
            if (newP == null)
                return;
            if (world.isEnemy(newP)){
                world.eliminatePlayer();
            }
            facing= switch (direction){
                case MOVE_RIGHT -> MOVE_RIGHT;
                case MOVE_LEFT -> MOVE_LEFT;
                case MOVE_UP -> MOVE_UP;
                case MOVE_DOWN ->MOVE_DOWN;
                default -> facing;
            };
            if (world.getCharacter().isAlive()) {
                world.moveCharacter(newP);
            }
        }
        public void meleeAttack() {
            Cordinate target=world.getCharacter().getPlace(); //ricavo la posizione dell'attacco
            switch(facing){
                case MOVE_RIGHT->target=new Cordinate(target.getX()+1, target.getY());
                case MOVE_LEFT ->target=new Cordinate(target.getX()-1, target.getY());
                case MOVE_DOWN ->target=new Cordinate(target.getX(), target.getY()+1);
                case MOVE_UP ->target=new Cordinate(target.getX(), target.getY()-1);
                default-> target=null;
            }
            world.killEnemy(target);
            if (world.roomCleaned()){
                win=true;
            }
        }

}