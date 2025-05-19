public class Question{
    public Question(){
        private String question;
        private double answer;
    }
    ArrayList<Question> questions  = new ArrayList<Question>();
    ArrayList<String> answers  = new ArrayList<String>();
    questions.add("Solve the quadratic equation: $2x^2 - 5x - 3 = 0$");
        questions.add("Simplify the expression: $\\frac{x^2 - 4}{x + 2}$");
        questions.add("Solve the inequality: $|3x - 2| < 7$");
        questions.add("Find the equation of the line passing through the points $(1, 5)$ and $(-2, -1)$ in slope-intercept form.");
        questions.add("Simplify the radical expression: $\\sqrt{72x^3y^4}$");
        questions.add("Solve the system of equations:\n$\\begin{cases} 2x + y = 7 \\ x - 3y = -1 \end{cases}$");
        questions.add("Evaluate the logarithm: $\\log_3 81$");
        questions.add("Expand the binomial: $(2x - 3)^3$");
        questions.add("Find the inverse of the function: $f(x) = 4x + 9$");
        questions.add("Solve the exponential equation: $3^{2x - 1} = 27$");
        questions.add("Simplify the rational expression: $\\frac{x^2 + 5x + 6}{x^2 - 9}$");
        questions.add("Find the domain of the function: $g(x) = \\frac{1}{\\sqrt{x - 4}}$");
        questions.add("Solve the logarithmic equation: $\\log_2(x + 3) = 4$");
        questions.add("Write the equation of a circle with center $(-3, 2)$ and radius $5$.");
        questions.add("Simplify the trigonometric expression: $\\sin^2(\\theta) + \\cos^2(\\theta)$");
        questions.add("Find the roots of the polynomial: $x^3 - 8 = 0$");
        questions.add("Solve the rational equation: $\\frac{2}{x - 1} + \\frac{3}{x + 2} = 1$");
        questions.add("Evaluate the expression: $16^{3/4}$");
        questions.add("Factor the polynomial: $x^4 - 16$");
        questions.add("Find the vertex of the parabola: $y = -x^2 + 4x - 1$");
        questions.add("Solve the trigonometric equation for $0 \\le \\theta < 2\\pi$: $\\cos(\\theta) = \\frac{\\sqrt{3}}{2}$");
        questions.add("Simplify the expression: $\\frac{(a^2b^{-3})^2}{a^{-1}b^4}$");
        questions.add("Find the nth term of the arithmetic sequence where $a_1 = 7$ and the common difference $d = -2$.");
        questions.add("Find the sum of the first 5 terms of the geometric sequence where $a_1 = 3$ and the common ratio $r = 2$.");
        questions.add("Convert the angle $120^\circ$ to radians.");
        questions.add("Evaluate $\\tan(\\frac{5\\pi}{6})$.");
        questions.add("Solve the system of inequalities graphically:\n$\\begin{cases} y > 2x - 1 \\ y \le -x + 3 \end{cases}$ (Describe the shaded region)");
        questions.add("Find the number of permutations of 7 distinct objects taken 3 at a time.");
    public String getQuestion(ArrayList<String> q){
        int randomQ = (int)(Math.random()*q.size());
        return questions.get(randomQ);
    }
   ` public String askInput(){
    //import scanner and allat

   }   

}
 

