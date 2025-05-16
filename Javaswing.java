import javax.swing.*;
import java.awt.*;

class RectanglePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1); // x, y, width, height
    }
}

public class Javaswing {
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static JFrame jframe;
    public static int wsz = 600;
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Set the window size and display it.
        frame.getContentPane().setSize(wsz, wsz);
        frame.setSize(wsz+50, wsz+50);
        frame.setVisible(true);
        jframe = frame;
    }
    public static void addRect(JFrame frame, int x, int y, int width, int height) {
        RectanglePanel panel = new RectanglePanel();
        panel.setBounds(x, y, width, height);
        frame.getContentPane().add(panel);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        System.out.println("running");
        createAndShowGUI();
        System.out.println(jframe);
        while(true) {
            mainThread(jframe);
            System.out.println("running loop");
            jframe.revalidate();
            jframe.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static int x = 0;
    public static void mainThread(JFrame frame) {
        /*int sz = 25;
        for(int r = 0; r < wsz/sz; r++) {
            for(int c = 0; c < wsz/sz; c++) {
                addRect(frame, r * sz, c * sz, sz, sz);
            }
        }*/
        addRect(frame, x, 0, 50, 50);
        x += 1;
    }
}