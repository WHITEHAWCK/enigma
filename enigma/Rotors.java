package enigma;

import java.util.ArrayList;
import java.util.Random;

public class Rotors {
    Random rand = new Random();
    Background background;

    int medium_start = rand.nextInt(26), fast_start = rand.nextInt(26);
    int medium_two = rand.nextInt(26), fast_two = rand.nextInt(26);
    int scnt = 0, mcnt = 0, fcnt = 0;

    int slw = rand.nextInt(26) + 1;
    int slow(int input) {
        scnt++;
        background.back_slow.putIfAbsent(input, new ArrayList<Integer>());
        background.back_slow.get(input).add(slw);
//        System.out.println("In slow : " + input + " -> " + slw);
        return slw;
    }

    int sec_slow(int input) {
        scnt++;
//        System.out.println("In sec slow...");
        return slw + 1;
    }

    int med = rand.nextInt(26) + 1;
    int medium(int input) {
//        System.out.println("in medium rotor...medium_start = " + medium_start);
        if(scnt == 15) {
            mcnt++;
            scnt = 0;
            background.back_medium.putIfAbsent(input, new ArrayList<Integer>());
            background.back_medium.get(input).add(med);
//            System.out.println("In medium if : " + input + " -> " + med);
            return med;
        }
        background.back_medium.putIfAbsent(input, new ArrayList<Integer>());
        background.back_medium.get(input).add(medium_start);
//        System.out.println("In medium else : " + input + " -> " + medium_start);
        return medium_start;
    }

    int sec_medium(int input) {
//        System.out.println("in second medium...");
        return med + 1;
    }

    int fst = rand.nextInt(26) + 1;
    int fast(int input) {
//        System.out.println("in fast rotor...fast_start = " + fast_start);
        if(mcnt == 9) {
            fcnt++;
            mcnt = 0;
            background.back_fast.putIfAbsent(input, new ArrayList<Integer>());
            background.back_fast.get(input).add(fst);
//            System.out.println("In fast if : " + input + " -> " + fst);
            return fst;
        }
        background.back_fast.putIfAbsent(input, new ArrayList<Integer>());
        background.back_fast.get(input).add(fast_start);
//        System.out.println("In fast else : " + input + " -> " + fast_start);
        return fast_start;
    }
}