package pro1.dravingModel;

import java.awt.*;

public class Ellipse extends WidthHeightShape {
    private String color;   //#FF45EF

    // konstruktor
    public Ellipse(int x, int y, int height, int width, String color) {
        super(x, y, height, width);
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));    // nastaví barvu
        g.drawOval(x, y, width, height);    // nakreslí obdelník
        g.fillOval(x, y, width, height);    // vyplní obdelník

    }
}
