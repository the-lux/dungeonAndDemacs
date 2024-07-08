package application.view;

import javax.swing.*;

public class TopButton extends JButton {
    private final int type;
    public TopButton(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
