import javax.swing.*;
import java.awt.*;

public class CirclePanel extends JPanel {
    private int radius;
    private int x;
    private int y;
    private Color color;

    public CirclePanel(int x, int y, int radius, Color color) {
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.color = color;
        setBounds(x-radius, y-radius, radius * 2, radius * 2);
        setOpaque(false);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.fillOval(0, 0, radius * 2, radius * 2);
    }
    public void setRadius(int radius) {
        this.radius = radius;
        setBounds(x-radius, y-radius, radius * 2, radius * 2);
    }
    public void setX(int x) {
        this.x = x;
        setBounds(x-radius, y-radius, radius * 2, radius * 2);
    }
    public void setY(int y) {
        this.y = y;
        setBounds(x-radius, y-radius, radius * 2, radius * 2);
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public int getRadius() {
        return radius;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Color getColor() {
        return color;
    }
    public boolean colliding(Entity e) {
        int x1 = this.x - radius;
        int y1 = this.y - radius;
        int size1 = radius * 2;
        int x2 = e.getX();
        int y2 = e.getY();
        int size2 = e.getRect().getWidth();
        return x1 < x2 + size2 &&
           x1 + size1 > x2 &&
           y1 < y2 + size2 &&
           y1 + size1 > y2;
    }
}
