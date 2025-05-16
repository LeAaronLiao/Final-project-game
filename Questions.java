public class Questions{
    public Questions(){

    }
    ArrayList<String> questions  = new ArrayList<String>();
    ArrayList<String> answers  = new ArrayList<String>();
    questions.add("If x = 1 and y=2, what is 3x+4y?");
    questions.add("What is the slope + x intercept of this equation: 3x+12y=3");
    questions.add("");
    public String getQuestion(){
        int randomQ = (int)(Math.random()*questions.size());
        return questions.get(randomQ);
    }
   `    

}




