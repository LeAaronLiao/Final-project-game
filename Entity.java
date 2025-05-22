import java.awt.*;
public class Entity {
    private String name;
    private int Health;
    private int Level;
    private int PositionX;
    private int PositionY;
    private RectanglePanel rect;

    public Entity(String name, int Health, int Level, int PositionX, int PositionY){
        this.name = name;
        this.Health = Health;
        this.Level = Level;
        this.PositionX = PositionX;
        this.PositionY = PositionY;
        this.rect = new RectanglePanel(getX(), getY(), 50, 50, new Color(0,0,0));
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
    }
    public void setLevel(int Level) {
        this.Level = Level;
    }
    public void setX(int PositionX) {
        this.PositionX = PositionX;
    }
    public void setY(int PositionY) {
        this.PositionY = PositionY;
    }
    public void move(int x, int y) {
        this.PositionX += x;
        this.PositionY += y;
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
        Javaswing.jframe.add(this.rect);
    }
    public boolean colliding(Entity e) {
        return (Math.abs(this.getX() - e.getX()) < 50) && (Math.abs(this.getY() - e.getY()) < 50);
    }
}