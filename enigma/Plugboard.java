package enigma;

import java.util.ArrayList;
import java.util.Random;

public class Plugboard {
    Background background;

    Random rand = new Random();

    int plug(int in) {
        int plg = rand.nextInt(26) + 1;
        background.back_plug.putIfAbsent(in, new ArrayList<Integer>());
        background.back_plug.get(in).add(plg);
//        System.out.println("Inside plug : " + in + " -> " + plg);
        return plg;
    }

    int sec_plug(int n) {
        int plg = rand.nextInt(26) + 1;
        background.main_plug.putIfAbsent(n, new ArrayList<Integer>());
        background.main_plug.get(n).add(plg);
//        System.out.println("Inside sec_plug");
        return plg + 1;
    }

    void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}