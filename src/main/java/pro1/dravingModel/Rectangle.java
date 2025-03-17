package pro1.dravingModel;

import java.awt.*;

public class Rectangle implements Drawable {
    private int x;
    private int y;
    private int height;
    private int width;
    private String color;   //#FF45EF

    // konstruktor
    public Rectangle(int x, int y, int height, int width, String color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));    // nastaví barvu
        g.drawRect(x, y, width, height);    // nakreslí obdelník
        g.fillRect(x, y, width, height);    // vyplní obdelník

    }


}


