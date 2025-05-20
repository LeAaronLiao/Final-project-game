public class TestQuestions{
    private ArrayList<Questions>() questions;
}
public TestQuestions(ArrayList<Questions> qu){
    questions = qu;
}

public String giveQuestion(){
    int random = (int)(Math.random()*questions.size());
    return questions.get(random).getQuestion(); + //all answer choices
}



