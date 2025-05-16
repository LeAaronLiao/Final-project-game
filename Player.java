public class Player{
private String playerName;
private int playerScore;
private int playerLevel;
private int playerHealth;
private int playerPositionX;
private int playerPositionY;
private int attackPower;
private int defensePower;
private String item;
private String[] inventory;
private int inventorySize;
private int Energy;



public Player(String playerName, int playerScore, int playerLevel, int playerHealth, int playerPositionX, int playerPositionY, int attackPower, int defensePower, String item, String[] inventory, int inventorySize, int Energy) {
    this.playerName = playerName;
    this.playerScore = playerScore;
    this.playerLevel = playerLevel;
    this.playerHealth = playerHealth;
    this.playerPositionX = playerPositionX;
    this.playerPositionY = playerPositionY;
    this.attackPower = attackPower;
    this.defensePower = defensePower;
    this.item = item;
    this.inventory = inventory;
    this.inventorySize = inventorySize;
    this.Energy = Energy;
}
public String getPlayerName() {
    return playerName;
}
public void setPlayerName(String playerName) {
    this.playerName = playerName;
}
public int getPlayerScore() {
    return playerScore;
}
public void setPlayerScore(int playerScore) {
    this.playerScore = playerScore;
}
public int getPlayerLevel() {
    return playerLevel;
}
public void setPlayerLevel(int playerLevel) {
    this.playerLevel = playerLevel;
}
public int getPlayerHealth() {
    return playerHealth;
}
public void setPlayerHealth(int playerHealth) {
    this.playerHealth = playerHealth;
}
public int getPlayerPositionX() {
    return playerPositionX;
}
public void setPlayerPositionX(int playerPositionX) {
    this.playerPositionX = playerPositionX;
}
public int getPlayerPositionY() {
    return playerPositionY;
}  
public void setPlayerPositionY(int playerPositionY) {
    this.playerPositionY = playerPositionY;
}
public void movePlayerup() {
    this.playerPositionY ++;
}
public void movePlayerdown() {
    this.playerPositionY --;
}
public void movePlayerleft() {
    this.playerPositionX --;
}
public void movePlayerright() {
    this.playerPositionX ++;
}
public void answerQuestion(){
    
}







}