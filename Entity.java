import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;

public class Entity {
    private String name;
    private int Health;
    private int maxHealth;
    private int Level;
    private int PositionX;
    private int PositionY;
    private int attackPower = 0;
    private int defensePower = 0;
    private RectanglePanel rect;
    private RectanglePanel healthBorder;
    private RectanglePanel healthBar;
    protected String imagePath;
    private ImagePanel image;
    private ArrayList<JLabel> text = new ArrayList<JLabel>();
    private ArrayList<Integer> textTimer = new ArrayList<Integer>();

    public Entity(String name, int Health, int Level, int PositionX, int PositionY, String imagePath) {
        this.name = name;
        this.Health = Health;
        this.maxHealth = Health;
        this.Level = Level;
        this.PositionX = PositionX;
        this.PositionY = PositionY;
        this.rect = new RectanglePanel(getX(), getY(), 50, 50, new Color(0,0,0));
        this.healthBorder = new RectanglePanel(getX(), getY()-10, 50, 10, new Color(0,0,0));
        this.healthBorder.setOpaque(true);
        this.healthBar = new RectanglePanel(getX()+1, getY()-10+1, 48, 9, new Color(0,255,0), true); // 1-2 px less to fit inside border
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
    public void damageText(int dmg) {
        JLabel label = new JLabel("-" + dmg);
        label.setForeground(Color.RED);
        label.setBounds(PositionX + 15, PositionY - 20, 50, 20);
        Javaswing.jframe.getContentPane().add(label);
        text.add(label);
        textTimer.add(0);
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
        if(this.PositionY < this.healthBar.getHeight()) {
            this.PositionY = this.healthBar.getHeight();
        }
        if(this.PositionY > Javaswing.jframe.getHeight() - 50) {
            this.PositionY = Javaswing.jframe.getHeight() - 50;
        }
    }
    public void move(int x, int y) {
        setX(this.PositionX + x);
        setY(this.PositionY + y);
    }
    public RectanglePanel getRect() {
        return this.rect;
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void increaseAttackPower(){
        attackPower++;
    }
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }
    public int getDefensePower() {
        return defensePower;
    }
    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }
    public void increaseDefensePower(){
        defensePower++;
    }
    public void draw() {
        this.rect.setX(PositionX);
        this.rect.setY(PositionY);
        this.healthBorder.setX(PositionX);
        this.healthBorder.setY(PositionY-this.healthBorder.getHeight());
        this.healthBar.setX(PositionX+1);
        this.healthBar.setY(PositionY-this.healthBar.getHeight()+1);
        this.image.draw(PositionX, PositionY, 50, 50);
        Javaswing.jframe.getContentPane().add(this.rect);
        Javaswing.jframe.getContentPane().add(this.healthBar);
        Javaswing.jframe.getContentPane().add(this.healthBorder);
        for(int x : textTimer) {
            x++;
        }
        for(int i = 0; i < text.size(); i++) {
            JLabel label = text.get(i);
            label.setBounds(this.getX() + 15, this.getY() - 20 - i*10, 50, 10);
            Javaswing.jframe.getContentPane().add(label);
            if(textTimer.get(i) > 30) {
                Javaswing.jframe.getContentPane().remove(label);
                text.remove(i);
                textTimer.remove(i);
                i--;
            } else {
                textTimer.set(i, textTimer.get(i) + 1);
            }
        }
    }
    public boolean colliding(Entity other) {
        return this.rect.colliding(other.getRect());
    }
    public void takeDamage(int dmg) {
        this.setHealth(this.getHealth() - dmg);
        this.damageText(dmg);
    }
}