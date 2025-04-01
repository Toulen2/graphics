package pro1.dravingModel;

import java.awt.*;

public class Tree extends WidthHeightShape {
    private String color;

    public Tree(int x, int y, int height, int width, String color) {
        super(x, y, height, width);
        this.color = color;
    }

    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));
        g.fillRect(x, y, width / 10, height);
        g.fillOval(x - (9 * width / 20), y - height / 2, width, width);    // width je v height, aby to byla kružnice
    }
}
