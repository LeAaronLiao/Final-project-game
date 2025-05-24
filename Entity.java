import java.awt.*;
public class Entity {
    private String name;
    private int Health;
    private int maxHealth;
    private int Level;
    private int PositionX;
    private int PositionY;
    private RectanglePanel rect;
    private RectanglePanel healthBorder;
    private RectanglePanel healthBar;
    protected String imagePath;
    private ImagePanel image;

    public Entity(String name, int Health, int Level, int PositionX, int PositionY, String imagePath) {
        this.name = name;
        this.Health = Health;
        this.maxHealth = Health;
        this.Level = Level;
        this.PositionX = PositionX;
        this.PositionY = PositionY;
        this.rect = new RectanglePanel(getX(), getY(), 50, 50, new Color(0,0,0));
        this.healthBorder = new RectanglePanel(getX(), getY()-5, 50, 5, new Color(0,0,0));
        this.healthBar = new RectanglePanel(getX(), getY()-5, 50, 5, new Color(0,255,0), true);
        this.imagePath = imagePath;
        this.image = new ImagePanel(PositionX, PositionY, 50, 50, imagePath);
    }

    public String getName() {
        return name;   
    }
    public int getHealth() {
        return Health;
    }

    public int getLevel() {
        return Level;
    }

    public int getX() {
        return PositionX;
    }

    public int getY() {
        return PositionY;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHealth(int Health) {
        this.Health = Health;
        if(this.Health < 0) {
            this.Health = 0;
        }
        if(this.Health > this.maxHealth) {
            this.Health = this.maxHealth;
        }
        this.healthBar.setWidth((int) ((this.Health / (double) this.maxHealth) * 50));
    }
    public void setLevel(int Level) {
        this.Level = Level;
    }
    public void setX(int PositionX) {
        this.PositionX = PositionX;
        if(this.PositionX < 0) {
            this.PositionX = 0;
        }
        if(this.PositionX > Javaswing.jframe.getWidth() - 50) {
            this.PositionX = Javaswing.jframe.getWidth() - 50;
        }
    }
    public void setY(int PositionY) {
        this.PositionY = PositionY;
        if(this.PositionY < 0) {
            this.PositionY = 0;
        }
        if(this.PositionY > Javaswing.jframe.getHeight() - 50) {
            this.PositionY = Javaswing.jframe.getHeight() - 50;
        }
    }
    public void move(int x, int y) {
        this.PositionX += x;
        this.PositionY += y;
        if(this.PositionX < 0) {
            this.PositionX = 0;
        }
        if(this.PositionX > Javaswing.jframe.getWidth() - 50) {
            this.PositionX = Javaswing.jframe.getWidth() - 50;
        }
        if(this.PositionY < 0) {
            this.PositionY = 0;
        }
        if(this.PositionY > Javaswing.jframe.getHeight() - 50) {
            this.PositionY = Javaswing.jframe.getHeight() - 50;
        }
    }
    public void attack(Entity target) {
        System.out.println(this.name + " attacks " + target.getName());
        target.setHealth(target.getHealth() - 10);
        System.out.println(target.getName() + " has " + target.getHealth() + " health left.");
    }
    public RectanglePanel getRect() {
        return this.rect;
    }
    public void draw() {
        this.rect.setX(PositionX);
        this.rect.setY(PositionY);
        this.healthBorder.setX(PositionX);
        this.healthBorder.setY(PositionY-5);
        this.healthBar.setX(PositionX);
        this.healthBar.setY(PositionY-5);
        this.image.draw(PositionX, PositionY, 50, 50);
        Javaswing.jframe.getContentPane().add(this.rect);
        Javaswing.jframe.getContentPane().add(this.healthBorder);
        Javaswing.jframe.getContentPane().add(this.healthBar);
    }
    public boolean colliding(Entity e) {
        return (Math.abs(this.getX() - e.getX()) < 50) && (Math.abs(this.getY() - e.getY()) < 50);
    }
}