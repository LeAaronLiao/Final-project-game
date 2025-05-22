import java.util.ArrayList;

public class TestQuestions {
    private static ArrayList<Questions> quizQuestions;

    public TestQuestions() {
        quizQuestions = new ArrayList<Questions>();
        // math
        quizQuestions.add(new Questions("What is 15 + 7?", new String[]{"21", "22", "23", "20"}, "22"));
        quizQuestions.add(new Questions("What is 30 - 12?", new String[]{"16", "18", "20", "15"}, "18"));
        quizQuestions.add(new Questions("What is 6 * 8?", new String[]{"42", "48", "54", "36"}, "48"));
        quizQuestions.add(new Questions("What is 72 / 9?", new String[]{"7", "8", "9", "6"}, "8"));
        quizQuestions.add(new Questions("What is 100 - 45?", new String[]{"50", "55", "60", "45"}, "55"));

        // trivia
        quizQuestions.add(new Questions("What is the capital of France?", new String[]{"Berlin", "Rome", "Paris", "London"}, "Paris"));
        quizQuestions.add(new Questions("What is the largest planet in our solar system?", new String[]{"Mars", "Jupiter", "Saturn", "Earth"}, "Jupiter"));
        quizQuestions.add(new Questions("What gas do plants primarily absorb from the atmosphere?", new String[]{"Oxygen", "Nitrogen", "Carbon Dioxide", "Hydrogen"}, "Carbon Dioxide"));
        quizQuestions.add(new Questions("How many continents are there?", new String[]{"5", "6", "7", "8"}, "7"));
        quizQuestions.add(new Questions("What is the chemical formula for water?", new String[]{"O2", "H2O", "CO2", "NACL"}, "H2O"));

        // history
        quizQuestions.add(new Questions("In what year did World War II end?", new String[]{"1939", "1945", "1950", "1918"}, "1945"));
        quizQuestions.add(new Questions("Who was the first President of the United States?", new String[]{"Thomas Jefferson", "Abraham Lincoln", "George Washington", "John Adams"}, "George Washington"));
        quizQuestions.add(new Questions("When did the Titanic sink?", new String[]{"1905", "1912", "1923", "1931"}, "1912"));
        quizQuestions.add(new Questions("Which ancient civilization built the pyramids?", new String[]{"Romans", "Greeks", "Egyptians", "Mayans"}, "Egyptians"));
        quizQuestions.add(new Questions("Who discovered America?", new String[]{"Marco Polo", "Ferdinand Magellan", "Vasco da Gama", "Christopher Columbus"}, "Christopher Columbus"));

        // geography
        quizQuestions.add(new Questions("Which is the longest river in the world?", new String[]{"Amazon River", "Mississippi River", "Nile River", "Yangtze River"}, "Nile River"));
        quizQuestions.add(new Questions("What is the highest mountain in the world?", new String[]{"K2", "Mount Kilimanjaro", "Mount Everest", "Mount Fuji"}, "Mount Everest"));
        quizQuestions.add(new Questions("Which ocean is the largest?", new String[]{"Atlantic Ocean", "Indian Ocean", "Pacific Ocean", "Arctic Ocean"}, "Pacific Ocean"));
        quizQuestions.add(new Questions("What country is known as the 'Land of the Rising Sun'?", new String[]{"China", "South Korea", "Japan", "Thailand"}, "Japan"));
        quizQuestions.add(new Questions("Which desert is the largest hot desert in the world?", new String[]{"Sahara Desert", "Gobi Desert", "Arabian Desert", "Kalahari Desert"}, "Sahara Desert"));

        // pop culture
        quizQuestions.add(new Questions("Who sings the song 'Break Stuff'?", new String[]{"The Beatles", "Led Zeppelin", "Limp Bizkit", "Pink Floyd"}, "Queen"));
        quizQuestions.add(new Questions("What is the name of the main character in the 'Super Mario' video game series?", new String[]{"Luigi", "Wario", "Bowser", "Mario"}, "Mario"));
        quizQuestions.add(new Questions("Which movie features a character named 'Buzz Lightyear'?", new String[]{"Cars", "Finding Nemo", "Toy Story", "Monsters, Inc."}, "Toy Story"));
        quizQuestions.add(new Questions("What is the name of the friendly ghost in the popular cartoons?", new String[]{"Slimer", "Casper", "Ghosty", "Spooky"}, "Casper"));
        quizQuestions.add(new Questions("Which band had hits like 'B.Y.O.B' and 'Toxicity'?", new String[]{"Pearl Jam", "System of a Down", "Nirvana", "Alice in Chains"}, "System of a Down"));
    }

    public static Questions giveQuestions() {
        int random = (int)(Math.random() * quizQuestions.size());
        Questions rand = quizQuestions.get(random);
        return rand;
    }
}