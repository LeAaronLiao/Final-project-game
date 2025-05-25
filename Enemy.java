public class Enemy extends Entity {
    private int changeDir = 0;
    private int xMove = 0;
    private int yMove = 0;
    public Enemy(String name, int Health, int Level, int PositionX, int PositionY) {
        super(name, Health, Level, PositionX, PositionY,(new String[]{"aaron.jpg", "vir.jpg"})[(int)(Math.random() * 2)]);
    }
    public void lvlUP(){
        this.setLevel(this.getLevel() + 1);
        this.setHealth(this.getHealth() + 10);
    }
    public void draw() {
        super.draw();
        changeDir++;
    }
    public void move() {
        if(changeDir > 50) {
            changeDir = 0;
            xMove = (int)(Math.random() * 3) - 1;
            yMove = (int)(Math.random() * 3) - 1;        
        }
        super.move(xMove*5, yMove*5);
    }
}
