import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static Player player = new Player("jaaron jiao", 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0);
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
    public static void mainThread(JFrame frame) {
        player.draw();
        player.moveX(5 * xMove);
        player.moveY(5 * yMove);
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
        }
    }
}