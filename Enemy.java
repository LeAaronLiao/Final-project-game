import java.awt.Color;

public class Enemy extends Entity {
    public static int enemySpawn = 0;
    public static int enemyLevelup = 0;
    private int changeDir = 0;
    private int changeDirMax = 50;
    private int xMove = 0;
    private int yMove = 0;
    /* add "swords" */
    private RectanglePanel xSword;
    private RectanglePanel ySword;
    private int swordSpawn = 0;
    public Enemy(String name, int Health, int Level, int PositionX, int PositionY) {
        super(name, Health, Level, PositionX, PositionY,(new String[]{"aaron.jpg", "vir.jpg", "atharva.png"})[(int)(Math.random() * 3)]);
        setAttackPower(2);
        xSword = new RectanglePanel(0, 0, 0, 0, Color.RED, true);
        ySword = new RectanglePanel(0, 0, 0, 0, Color.RED, true);
    }
    public void lvlUP(){
        this.setAttackPower(this.getAttackPower() + 2);
        this.setDefensePower(this.getDefensePower() + 2);
    }
    public void draw() {
        super.draw();
        changeDir++;
        if(xSword != null) {
            xSword.setX(getX() + xMove*25);
            xSword.setY(getY() + 20);
            Javaswing.jframe.getContentPane().add(xSword);
        }
        if(ySword != null) {
            ySword.setX(getX() + 20);
            ySword.setY(getY() + yMove*25);
            Javaswing.jframe.getContentPane().add(ySword);
        }
        swordSpawn++;
        if(swordSpawn >= 200) {
            swordSpawn = 0;
            newSwords();
        }
    }
    public void newSwords() {
        if(xMove > 0) {
            xSword = new RectanglePanel(getX() + 25, getY() + 20, 50, 10, Color.RED, true);
        } else if(xMove < 0) {
            xSword = new RectanglePanel(getX() - 25, getY() + 20, 50, 10, Color.RED, true);
        }
        if(yMove > 0) {
            ySword = new RectanglePanel(getX() + 20, getY() + 25, 10, 50, Color.RED, true);
        } else if(yMove < 0) {
            ySword = new RectanglePanel(getX() + 20, getY() - 25, 10, 50, Color.RED, true);
        }
    }
    public boolean hitSwords(Player p) {
        if(xSword != null && xSword.colliding(p.getRect())) {
            xSword = null;
            return true;
        }
        if(ySword != null && ySword.colliding(p.getRect())) {
            ySword = null;
            return true;
        }
        return false;
    }
    public void move() {
        if(changeDir >= changeDirMax) {
            changeDir = 0;
            xMove = (int)(Math.random() * 3) - 1;
            yMove = (int)(Math.random() * 3) - 1;
            newSwords();    
        }
        super.move(xMove*5, yMove*5);
    }
    public void changeDirect() {
        changeDir = changeDirMax;
    }
    public void oppositeDir() {
        xMove = -xMove;
        yMove = -yMove;
    }
}
