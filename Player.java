import java.util.ArrayList;
public class Player {
    private String name;
    private int score;
    private int level;
    private int health;
    private int x;
    private int y;
    private int attackPower;
    private int defensePower;
    private String item;
    private ArrayList<Item> inventory;
    private int Energy;
    private RectanglePanel rect;


    public Player(String playerName, int playerScore, int playerLevel, int playerHealth, int playerPositionX, int playerPositionY, int attackPower, int defensePower, String item, ArrayList<Item> inventory) {
        this.name = playerName;
        this.score = playerScore;
        this.level = playerLevel;
        this.health = playerHealth;
        this.x = playerPositionX;
        this.y = playerPositionY;
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.item = item;
        this.inventory = inventory;
        this.rect = new RectanglePanel(x, y, 50, 50);
    }
    public String getName() {
        return name;
    }
    public void setName(String playerName) {
        this.name = playerName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int playerScore) {
        this.score = playerScore;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int playerLevel) {
        this.level = playerLevel;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int playerHealth) {
        this.health = playerHealth;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }  
    public void moveX(int x) {
        this.x += x;
        this.rect.setX(this.x);
    }
    public void moveY(int y) {
        this.y += y;
        this.rect.setY(this.y);
    }
    public RectanglePanel getRect() {
        return this.rect;
    }
    public void draw() {
        Javaswing.jframe.add(this.rect);
    }
    public void answerQuestion(){
        
    }

}