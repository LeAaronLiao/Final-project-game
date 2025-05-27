import java.awt.Color;
import java.util.ArrayList;
import java.awt.Point;

public class Player extends Entity {
    private int score;
    private int level;
    private ArrayList<CirclePanel> bullets = new ArrayList<CirclePanel>();
    private ArrayList<Point[]> pts = new ArrayList<Point[]>();
    private ArrayList<Integer> bulletFrames = new ArrayList<Integer>();
    // private ArrayList<Integer> bulletLength = new ArrayList<Integer>(); -> 50 + (10 * bulletFrames)



    public Player(String name, int Health, int Level, int PositionX, int PositionY, String item) {
        super(name, Health,Level, PositionX, PositionY, "shivank.jpg");
        this.score = 0;
        this.level = 1;
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
    public void setLevel(int level) {
        this.level = level;
    }
    public void addBullet() {
        CirclePanel bullet = new CirclePanel(0, 0, 5, Color.RED);
        Point[] path = new Point[]{Main.line.getP1(), new Point(Javaswing.getMousePos().x, Javaswing.getMousePos().y)};
        bullets.add(bullet);
        pts.add(path);
        bulletFrames.add(0);
    }
    public void removeBullet(int index) {
        if(index >= 0 && index < bullets.size()) {
            bullets.remove(index);
            pts.remove(index);
            bulletFrames.remove(index);
        }
    }
    public int checkBullets(Entity e) {
        for(int i = 0; i < bullets.size(); i++) {
            if(bullets.get(i).colliding(e)) {
                return i;
            }
        }
        return -1;
    }
    public void draw() {
        super.draw();
        for(int i = bullets.size()-1; i >= 0; i--) {
            CirclePanel bullet = bullets.get(i);
            Point[] path = pts.get(i);
            int frames = this.bulletFrames.get(i);
            bullet.setX(
                    new LinePanel(path[0].x, path[0].y, path[1].x, path[1].y, 50 + 10*frames, null).getP2().x-bullet.getRadius()
            );
            bullet.setY(
                new LinePanel(path[0].x, path[0].y, path[1].x, path[1].y, 50+10*frames, null).getP2().y-bullet.getRadius()
            );
            Javaswing.jframe.getContentPane().add(bullet);
            this.bulletFrames.set(i, this.bulletFrames.get(i) + 1);
            if(frames > 25) {
                bullets.remove(i);
                pts.remove(i);
                bulletFrames.remove(i);                
            }
        }
    }
}