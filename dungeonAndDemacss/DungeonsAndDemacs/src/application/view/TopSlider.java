package application.view;

import javax.swing.*;

public class TopSlider extends JSlider {
    private int type;
    public TopSlider(int min, int max) {
        super(min, max);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
