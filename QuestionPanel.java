import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QuestionPanel extends JPanel {
    private JTextArea questionTextArea;
    private JTextField answerTextField;
    private JButton submitButton;
    private JLabel feedbackLabel;

    public QuestionPanel() {
        System.out.println("QuestionPanel constructor called");
        setLayout(new BorderLayout());
        add(new JLabel("question"));
        questionTextArea = new JTextArea("What is the capital of France?");
        questionTextArea.setEditable(false);
        add(questionTextArea, BorderLayout.NORTH);

        answerTextField = new JTextField();
        add(answerTextField, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        add(submitButton, BorderLayout.EAST);

        feedbackLabel = new JLabel("");
        add(feedbackLabel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
            }
        });
    }

    private void checkAnswer() {
        String answer = answerTextField.getText().trim();
        if (answer.equalsIgnoreCase("Paris")) {
            feedbackLabel.setText("Correct!");
        } else {
            feedbackLabel.setText("Incorrect. Try again.");
        }
    }
}