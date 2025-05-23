import javax.swing.*;
import java.awt.*;

public class RectanglePanel extends JPanel {
    private int x = 0;
    private int y = 0;
    private Color color;
    public RectanglePanel(int x, int y, int width, int height, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
        setBounds(x, y, width, height);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    // getWidth and getHeight are inherited from JPanel, they aren't needed
    public void setWidth(int width) {
        setBounds(x, y, width, getHeight());
    }
    public void setHeight(int height) {
        setBounds(x, y, getWidth(), height);
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1); // x, y, width, height
    }
}