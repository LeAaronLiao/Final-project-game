import javax.swing.*;
import java.awt.*;

public class LinePanel extends JPanel {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    public LinePanel(int x1, int y1, int x2, int y2, Color color) {
        super();
        this.color = color;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        setBounds(x1, y1, x2-x1, y2-y1);
        setOpaque(false);
    }
    // had to whip out desmos to get this figured out
    // https://www.desmos.com/geometry/sgpfidafgx
    public LinePanel(int x, int y, int x2, int y2, int len, Color color) {
        super();
        this.color = color;
        this.x1 = x;
        this.y1 = y;
        int xlen = x2 - x1;
        int ylen = y2 - y1;
        double d = Math.sqrt(xlen*xlen + ylen*ylen);
        this.x2 = (int)(len * (xlen/d) + x);
        x2 = this.x2;
        this.y2 = (int)(len * (ylen/d) + y);
        y2 = this.y2;
        int minX = Math.min(x1, x2);
        int minY = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        setBounds(minX, minY, width + 1, height + 1);
        setOpaque(false);
    }
    public Point getP1() {
        return new Point(x1, y1);
    }
    public void setP1(int x, int y) {
        this.x1 = x;
        this.y1 = y;
    }
    public Point getP2() {
        return new Point(x2, y2);
    }
    public void setP2(int x, int y) {
        this.x2 = x;
        this.y2 = y;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public double getSlope() {
        return (double)(y2 - y1) / (x2 - x1);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(this.color);
        ((Graphics2D)g).setStroke(new BasicStroke(2));
        if( (y2-y1) * (x2-x1) < 0 ) {
            g.drawLine(Math.abs(x2-x1), 0, 0, Math.abs(y2-y1));
        } else {
            g.drawLine(0, 0, Math.abs(x2-x1), Math.abs(y2-y1));
        }
    }
}
