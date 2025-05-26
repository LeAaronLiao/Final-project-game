import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionPanel extends JPanel {
    private boolean isCorrect;
    private Questions question;

    private JLabel questionLabel;
    private JButton[] buttons;
    private JPanel buttonGrid;
    private JPanel mainPanel;
    public static int rightInARow = 0;

    public QuestionPanel(Questions question) {
        this.question = question;
        // Use BorderLayout for full expansion
        setLayout(new BorderLayout());
        // Main panel with BorderLayout to control vertical sections
        JPanel mainPanel = new JPanel(new BorderLayout());
        this.mainPanel = mainPanel;
        // Label at the top (NORTH)
        JLabel label = new JLabel(question.getQuestion(), SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(100, Javaswing.wsz/2)); // optional height control
        questionLabel = label;
        mainPanel.add(label, BorderLayout.NORTH);
        // Button grid in CENTER
        JPanel buttonGrid = new JPanel(new GridLayout(2, 2, 10, 10)); // spacing between buttons;
        this.buttonGrid = buttonGrid;
        JButton[] buttons = new JButton[]{
            new JButton(question.getAnswers()[0]),
            new JButton(question.getAnswers()[1]),
            new JButton(question.getAnswers()[2]),
            new JButton(question.getAnswers()[3])
        };
        this.buttons = buttons;
        for(JButton x : buttons) {
            buttonGrid.add(x);
            if(isCorrect && x.getText().equals(question.getCorrectAns())) {
                x.setBackground(Color.GREEN);
            } else {
                x.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        checkAnswer(x);
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
    public void newQuestion(Questions question) {
        isCorrect = false;
        this.question = question;
        questionLabel.setText(question.getQuestion());
        for(int i = 0; i < buttons.length; i++) {
            buttons[i].setText(question.getAnswers()[i]);
            buttons[i].removeAll();
            buttons[i].setBackground(null); // Reset background color
        }
    }
    public void checkAnswer(JButton x) {
        if(x.getText().equals(question.getCorrectAns())) {
            rightInARow++;
            x.setBackground(Color.GREEN);
            isCorrect = true;
            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String q = questionLabel.getText();
                    newQuestion(TestQuestions.giveQuestions());
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            x.setBackground(Color.RED);
            Javaswing.showMessage("wrong! try again");
        }
        if(rightInARow % 3 == 0){
            Main.player.increaseAttackPower();
        }
        if(rightInARow % 5 == 0){
            Main.player.increaseDefensePower();
        }
        if(rightInARow == 10 && Main.player.getHealth() <= 0) {
            Main.player.setHealth(100);
            Javaswing.showMessage("You have been healed to full health! Hit 'q' to exit and keep playing.");
        }
    }
}