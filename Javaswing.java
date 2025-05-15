import javax.swing.*;
import java.awt.*;

class RectanglePanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight()); // x, y, width, height
    }
}

public class Javaswing {
    /**
     * Create the GUI and show it. For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        // Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("what is in the up jaaron liao", JLabel.CENTER);
        
        frame.getContentPane().add(label);
        // RectanglePanel panel = new RectanglePanel();
        // panel.setBounds(50, 50, 100, 50);
        // frame.getContentPane().add(panel);
        for(int r = 0; r < 8; r++) {
            for(int c = 0; c < 8; c++) {
                addRect(frame, r * 50, c * 50, 50, 50);
            }
        }

        // RectanglePanel2 panel2 = new RectanglePanel2();
        // frame.getContentPane().add(panel2);

        // Set the window size and display it.
        frame.getContentPane().setSize(400, 400);
        frame.setSize(450, 450);
        frame.setVisible(true);
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
        javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}