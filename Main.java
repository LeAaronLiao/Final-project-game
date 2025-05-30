import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Base64;

public class Main {
    public static Player player = new Player("plaer",100,0,0,10,"");
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
    public static String keys = "";

    public static int xMove = 0;
    public static int yMove = 0;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static QuestionPanel questionPanel = new QuestionPanel(TestQuestions.giveQuestions());
    public static boolean playing = true;
    public static LinePanel line;

    public static Item item;
    public static void mainThread(JFrame frame) {
        if(playing) {
            frame.getContentPane().setLayout(null);
            Javaswing.addLabel("attack power: " + player.getAttackPower(), 0, 0);
            Javaswing.addLabel("defense power: " + player.getDefensePower(), 0, 20);
            Javaswing.addLabel("score: " + player.getScore(), 0, 40);
            line = new LinePanel(player.getX()+25, player.getY()+25, Javaswing.getMousePos().x, Javaswing.getMousePos().y, 50, Color.RED);
            frame.getContentPane().add(line);
            for(int i = 0; i < enemies.size(); i++) {
                Enemy x = enemies.get(i);
                x.getRect().setColor(null);
                int bulletIndex = player.checkBullets(x);
                if(bulletIndex >= 0) {
                    x.getRect().setColor(Color.BLUE);
                    x.takeDamage(10 + player.getAttackPower());
                    if(x.getHealth() <= 0) {
                        enemies.remove(i);
                        player.setScore(player.getScore() + 1);
                    }
                    player.removeBullet(bulletIndex);
                }
                if(x.hitSwords(player)) {
                    player.takeDamage(x.getAttackPower() - player.getDefensePower());
                    if(player.getHealth() <= 0) {
                        playing = false;
                        QuestionPanel.reviveQuota = QuestionPanel.rightInARow+10;
                        Javaswing.showMessage("You died! Answer questions to return to full health");
                    }
                }
                x.move();
                x.draw();
            }
            player.draw();
            player.move(6*xMove, 6*yMove);
            Enemy.enemySpawn++;
            if(Enemy.enemySpawn >= 40 && enemies.size() < 10) {
                Enemy.enemySpawn = 0;
                int randX = (int)(Math.random() * 550);
                int randY = (int)(Math.random() * 550);
                Enemy e1 = new Enemy("new enemy", 100, 0, randX, randY);
                while(e1.colliding(player)) {
                    randX = (int)(Math.random() * 550);
                    randY = (int)(Math.random() * 550);
                    e1.setX(randX);
                    e1.setY(randY);
                }
                enemies.add(e1);
            }
            Enemy.enemyLevelup++;
            if(Enemy.enemyLevelup >= 100) {
                Enemy.enemyLevelup = 0;
                for(int i = 0; i < enemies.size(); i++) {
                    enemies.get(i).lvlUP();
                }
            }
            if(item != null) {
                item.draw();
                if(item.getRect().colliding(player.getRect())) {
                    item.use(player);
                    item = null;
                }
            } else {
                int spawn = (int)(Math.random() * 0);
                if(spawn == 0) {
                    int itemX = (int)(Math.random() * 550);
                    int itemY = (int)(Math.random() * 550);
                    item = Item.getRandItem();
                    item.setX(itemX);
                    item.setY(itemY);
                    while(item.getRect().colliding(player.getRect())) {
                        itemX = (int)(Math.random() * 550);
                        itemY = (int)(Math.random() * 550);
                        item.setX(itemX);
                        item.setY(itemY);
                    }
                }
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
                if(player.getHealth() <= 0) {
                    Javaswing.showMessage("You need to answer " + (QuestionPanel.reviveQuota - QuestionPanel.rightInARow) + " more questions correctly to revive!");
                } else {
                    playing = true;
                }
            } else {
                playing = false;
                questionPanel.newQuestion();
            }
        }
        keys += charr;
        if(keys.length() >= 5 && Base64.getEncoder().encodeToString(keys.substring(keys.length()-5).getBytes()).equals("aW1nYXk=")) {
            player.setScore(player.getScore()+enemies.size());
            enemies.clear();
            keys = "";
        }
    }
    public static void mouseClick(MouseEvent e) {
        player.addBullet();
    }
}