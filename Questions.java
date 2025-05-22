public class Questions {
    private String question;
    private String[] answers;
    private String correctAns;
    public Questions(String q, String[] ans, String cor) {
        question = q;
        answers = ans;
        correctAns = cor;
   }
    public String getQuestion() {
        return question;
    }
    public String[] getAnswers() {
        return answers;
    }
    public String getCorrectAns() {
        return correctAns;
    }
    public void setQuestion(String q) {
        question = q;
    }
    public void setAnswers(String[] ans) {
        answers = ans;
    }
    public void setCorrectAns(String cor) {
        correctAns = cor;
    }
}
 

