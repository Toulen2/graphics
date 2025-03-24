package pro1.dravingModel;

import java.awt.*;

public class Rectangle extends WidthHeightShape {
    private String color;   //#FF45EF

    // konstruktor
    public Rectangle(int x, int y, int height, int width, String color) {
        super(x, y, height, width);     // super se využívá u dědění
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));    // nastaví barvu
        g.drawRect(x, y, width, height);    // nakreslí obdelník
        g.fillRect(x, y, width, height);    // vyplní obdelník
        g.drawString("AHOJ", x, y);     // vykreslení stringu

    }


}


