package application.model;

public class Game {

    public final static int MOVE_RIGHT = 0;
    public final static int MOVE_LEFT = 1;
    public final static int MOVE_UP = 2;
    public final static int MOVE_DOWN = 3;

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
        public boolean isAlive(int id) {
        return world.getEnemy(id).isAlive();
        }

}
