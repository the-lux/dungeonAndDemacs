package application.view;

import application.GameLoop;
import application.config.Settings;
import application.controller.*;
import application.model.Game;

public class PanelMenager {
    private static PanelMenager instance = new PanelMenager();
    private MainFrame mainFrame;
    private MenuPanel menuPanel;
    private WorldPanel worldPanel;
    private optionPanel OptionPanel;
    private ControlOptionPanel cOP;

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
        clear();
        cOP = new ControlOptionPanel();
        cOP.setFocusable(true);
        OptionControlListener oPL = new OptionControlListener();
        cOP.setController(oPL);
        mainFrame.add(cOP);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void goCredit(){
        //todo completare
    }
    public void close(){
        //mainFrame.dispose();
        System.exit(0);
    }
    public void goOptionAudio(){
        clear();
        optionAudioPanel op = new optionAudioPanel();
        op.setFocusable(true);
        OptionAudioChangeListener oAL = new OptionAudioChangeListener();
        OptionAudioActionListener oAAL = new OptionAudioActionListener();
        op.setController(oAL,oAAL);
        mainFrame.add(op);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void goOptionLanguage(){

    }
    public void goOptionVideo(){

    }
    public void goWord(){
        clear();
        System.out.println("word");
        CharacterView cV = new CharacterView();
        worldPanel = new WorldPanel(cV);
        worldPanel.setFocusable(true);
        CharacterListener controller=new CharacterListener(worldPanel,cV);
        worldPanel.addKeyListener(controller);
        mainFrame.add(worldPanel);
        worldPanel.requestFocusInWindow();
        mainFrame.setSize(Settings.WINDOW_SIZE,Settings.WINDOW_SIZE+40);
        mainFrame.revalidate();
        mainFrame.repaint();
        Game.restartGame();
        GameLoop gameLoop = new GameLoop(controller);
        gameLoop.startGame();
    }

    private void clear(){
        if (mainFrame != null) {
            mainFrame.getContentPane().removeAll();
            mainFrame.revalidate();
            mainFrame.repaint();
        }
    }
}
