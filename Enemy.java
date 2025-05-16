public class Enemy {
    private String enemyName;
    private int enemyHealth;
    private int enemyLevel;
    private int enemyPositionX;
    private int enemyPositionY;

    public Enemy(String enemyName, int enemyHealth, int enemyLevel, int enemyPositionX, int enemyPositionY) {
        this.enemyName = enemyName;
        this.enemyHealth = enemyHealth;
        this.enemyLevel = enemyLevel;
        this.enemyPositionX = enemyPositionX;
        this.enemyPositionY = enemyPositionY;
    }

    public String getEnemyName() {
        return enemyName;
    }

    public void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }
    public void setEnemyHealth(int enemyHealth) {
        this.enemyHealth = enemyHealth;
    }
    public int getEnemyLevel() {
        return enemyLevel;
    }
    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }
    public int getEnemyPositionX() {
        return enemyPositionX;
    }
    public void setEnemyPositionX(int enemyPositionX) {
        this.enemyPositionX = enemyPositionX;
    }
    public int getEnemyPositionY() {
        return enemyPositionY;
    }
    public void setEnemyPositionY(int enemyPositionY) {
        this.enemyPositionY = enemyPositionY;
    }       

}