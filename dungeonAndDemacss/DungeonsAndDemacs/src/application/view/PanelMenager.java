package application.view;

import application.GameLoop;
import application.controller.CharacterListener;

import java.awt.event.ComponentListener;

public class PanelMenager {
    private static PanelMenager instance = new PanelMenager();
    private MainMenu mainMenu;
    private MenuPanel menuPanel;
    private WorldPanel worldPanel;
    private PanelMenager(){

    }
    public static PanelMenager getInstance() {
        return instance;
    }
    public void start(MainMenu m){
        this.mainMenu=m;
        clear();
        menuPanel = new MenuPanel();
        mainMenu.add(menuPanel);
    }
    public void goMainMenu(){

    }
    public void goWord(){
        clear();
        worldPanel = new WorldPanel();
        mainMenu.add(worldPanel);
        worldPanel.setFocusable(true);
        CharacterListener controller=new CharacterListener(worldPanel);
        worldPanel.addKeyListener(controller);
        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.startGame();
    }
    private void clear(){
        mainMenu.removeAll();
        for (ComponentListener c : mainMenu.getComponentListeners()){
            mainMenu.removeComponentListener(c);
        }
    }
}
