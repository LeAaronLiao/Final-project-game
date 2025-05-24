import javax.swing.*;
import java.awt.*;

public class ImagePanel {
    private String imagePath;
    private JLabel image;
    private int x;
    private int y;
    private int width;
    private int height;

    public ImagePanel(int x, int y, int width, int height, String path) {
        super();
        this.x = x;
        this.y = y;
        this.imagePath = path;
        image = new JLabel();
        ImageIcon imgThisImg = new ImageIcon(path);
        Image scaled = imgThisImg.getImage().getScaledInstance(50, 50, Image.SCALE_FAST);
        image.setIcon(new ImageIcon(scaled));
        image.setBounds(x, y, width, height);
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
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public JLabel getImage() {
        return image;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public void draw() {
        this.image.setBounds(x, y, width, height);
        Javaswing.jframe.add(this.image);
    }
    public void draw(int x, int y, int width, int height) {
        setX(x);
        setY(y);
        setWidth(width);
        setHeight(height);
        this.image.setBounds(x, y, width, height);
        Javaswing.jframe.add(this.image);
    }
}
