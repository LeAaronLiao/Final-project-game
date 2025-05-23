import javax.swing.*;
import java.awt.*;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private String imagePath;
    private Image image;
    private int x;
    private int y;

    public ImagePanel(int x, int y, int width, int height, String path) {
        super();
        this.x = x;
        this.y = y;
        this.imagePath = path;
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, getWidth()-1, getHeight()-1, this); // x, y, width, height
    }
}
