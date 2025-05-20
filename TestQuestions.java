public class TestQuestions{
    private ArrayList<Questions>() questions;
}

public String giveQuestion(){
    int random = (int)(Math.random()*question.size());
    return questions.get(random).getQuestion();
}



