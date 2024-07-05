package application.model;

public class Game {

    public final static int MOVE_RIGHT = 0;
    public final static int MOVE_LEFT = 1;
    public final static int MOVE_UP = 2;
    public final static int MOVE_DOWN = 3;
    public static int speed = 1;

    private static Game game = null;

    private static boolean win;
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
    public void updateFacing(int direction){
        //System.out.println("Sto cambiando direzione in:"+ direction); stampa provvisoria per debug
        world.getCharacter().changeFacing(direction);
    }
    public void move(int direction){
        Cordinate newP = switch (direction) {
            case MOVE_RIGHT -> new Cordinate(world.getCharacter().getPlace().getX() + speed, world.getCharacter().getPlace().getY());
            case MOVE_LEFT -> new Cordinate(world.getCharacter().getPlace().getX() - speed, world.getCharacter().getPlace().getY());
            case MOVE_UP -> new Cordinate(world.getCharacter().getPlace().getX() , world.getCharacter().getPlace().getY()-speed);
            case MOVE_DOWN ->new Cordinate(world.getCharacter().getPlace().getX() , world.getCharacter().getPlace().getY()+speed);
            default -> null;
        };
        //if per evitare comportamenti anomali della funzione
        if (newP == null)
            return;
        if (world.isEnemy(newP)){
            world.eliminatePlayer();
        }
        //aggiorno qui per non perdere il facing corretto se cambio stanza
        if (world.isPowerUp(newP)){
            world.usePowerUp();
        }
        if (world.isDoor(newP)){
            world.changeRoom(newP);
            return;
        }

        if (world.getCharacter().isAlive()) {
            world.moveCharacter(newP);
        }
    }
    public void meleeAttack() {
        Cordinate target=world.getCharacter().getPlace(); //ricavo la posizione dell'attacco
        switch(world.getCharacter().getFacing()){
            case MOVE_RIGHT->target=new Cordinate(target.getX()+1, target.getY());
            case MOVE_LEFT ->target=new Cordinate(target.getX()-1, target.getY());
            case MOVE_DOWN ->target=new Cordinate(target.getX(), target.getY()+1);
            case MOVE_UP ->target=new Cordinate(target.getX(), target.getY()-1);
            default-> target=null;
        }
        world.killEnemy(target);
        //TODO: Condizione non valida, da aggiornare.
        if (world.roomCleaned()){
            win=true;
        }
    }
    public void update(){
        world.enemyMovement();
    }
}