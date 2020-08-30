package ee.bcs.valiit;

import java.util.Random;
import java.util.Scanner;

// Enne kui seda tegema hakkad tee ära Lesson 2 (välja arvatud ülesanded 6, 8, 9)
public class Lesson3Hard {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta sisesta soovitud meetod: ");

        String funktsioon = scanner.nextLine();

        if (funktsioon.equalsIgnoreCase("randomGame")) {
            System.out.println("Arva mis numbri valisin 1-100 vahel, kokku 10 katset.");
            Random random = new Random();
            int i = random.nextInt(100);
            int x = 0; // kasutaja sisestatud number

            while (x != i) {

                for (int a = 1; a <= 10; a++) {

                    x = scanner.nextInt();
                    System.out.println(" ");

                    if (i > x) {
                        System.out.println("Arv on suurem kui sisestatud number, jaanud " + (10 - a) + " korda");
                    } else if (i < x) {
                        System.out.println("Arv on vaiksem kui sisestatud number, jaanud " + (10 - a) + " korda");
                    } else {
                        System.out.println("Arvasid ara oige numbri: " + "\"" + i + "\"" + " - " + a + " katsega");
                    }
                }
            }

        }

    }


    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        return 0;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks


    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";
    }
}
