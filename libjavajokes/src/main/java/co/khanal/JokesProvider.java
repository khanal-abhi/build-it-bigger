package co.khanal;

import java.util.ArrayList;
import java.util.List;

public class JokesProvider {
    private List<String> jokes;

    public JokesProvider(){
        jokes = new ArrayList<>();
    }

    public void populateJokes(){
        jokes.add("Just changed my Facebook name to ‘No one' so when I see stupid posts I can click like and it will say ‘No one likes this'.");
        jokes.add("How do you make holy water? You boil the hell out of it.");
        jokes.add("I am a nobody, nobody is perfect, therefore I am perfect.");
        jokes.add("What do you call a bear with no teeth? -- A gummy bear!");
        jokes.add("If con is the opposite of pro, it must mean Congress is the opposite of progress?");
        jokes.add("I wondered why the frisbee was getting bigger, and then it hit me.");
        jokes.add("If 4 out of 5 people SUFFER from diarrhea; does that mean that one enjoys it?");
        jokes.add("I used to like my neighbors, until they put a password on their Wi-Fi.");
        jokes.add("What's the difference between a smart man and a stupid man? Nothing. They both think they know everything.");
        jokes.add("Never argue with a fool, they will lower you to their level, and then beat you with experience.");
    }

    public List<String> getJokes(){
        return jokes;
    }
}
