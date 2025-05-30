import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionPanel extends JPanel {
    private boolean isCorrect;
    private Questions question;

    private JLabel questionLabel;
    private JLabel titleLabel;
    private JButton[] buttons;
    private JPanel buttonGrid;
    private JPanel mainPanel;
    public static int rightInARow = 0;
    public static int reviveQuota;

    public QuestionPanel(Questions question) {
        this.question = question;
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        titleLabel = new JLabel("Questions right in a row: " + rightInARow);
        titleLabel.setText("Questions right in a row: " + rightInARow);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(titleLabel);

        questionLabel = new JLabel(question.getQuestion(), SwingConstants.CENTER);
        questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        questionLabel.setPreferredSize(new Dimension(100, Javaswing.wsz / 2));
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        mainPanel.add(questionLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        // Button grid
        buttonGrid = new JPanel(new GridLayout(2, 2, 10, 10));
        buttons = new JButton[]{
            new JButton(question.getAnswers()[0]),
            new JButton(question.getAnswers()[1]),
            new JButton(question.getAnswers()[2]),
            new JButton(question.getAnswers()[3])
        };
        for (JButton x : buttons) {
            buttonGrid.add(x);
            if (isCorrect && x.getText().equals(question.getCorrectAns())) {
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

        buttonGrid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mainPanel.add(buttonGrid);
        add(mainPanel, BorderLayout.CENTER);
    }
    public void newQuestion() {
        Questions question = TestQuestions.giveQuestions();
        while(question.equals(this.question)) {
            question = TestQuestions.giveQuestions();
        }
        isCorrect = false;
        this.question = question;
        titleLabel.setText("Questions right in a row: " + rightInARow);
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
                    newQuestion();
                }
            });
            timer.setRepeats(false);
            timer.start();
        } else {
            x.setBackground(Color.RED);
            Javaswing.showMessage("wrong! try again");
            rightInARow = 0;
            reviveQuota = 10;
        }
        if(rightInARow % 3 == 0){
            Main.player.increaseAttackPower();
        }
        if(rightInARow % 5 == 0){
            Main.player.increaseDefensePower();
        }
        if(rightInARow == reviveQuota && Main.player.getHealth() <= 0) {
            Main.player.setHealth(100);
            Javaswing.showMessage("You have been healed to full health! Hit 'q' to exit and keep playing.");
        }
    }
}