import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {
    public static Player player = new Player("plaer",0,0,0,0,0,0,"",new ArrayList<Item>());
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        System.out.println("running");
        Javaswing.createAndShowGUI();
        System.out.println(Javaswing.jframe);
        while(true) {
            Javaswing.jframe.getContentPane().removeAll();
            mainThread(Javaswing.jframe);
            Javaswing.jframe.revalidate();
            Javaswing.jframe.repaint();
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static int xMove = 0;
    public static int yMove = 0;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static void mainThread(JFrame frame) {
        for(Enemy e : enemies) { 
            if(player.colliding(e)) {
                e.getRect().setColor(new Color(255, 0, 0));
                xMove = 0;
                yMove = 0;
            } else {
                e.getRect().setColor(new Color(0,0,0));
            }
            e.draw();
        }
        player.draw();
        player.move(5 * xMove, 0);
        player.move(0, 5 * yMove);
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
        } else if(charr.equals("e")) {
            int randX = (int)(Math.random() * 350);
            int randY = (int)(Math.random() * 350);
            enemies.add(new Enemy("new enemy", 0, 0, randX, randY));
        }
    }
}