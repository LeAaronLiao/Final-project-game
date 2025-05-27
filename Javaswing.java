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
        // Main.keyReleased(e);
    }
}
class MouseEvents implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        Main.mouseClick(e);
    }
    public void mousePressed(MouseEvent e) {
        // Main.mousePress(e);
    }
    public void mouseReleased(MouseEvent e) {
        // Main.mouseRelease(e);
    }
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
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
        JFrame frame = new JFrame("FIGHT THE VIRS AND AARONS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.BLACK);

        // Set the window size and display it.
        frame.getContentPane().setSize(wsz, wsz);
        frame.pack();
        Insets insets = frame.getInsets();
        // Set the frame size to fit the content plus insets
        frame.setSize(wsz + insets.left + insets.right, wsz + insets.top + insets.bottom);
        frame.setVisible(true);
        frame.addKeyListener(new KeyboardEvents());
        frame.addMouseListener(new MouseEvents());
        jframe = frame;
    }
    public static Point getMousePos() {
        Point mouse = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(mouse, jframe.getContentPane());
        return mouse;
    }
    public static void addLabel(String text, int x, int y) {
        JLabel lbl = new JLabel(text);
        lbl.setBounds(x, y, 200, 20);
        lbl.setForeground(Color.WHITE);
        jframe.getContentPane().add(lbl);
        jframe.getContentPane().setComponentZOrder(lbl, jframe.getContentPane().getComponentCount() - 1);
    }
    public static void showMessage(String message) {
        JOptionPane.showMessageDialog(jframe, message);
    }
}