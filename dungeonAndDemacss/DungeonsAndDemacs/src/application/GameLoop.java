package application;

import application.controller.CharacterListener;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameLoop {
    private final CharacterListener controller;
    private ScheduledExecutorService executorService = null;
    public GameLoop(CharacterListener controller) {
        this.controller = controller;
    }

    public void startGame() {
        if(executorService != null)
            return;
        executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(controller::update, 0, 800, TimeUnit.MILLISECONDS);
    }
    public void stopGame(){
        if (executorService != null && !executorService.isShutdown()){
            executorService.shutdownNow();
            try {
                if (!executorService.awaitTermination(1,TimeUnit.SECONDS)){
                    System.err.println("L'esecutore ha impiegato troppo a terminare");
                }
            } catch (InterruptedException e){
                System.err.println("Processo di terminazione interrotto");
                Thread.currentThread().interrupt();
            }
            executorService=null;
        }

    }
}
