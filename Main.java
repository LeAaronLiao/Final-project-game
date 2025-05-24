import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    public static Player player = new Player("plaer",0,0,0,0,0,0,"",new ArrayList<Item>());
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Javaswing.jframe.getContentPane().removeAll();
                mainThread(Javaswing.jframe);
                Javaswing.jframe.revalidate();
                Javaswing.jframe.repaint();
            }
        };
        Javaswing.createAndShowGUI();
        Timer timer = new Timer(50, listener);
        timer.setRepeats(true);
        timer.start();
    }
    public static int xMove = 0;
    public static int yMove = 0;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static int enemySpawn = 0;
    public static QuestionPanel questionPanel = new QuestionPanel("whats 2+2", (new String[]{"3", "4", "2", "5"}), "5");
    public static boolean playing = true;
    public static LinePanel line;

    public static CirclePanel bullet = new CirclePanel(0, 0, 5, Color.RED);
    public static int bulletLength = 1;
    public static Point bulletStart;
    public static Point bulletEnd;
    public static boolean shot = false;
    public static int bulletFrames = 0;
    public static void mainThread(JFrame frame) {
        if(playing) {
            frame.getContentPane().setLayout(null);
            frame.getContentPane().add(new JLabel());
            line = new LinePanel(player.getX()+25, player.getY()+25, Javaswing.getMousePos().x, Javaswing.getMousePos().y, 50, Color.RED);
            frame.getContentPane().add(line);
            for(int i = 0; i < enemies.size(); i++) {
                Enemy x = enemies.get(i);
                x.getRect().setColor(null);
                if(bullet.colliding(x)) {
                    x.getRect().setColor(Color.BLUE);
                    x.setHealth(x.getHealth()-2);
                    enemies.remove(i);
                }
                x.draw();
            }
            player.draw();
            player.move(10*xMove, 10*yMove);
            if(!shot) {
                bullet.setX(line.getP2().x-bullet.getRadius());
                bullet.setY(line.getP2().y-bullet.getRadius());
            } else {
                bullet.setX(
                    new LinePanel(bulletStart.x, bulletStart.y, bulletEnd.x, bulletEnd.y, bulletLength, null).getP2().x-bullet.getRadius()
                );
                bullet.setY(
                    new LinePanel(bulletStart.x, bulletStart.y, bulletEnd.x, bulletEnd.y, bulletLength, null).getP2().y-bullet.getRadius()
                );
                bulletLength+=10;
                bulletFrames++;
                if(bulletFrames > 25) {
                    shot = false;
                    bulletFrames = 0;
                }
            }
            frame.getContentPane().add(bullet);
            enemySpawn++;
            if(enemySpawn >= 40 && enemies.size() < 10) {
                enemySpawn = 0;
                int randX = (int)(Math.random() * 550);
                int randY = (int)(Math.random() * 550);
                Enemy e1 = new Enemy("new enemy", 0, 0, randX, randY);
                while(e1.colliding(player)) {
                    randX = (int)(Math.random() * 550);
                    randY = (int)(Math.random() * 550);
                    e1.setX(randX);
                    e1.setY(randY);
                }
                enemies.add(e1);
            }
        } else {
            frame.getContentPane().setLayout(new BorderLayout());
            frame.getContentPane().add(questionPanel);
        }
    }
    public static void keyPress(KeyEvent e) {
        String charr = e.getKeyChar() + "";
        if (charr.equals("w")) {
            yMove = -1;
            xMove = 0;
        } else if(charr.equals("s")) {
            yMove = 1;
            xMove = 0;
        } else if(charr.equals("a")) {
            xMove = -1;
            yMove = 0;
        } else if(charr.equals("d")) {
            xMove = 1;
            yMove = 0;
        } else if(charr.equals(" ")) {
            xMove = 0;       
            yMove = 0;
        } else if(charr.equals("q")) {
            if(!playing) {
                playing = true;
            } else {
                playing = false;
                questionPanel.newQuestion("whats 2 + 2", new String[]{"4","5","3","2"}, "5");
            }
        }
    }
    public static void mouseClick(MouseEvent e) {
        shot = true;
        bulletLength = 50;
        bulletStart = line.getP1();
        bulletEnd = new Point(Javaswing.getMousePos().x, Javaswing.getMousePos().y);
    }
}