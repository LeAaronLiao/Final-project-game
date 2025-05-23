import java.awt.Color;
import java.util.ArrayList;
public class Player extends Entity {
    private int attackPower;
    private int defensePower;
    private String item;
    private int score;
    private int level;

    public Player(String name, int Health, int Level, int PositionX, int PositionY, int attackPower, int defensePower, String item, ArrayList<Item> items) {
       super(name, Health,Level, PositionX, PositionY);
        this.attackPower = attackPower;
        this.defensePower = defensePower;
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
    public int getAttackPower() {
        return attackPower;
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