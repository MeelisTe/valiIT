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

        } else if (funktsioon.equalsIgnoreCase("evenFibonacci")) {
            System.out.println(("Sisesta üks arv, arvutame fibonacci jada paarisarvude summa selle arvuni."));
            int x = scanner.nextInt();
            System.out.println(evenFibonacci(x));
        }

    }


    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x
        int fib0 = 0;
        int fib1 = 1;
        int result;

        System.out.println("Fibonacci jada on ");
        for (int i = 0; i < x; i++) {
            if (i <= 1)
                result = i;
            else {
                result = fib0 + fib1;
                fib0 = fib1;
                fib1 = result;
            }
            System.out.println(result);
        }
        return 0;
    }

    public static void randomGame() {
        // TODO kirjuta mäng mis võtab suvalise numbri 0-100, mille kasutaja peab ära arvama
        // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
        // ja kasutaja peab saama uuesti arvata
        // numbri ära aramise korral peab programm välja trükkima mitu katset läks numbri ära arvamiseks

// Tehtud

    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja -
        return "";

        //Hashmap
    }
}
