public class Player extends Entity{
    
    private int attackPower;
    private int defensePower;
    private String item;
    private String[] inventory;
    private int inventorySize;
    private int Energy;
    private RectanglePanel rect;

    public Player(String name, int Health, int Level, int PositionX, int PositionY, int attackPower, int defensePower, String item, String[] inventory, int inventorySize, int Energy) {
       super(name, Health,Level, PositionX, PositionY);
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.item = item;
        this.inventory = inventory;
        this.inventorySize = inventorySize;
        this.Energy = Energy;
        this.rect = new RectanglePanel(x, y, 50, 50);
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