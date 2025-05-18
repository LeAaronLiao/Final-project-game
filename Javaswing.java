import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RectanglePanel extends JPanel {
    private int x = 0;
    private int y = 0;
    public RectanglePanel(int x, int y, int width, int height) {
        super();
        setBounds(x, y, width, height);
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    // getWidth and getHeight are inherited from JPanel, they aren't needed
    public void setWidth(int width) {
        setBounds(x, y, width, getHeight());
    }
    public void setHeight(int height) {
        setBounds(x, y, getWidth(), height);
    }
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

    public static void main(String[] args) {}
}