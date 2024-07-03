package application;

import application.controller.CharacterListener;
import application.model.Character;

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
        //TODO: bug su multipli nemici (si rigenerano)
    }
}
