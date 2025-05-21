public class Questions {
    private String question;
    private String[] answers;
    private String correctAns;
    public Questions(String q, String[] ans, String cor) {
        question = q;
        answers = ans;
        correctAns = cor;
   }
   public String getQuestion(){
    return question;
   }
   public String getAnswers(){
    String result = "";
    for(String i:answers){
        result+=(i + "   ");
    }
    return result;
   }
   public String getCorrect(){
    return correctAns;
   }
}
 

