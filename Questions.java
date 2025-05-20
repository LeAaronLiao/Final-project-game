public class Question{
    private String question;
    private int answer1;
    private int answer2;
    private int answer3;
    private int answer4;
    public Question(String q, int a1, int a2, int a3, int a4) {
        question = q;
        answer1 = a1;
        answer2 = a2;
        answer3 = a3;
        answer4 = a4;
   }
   public String getQuestion(){
    return question;
   }
   public int getAns1(){
    return answer1;
   }
   public int getAns2(){
    return answer2;
   }
   public int getAns3(){
    return answer3;
   }
   public int getAns4(){
    return answer4;
   }
}
 

