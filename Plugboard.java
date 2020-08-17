import java.util.LinkedHashMap;
import java.util.Random;

public class Plugboard {
    LinkedHashMap<Integer, Character> alpha = new LinkedHashMap<Integer, Character>(26);

    void fillPlug() {
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            alpha.put((int)ch, ch);
        }
    }

    Random rand = new Random();
    int plug() {
        fillPlug();
        return (rand.nextInt(26));
    }
}