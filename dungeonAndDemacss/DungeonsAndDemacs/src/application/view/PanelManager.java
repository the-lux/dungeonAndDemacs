package application.view;

import application.GameLoop;
import application.config.AudioSettings;
import application.config.Settings;
import application.controller.*;
import application.model.Game;

import javax.swing.*;
import java.awt.*;

public class PanelManager {
    private static PanelManager instance = new PanelManager();
    private MainFrame mainFrame;
    private MenuPanel menuPanel;
    private WorldPanel worldPanel;
    private optionPanel OptionPanel;
    private CreditPanel creditPanel;
    private  TutorialPanel tutorialPanel;
    private WinPanel winPanel;
    private LosePanel losePanel;
    private JPanel emptyPanel;
    private CardLayout cardLayout=new CardLayout();
    private GameLoop gameLoop;
    private Sound audio;
    private PanelManager(){

    }
    public static PanelManager getInstance() {
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
        switchAudioIfNeeded();
        adjustAudio(0, AudioSettings.getVolumeMusica());
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
        ControlOptionPanel cOP = new ControlOptionPanel();
        cOP.setFocusable(true);
        OptionControlListener oCL = new OptionControlListener();
        cOP.setController(oCL);
        mainFrame.add(cOP);
        mainFrame.revalidate();
        mainFrame.repaint();
    }
    public void goCredit(){
        clear();
        creditPanel=new CreditPanel();
        creditPanel.setFocusable(true);
        CreditListener creditListener=new CreditListener();
        creditPanel.setController(creditListener);
        switchAudioIfNeeded();
        adjustAudio(0,AudioSettings.getVolumeMusica());
        mainFrame.add(creditPanel);
        mainFrame.revalidate();
        //mainFrame.repaint(); funziona lo stesso, si può togliere per maggiore efficienza?
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
    public void goOptionTutorial(){
        clear();
        tutorialPanel = new TutorialPanel();
        tutorialPanel.setFocusable(true);
        CreditListener creditListener=new CreditListener();
        tutorialPanel.setController(creditListener);
        mainFrame.add(tutorialPanel);
        mainFrame.revalidate();
    }
    public void goOptionVideo(){

    }
    public void goWord(){
        clear();
        mainFrame.setSize(Settings.WINDOW_SIZE,Settings.WINDOW_SIZE+40);
        clearAudio();
        System.out.println("word");
        emptyPanel= new JPanel();
        emptyPanel.setLayout(cardLayout);
        CharacterView cv=new CharacterView();
        worldPanel = new WorldPanel(cv);
        CharacterListener controller=new CharacterListener(worldPanel,cv);
        worldPanel.addKeyListener(controller);
        Game.restartGame();
        emptyPanel.add(worldPanel, "WorldPanel");
        winPanel=new WinPanel();
        losePanel=new LosePanel();
        WinLoseListener listener=new WinLoseListener();
        winPanel.setController(listener);
        losePanel.setController(listener);
        emptyPanel.add(winPanel, "WinPanel");
        emptyPanel.add(losePanel, "LosePanel");
        worldPanel.setFocusable(true);
        mainFrame.add(emptyPanel);
        cardLayout.show(emptyPanel,"WorldPanel");
        audio=new Sound("roomB.wav");
        audio.loop();
        adjustAudio(0,AudioSettings.getVolumeMusica());
        mainFrame.revalidate();
        mainFrame.repaint();
        if (gameLoop != null){
            gameLoop.stopGame();
        }
        gameLoop = new GameLoop(controller);
        gameLoop.startGame();
        worldPanel.requestFocusInWindow();
    }
    public void goLose(){

        audio=new Sound("lose.wav");
        audio.play();
        adjustAudio(0,AudioSettings.getVolumeMusica());
        cardLayout.show(emptyPanel,"LosePanel");
        losePanel.requestFocusInWindow();
    }
    public void goWin(){
        clearAudio();
        audio=new Sound("win.wav");
        audio.play();
        adjustAudio(0,AudioSettings.getVolumeMusica());
        cardLayout.show(emptyPanel,"WinPanel");
        winPanel.requestFocusInWindow();
    }

    private void clear(){
        if (mainFrame != null) {
            mainFrame.getContentPane().removeAll();
            mainFrame.revalidate();
            mainFrame.repaint();
        }
    }
    private void clearAudio(){
        if (audio != null){
            audio.pause();
        }
    }
    private void switchAudioIfNeeded(){
        if (audio==null || !audio.getClipName().equals("menu.wav")){
            clearAudio();
            audio=new Sound("menu.wav");
            audio.loop();
        }
    }
    public void adjustAudio(int oldVal, int newVal){
        audio.adjustAudio(oldVal, newVal);
    }
}
