import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RectanglePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth()-1, getHeight()-1); // x, y, width, height
    }
}

class Listener implements KeyListener {
    public void keyTyped(KeyEvent e) {
        // Invoked when a key has been typed.
    }
    public void keyPressed(KeyEvent e) {
        Main.keyPress(e);
    }
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
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
    public static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Set the window size and display it.
        frame.getContentPane().setSize(wsz, wsz);
        frame.setSize(wsz+50, wsz+50);
        frame.setVisible(true);
        frame.addKeyListener(new Listener());
        jframe = frame;
    }
    public static void addRect(JFrame frame, int x, int y, int width, int height) {
        RectanglePanel panel = new RectanglePanel();
        panel.setBounds(x, y, width, height);
        frame.getContentPane().add(panel);
    }

    public static void main(String[] args) {}
}