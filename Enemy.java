public class Enemy extends Entity {
    public Enemy(String name, int Health, int Level, int PositionX, int PositionY) {
        super(name, Health, Level, PositionX, PositionY);
        imagePath = "vir.jpg";
    }
    public void lvlUP(){
        this.setLevel(this.getLevel() + 1);
        this.setHealth(this.getHealth() + 10);
    }
}
