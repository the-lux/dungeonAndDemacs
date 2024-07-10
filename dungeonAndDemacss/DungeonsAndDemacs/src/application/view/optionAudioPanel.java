package application.view;

import application.controller.OptionAudioActionListener;
import application.controller.OptionAudioChangeListener;

import javax.swing.*;
import java.awt.*;

public class optionAudioPanel extends JPanel {
    private JLabel opzAudioLabel;
    private JLabel generalLabel;
    private JLabel musicLabel;
    private JLabel effectLabel;
    private TopSlider generalSlider;
    private TopSlider musicSlider;
    private TopSlider effectSlider;
    private JButton exitButton;
    public optionAudioPanel () {
        opzAudioLabel = new JLabel();
        generalSlider = new TopSlider(-80, 6);
        generalLabel = new JLabel();
        musicLabel = new JLabel();
        musicSlider = new TopSlider(-80, 6);
        effectLabel = new JLabel();
        effectSlider = new TopSlider(-80, 6);
        //questo intervallo perchè la classe Sound va dall'intervallo -80(minimum) a 6 (maximum)
        exitButton = new JButton();

        setMaximumSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));
        setPreferredSize(new Dimension(600, 600));

        opzAudioLabel.setFont(new Font("Algerian", 0, 70)); // NOI18N
        opzAudioLabel.setHorizontalAlignment(SwingConstants.CENTER);
        opzAudioLabel.setText("Opzioni audio");
        opzAudioLabel.setForeground(Color.BLACK);

        generalSlider.setSnapToTicks(true);
        generalSlider.setName("generalAudio");
        generalSlider.setOpaque(false);
        generalSlider.setValue(0);
        generalSlider.setType(0);

        generalLabel.setFont(new Font("Algerian", 0, 36));
        generalLabel.setText("Generale");
        generalLabel.setForeground(Color.BLACK);

        musicLabel.setFont(new Font("Algerian", 0, 36));
        musicLabel.setText("Musica");
        musicLabel.setForeground(Color.BLACK);

        musicSlider.setSnapToTicks(true);
        musicSlider.setName("generalAudio");
        musicSlider.setOpaque(false);
        musicSlider.setValue(0);
        musicSlider.setType(1);

        effectLabel.setFont(new Font("Algerian", 0, 36));
        effectLabel.setText("Effetti");
        effectLabel.setForeground(Color.BLACK);

        effectSlider.setSnapToTicks(true);
        effectSlider.setName("generalAudio");
        effectSlider.setOpaque(false);
        effectSlider.setValue(0);
        effectSlider.setType(2);

        exitButton.setBackground(new Color(153, 153, 153));
        exitButton.setFont(new Font("Algerian", 0, 48));
        exitButton.setText("EXIT");
        exitButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2));
        exitButton.setFocusable(false);
        exitButton.setForeground(Color.BLACK);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(opzAudioLabel)
                                        .addComponent(effectLabel, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(generalLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(musicLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(generalSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(189, 189, 189)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(musicSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(effectSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(186, Short.MAX_VALUE)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
                                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(opzAudioLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(generalLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(generalSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(musicSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(musicLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(effectLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(effectSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(170, 170, 170)
                                .addComponent(exitButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
        );
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();
        // Crea un oggetto GradientPaint per il gradiente verticale
        GradientPaint gp = new GradientPaint(0, 0, new Color(240,22,14), 0, height, Color.black);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
    }
    public void setController(OptionAudioChangeListener optionAudioChangeListener, OptionAudioActionListener optionAudioActionListener){
        generalSlider.addChangeListener(optionAudioChangeListener);
        musicSlider.addChangeListener(optionAudioChangeListener);
        effectSlider.addChangeListener(optionAudioChangeListener);
        exitButton.addActionListener(optionAudioActionListener);
    }
}
