package pro1.dravingModel;

import java.awt.*;

public class Line implements Drawable {
    private int x1, y1, x2, y2;
    private int thickness;
    private String color;

    public Line(int x1, int y1, int x2, int y2, int thickness, String color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
    }


    public void draw(Graphics2D g) {
        g.setColor(Color.black);
        g.setStroke(new BasicStroke(thickness));
        g.drawLine(x1, y1, x2, y2);
    }
}
