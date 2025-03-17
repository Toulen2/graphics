package pro1.swingComponents;

import pro1.dravingModel.Drawable;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame(Drawable example) {
        this.setTitle("PRO1 Graphics");     // this ukazuje, že to je zděděné
        this.setVisible(true);
        this.setSize(800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        add(new DrawingPanel(example));
    }
}
