import java.awt.Color;

public class Item {
    private String name;
    private String imagePath;
    private ImagePanel imgPanel;
    private RectanglePanel rect;
    public static Item[] items = {new Heal(0,0)};
    public Item(String name, String imagePath, int x, int y) {
        this.name = name;
        this.imagePath = imagePath;
        this.imgPanel = new ImagePanel(x, y, 50, 50, imagePath);
        this.rect = new RectanglePanel(x, y, 50, 50, Color.BLACK);
    }
    public void use(Player player) {}
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
    public ImagePanel getImgPanel() {
        return imgPanel;
    }
    public RectanglePanel getRect() {
        return rect;
    }
    public void setX(int x) {
        this.rect.setX(x);
    }
    public void setY(int y) {
        this.rect.setY(y);
    }
    public static Item getRandItem() {
        return items[(int) (Math.random() * items.length)];
    }
    public void draw() {
        this.imgPanel.draw(this.rect.getX(), this.rect.getY(), 50, 50);
        Javaswing.jframe.getContentPane().add(this.rect);
    }
}
