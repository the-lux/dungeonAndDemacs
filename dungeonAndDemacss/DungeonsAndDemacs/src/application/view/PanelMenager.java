package application.view;

import application.GameLoop;
import application.controller.CharacterListener;
import application.controller.MenuListener;
import application.controller.OptionListener;

import java.awt.*;
import java.awt.event.ComponentListener;

public class PanelMenager {
    private static PanelMenager instance = new PanelMenager();
    private MainFrame mainFrame;
    private MenuPanel menuPanel;
    private WorldPanel worldPanel;
    private optionPanel OptionPanel;

    private PanelMenager(){

    }
    public static PanelMenager getInstance() {
        return instance;
    }
    public void start(MainFrame m){
        this.mainFrame =m;
        goMenu();
    }
    public void goMenu(){
        clear();
        menuPanel = new MenuPanel();
        mainFrame.add(menuPanel);
        menuPanel.setFocusable(true);
        MenuListener controller = new MenuListener();
        menuPanel.setController(controller);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void goOption(){
        clear();
        OptionPanel = new optionPanel();
        OptionPanel.setFocusable(true);
        OptionListener op = new OptionListener();
        OptionPanel.setController(op);
        mainFrame.add(OptionPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void goOptionControl(){
    }
    public void goCredit(){

    }
    public void exit(){

    }
    public void goOptionAdio(){

    }
    public void goWord(){
        clear();
        System.out.println("word");
        worldPanel = new WorldPanel();
        worldPanel.setFocusable(true);
        CharacterListener controller=new CharacterListener(worldPanel);
        worldPanel.addKeyListener(controller);
        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.startGame();
        mainFrame.add(worldPanel);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private void clear(){
        if (mainFrame != null) {
            mainFrame.getContentPane().removeAll();
            mainFrame.revalidate();
            mainFrame.repaint();
        }
    }
}
