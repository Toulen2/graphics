package pro1.swingComponents;

import pro1.dravingModel.Drawable;

import javax.swing.*;
import java.awt.*;


public class DrawingPanel extends JPanel {
    Drawable image;
    public DrawingPanel(Drawable image) {
        this.image = image;
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(400, 400);                  // posune bod, od kterýho se vykresluje
        g.drawLine(-2000, 0, 2000, 0); // osa X
        g.drawLine(0, -2000, 0, 2000); // osa y
        image.draw((Graphics2D)g);
    }
}
