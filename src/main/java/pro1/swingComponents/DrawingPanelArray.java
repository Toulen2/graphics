package pro1.swingComponents;

import pro1.dravingModel.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
* zkouška uděláni seznamu pro stromy
* */
public class DrawingPanelArray extends JPanel {
    ArrayList<Drawable> drawables;

    public DrawingPanelArray(ArrayList<Drawable> drawables) {
        this.drawables = drawables;
        setBackground(Color.WHITE);
    }

    public void paintComponentArray(Graphics g) {
        super.paintComponent(g);
        g.translate(550, 200);

        for (Drawable d : drawables) {
            d.draw((Graphics2D) d);
        }
    }

    public void setImageArray(Drawable image) {
        this.drawables.add(image);
        repaint();
    }
}
