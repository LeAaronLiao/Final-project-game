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
                System.out.println(Javaswing.jframe);
            }
        };
        System.out.println("running");
        Javaswing.createAndShowGUI();
        Timer timer = new Timer(50, listener);
        timer.setRepeats(true);
        timer.start();
    }
    public static int xMove = 0;
    public static int yMove = 0;
    public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    public static QuestionPanel questionPanel = new QuestionPanel("whats 2+2", (new String[]{"3", "4", "2", "5"}), "5");
    public static boolean playing = true;
    public static void mainThread(JFrame frame) {
        /*Javaswing.jframe.getContentPane().setLayout(new BorderLayout());
        Javaswing.jframe.getContentPane().add(questionPanel);*/
        if(playing) {
            player.draw();
            player.move(10*xMove, 10*yMove);
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
        } else if(charr.equals("e")) {
            int randX = (int)(Math.random() * 350);
            int randY = (int)(Math.random() * 350);
            enemies.add(new Enemy("new enemy", 0, 0, randX, randY));
        } else if(charr.equals("q")) {
            questionPanel.newQuestion("whats 2 + 2", new String[]{"4","5","3","2"}, "5");
        }
    }
    public static void keyReleased(KeyEvent e) {
        String charr = e.getKeyChar() + "";
        xMove = 0;
        yMove = 0;
    }
}