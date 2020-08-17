import java.util.Random;

public class Rotors {
    Random rand = new Random();
    //int slow_start = 1, med_start = 1, fast_start = 1;
    int scnt = 0, mcnt = 0, fcnt = 0;
    int slow(int input) {
        scnt++;
        return input = rand.nextInt(26);
    }

    int medium(int input) {
        if(scnt == 15) {
            mcnt++;
            scnt = 0;
            return input = rand.nextInt(26);
        }
        return input;
    }

    int fast(int input) {
        if(mcnt == 9) {
            fcnt++;
            return input = rand.nextInt(26);
        }
        return input;
    }
}