package enigma;

import enigma.*;

import java.util.*;

public class Driver {
    static LinkedHashMap<Integer, Character> alpha = new LinkedHashMap<Integer, Character>(26);

    static void fillAlpha() {
        for(char ch = 'A'; ch <= 'Z'; ch++) {
            alpha.put((int)ch - 64, ch);
        }
    }

    public static void main(String[] args) {
//        Filling the reference for alphabets and their numbers
        fillAlpha();

        String message;
        Scanner input = new Scanner(System.in);

//        Objects of the various classes in the package
        Plugboard plugboard = new Plugboard();
        Background background = new Background() {};
        Rotors rotors = new Rotors();

//        Asking for the use input
        System.out.print("Enter the message : ");
        message = input.next();
        message = message.toUpperCase();

//        The given message is converted to character array
        char[] message_char = message.toCharArray();

//        Magic happens here!!!
        for (char ch : message_char) {
//            System.out.println("\n" + ch + " = " + (int)ch);
            int p = plugboard.plug((int) ch);
//            System.out.println(background.back_plug);
            int s = rotors.slow(p);
//            System.out.println(background.back_slow);
            int m = rotors.medium(s);
//            System.out.println(background.back_medium);
            int f = rotors.fast(m);
//            System.out.println(background.back_fast);

            m = rotors.sec_medium(f);
//            System.out.println(background.back_medium);
            s = rotors.sec_slow(m);
//            System.out.println(background.back_slow);
            p = plugboard.sec_plug(s);
//            System.out.println(background.back_plug);
//            System.out.println(background.main_plug);
        }

        int[] keys = new int[background.back_plug.size()];
        int i = 0;
        for(Map.Entry<Integer, List<Integer>> entry : background.main_plug.entrySet()) {
            int key = entry.getKey();
            keys[i] = key;
            i++;
        }

//        Cheat sheet
//        System.out.print("Keys are : ");
//        for(int temp : keys) {
//            System.out.print(temp + " ");
//        }
//
        System.out.println("\n");
        System.out.println("Cheat Sheet\nplug\t-> " + background.back_plug);
        System.out.println("main_plug -> " + background.main_plug);
        System.out.println("slow\t-> " + background.back_slow);
        System.out.println("medium  -> " + background.back_medium);
        System.out.println("fast\t-> " + background.back_fast);
        System.out.println("Alphabet to number -> " + alpha);

//        Printing the encoded message
        System.out.print("\nEncoded message : ");
        for(int b = 0; b < message.length(); b++) {
            int key = background.main_plug.get(keys[0]).get(b);
            plugboard.delay();
            System.out.print(alpha.get(key));
        }
    }
}