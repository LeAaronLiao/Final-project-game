import java.util.ArrayList;
public class Player extends Entity {
    private int attackPower;
    private int defensePower;
    private String item;
    private int Energy;
    private RectanglePanel rect;

    public Player(String name, int Health, int Level, int PositionX, int PositionY, int attackPower, int defensePower, int someInt, String item, ArrayList<Item> inventory) {
        super(name, Health,Level, PositionX, PositionY);
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.item = item;
        this.Energy = Energy;
        this.rect = new RectanglePanel(getX(), getY(), 50, 50);
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
    public RectanglePanel getRect() {
        return this.rect;
    }
    public void draw() {
        Javaswing.jframe.add(this.rect);
    }
    public void answerQuestion(){
        
    }

}