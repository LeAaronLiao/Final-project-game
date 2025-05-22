import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class KeyboardEvents implements KeyListener {
    public void keyTyped(KeyEvent e) {
        // Invoked when a key has been typed.
    }
    public void keyPressed(KeyEvent e) {
        Main.keyPress(e);
    }
    public void keyReleased(KeyEvent e) {
        Main.keyReleased(e);
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
        frame.addKeyListener(new KeyboardEvents());
        jframe = frame;
    }
    public static Point getMousePos() {
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mouse, jframe.getContentPane());
        return mouse;
    }

    public static void main(String[] args) {}
}