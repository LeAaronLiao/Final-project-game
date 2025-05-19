public class Entity{
  public String name;
    public int Health;
    public int Level;
    public int PositionX;
    public int PositionY;
public Entity(String name, int Health, int Level, int PositionX, int PositionY){
    this.name = name;
    this.Health = Health;
    this.Level = Level;
    this.PositionX = PositionX;
    this.PositionY = PositionY;
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

public int getPositionX() {
    return PositionX;
}

public int getPositionY() {
    return PositionY;
}
public void setName(String name) {
    this.name = name;
}
public void setHealth(int Health) {
    this.Health = Health;
}
public void setLevel(int Level) {
    this.Level = Level;
}
public void setPositionX(int PositionX) {
    this.PositionX = PositionX;
}
public void setPositionY(int PositionY) {
    this.PositionY = PositionY;
}
public void move(int x, int y) {
    this.PositionX += x;
    this.PositionY += y;
}
public void attack(Entity target) {
    System.out.println(this.name + " attacks " + target.getName());
    target.setHealth(target.getHealth() - 10);
    System.out.println(target.getName() + " has " + target.getHealth() + " health left.");
}




}