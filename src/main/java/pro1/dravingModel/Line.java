package pro1.dravingModel;

import java.awt.*;

public class Line  extends XYShape  {
    private int x2, y2;
    private int thickness;
    private String color;

    public Line(int x, int y, int x2, int y2, int thickness, String color) {
        super(x,y);
        this.x2 = x2;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
    }


    public void draw(Graphics2D g) {
        g.setColor(Color.decode(color));
        g.setStroke(new BasicStroke(thickness));
        g.drawLine(x, y, x2, y2);
    }
}
