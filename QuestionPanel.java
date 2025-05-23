import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionPanel extends JPanel {
    private boolean isCorrect;
    private String correctAnswer;

    private JLabel questionLabel;
    private JButton[] buttons;
    private JPanel buttonGrid;
    private JPanel mainPanel;

    public QuestionPanel(String q, String[] answers, String correct) {
        this.correctAnswer = correct;
        // Use BorderLayout for full expansion
        setLayout(new BorderLayout());
        // Main panel with BorderLayout to control vertical sections
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.mainPanel = mainPanel;
        // Label at the top (NORTH)
        JLabel label = new JLabel(q, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(100, Javaswing.wsz/2)); // optional height control
        questionLabel = label;
        mainPanel.add(label, BorderLayout.NORTH);
        // Button grid in CENTER
        JPanel buttonGrid = new JPanel(new GridLayout(2, 2, 10, 10)); // spacing between buttons;
        this.buttonGrid = buttonGrid;
        JButton[] buttons = new JButton[]{
            new JButton(answers[0]),
            new JButton(answers[1]),
            new JButton(answers[2]),
            new JButton(answers[3])
        };
        this.buttons = buttons;
        for(JButton x : buttons) {
            buttonGrid.add(x);
            if(isCorrect && x.getText().equals(correct)) {
                x.setBackground(Color.GREEN);
            } else {
                x.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        checkAnswer(x);
                        System.out.println(Javaswing.jframe.getKeyListeners().length);
                        Javaswing.jframe.requestFocusInWindow();
                    }
                });
            }
        }
        // Optional padding around button grid
        buttonGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(buttonGrid, BorderLayout.CENTER);
        // Add main panel to the frame's CENTER to make it fill
        add(mainPanel, BorderLayout.CENTER);
    }
    public void newQuestion(String q, String[] answers, String correct) {
        isCorrect = false;
        correctAnswer = correct;
        questionLabel.setText(q);
        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setText(answers[i]);
            buttons[i].removeAll();
            buttons[i].setBackground(null); // Reset background color
        }
    }
    public void checkAnswer(JButton x) {
        int rightInARow3 = 0;
        int rightInARow5 = 0;
        if(x.getText().equals(correctAnswer)) {
            rightInARow3++;
            rightInARow5++;
            x.setBackground(Color.GREEN);
            isCorrect = true;
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String q = questionLabel.getText();
                    newQuestion(q+"newq", new String[]{q,"og","o1","p1"}, q);
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            x.setBackground(Color.RED);
            x.add(new JLabel("Wrong! Try again!"));
        }

    }
}