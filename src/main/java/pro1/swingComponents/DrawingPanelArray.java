package pro1.swingComponents;

import pro1.dravingModel.Drawable;
import pro1.dravingModel.Tree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
/*
* zkouška uděláni seznamu pro stromy
* */
public class DrawingPanelArray extends JPanel {
    ArrayList<Tree> trees = new ArrayList<Tree>();

    public DrawingPanelArray(Tree t) {
        this.trees.add( t);
        repaint();
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.translate(550, 200);

        for (Tree d : trees) {
            d.draw((Graphics2D) g);
        }
    }

    public void setImage(Tree image) {
        this.trees.add(image);
        repaint();
    }
    public void clear() {
        trees.clear();
        repaint();
    }
}
