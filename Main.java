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
    public static QuestionPanel questionPanel = new QuestionPanel("whats 2+2", (new String[]{"3", "4", "2", "5"}), "5");
    public static boolean playing = true;
    public static void mainThread(JFrame frame) {
        if(playing) {
            frame.getContentPane().setLayout(null);
            frame.getContentPane().add(new LinePanel(player.getX()+25, player.getY()+25, Javaswing.getMousePos().x, Javaswing.getMousePos().y, 50, Color.RED));
            for(Enemy x : enemies) {
                x.draw();
            }
            player.draw();
            player.move(10*xMove, 10*yMove);
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
        } else if(charr.equals("e")) {
            int randX = (int)(Math.random() * 350);
            int randY = (int)(Math.random() * 350);
            enemies.add(new Enemy("new enemy", 0, 0, randX, randY));
        } else if(charr.equals("q")) {
            if(!playing) {
                playing = true;
            } else {
                playing = false;
                questionPanel.newQuestion("whats 2 + 2", new String[]{"4","5","3","2"}, "5");
            }
        }
    }
    public static void keyReleased(KeyEvent e) {
    }
}