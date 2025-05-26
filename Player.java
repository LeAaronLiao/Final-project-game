import java.awt.Color;
import java.util.ArrayList;
public class Player extends Entity {
    private String item;
    private int score;
    private int level;

    public Player(String name, int Health, int Level, int PositionX, int PositionY, String item, ArrayList<Item> items) {
        super(name, Health,Level, PositionX, PositionY, "shivank.jpg");
        this.item = item;
        this.score = 0;
        this.level = 1;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int playerScore) {
        this.score = playerScore;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}