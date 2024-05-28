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
            Position newP = switch (direction) {
                case MOVE_RIGHT -> new Position(world.getCharacter().getPlace().x() + 1, world.getCharacter().getPlace().y());
                case MOVE_LEFT -> new Position(world.getCharacter().getPlace().x() - 1, world.getCharacter().getPlace().y());
                case MOVE_UP -> new Position(world.getCharacter().getPlace().x() , world.getCharacter().getPlace().y()-1);
                case MOVE_DOWN ->new Position(world.getCharacter().getPlace().x() , world.getCharacter().getPlace().y()+1);
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
            Position target=world.getCharacter().getPlace(); //ricavo la posizione dell'attacco
            switch(facing){
                case MOVE_RIGHT->target=new Position(target.x()+1, target.y());
                case MOVE_LEFT ->target=new Position(target.x()-1, target.y());
                case MOVE_DOWN ->target=new Position(target.x(), target.y()+1);
                case MOVE_UP ->target=new Position(target.x(), target.y()-1);
                default-> target=null;
            }
            world.killEnemy(target);
            if (world.roomCleaned()){
                win=true;
            }
        }

}
