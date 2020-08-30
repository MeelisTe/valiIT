package ee.bcs.valiit;

import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Scanner;

public class Lesson2 {


    //    exercise1();
    //     exercise2(4);
    //     exercise3(2, 5);
    //     fibonacci(5);
    // exercise5();


    public static int[] exercise1(int[] m) {
        // TODO loo 10 elemendile täisarvude massiiv
        // TODO loe sisse konsoolist 10 täisarvu
        // TODO trüki arvud välja vastupidises järiekorras

        int[] result = new int[10];

        for (int i = 9; i >= 0; i--) {
            result[9 - i] = m[i];
        }
        return result;
    }


    public static void exercise2(int x) {
        // TODO prindi välja x esimest paaris arvu
        // Näide:
        // Sisend 5
        // Väljund 2 4 6 8 10
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mitu paarisarvu soovid printida?");
        int a = scanner.nextInt();
        for (int i = 1; i <= a; i++) {
            System.out.println(i * 2);
        }
    }


    public static void exercise3(int x, int y) {
        // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta korrutustabeli laius ja kõrgus");

        x = scanner.nextInt();
        y = scanner.nextInt();

        for (int i = 1; i <= y; i++) {
            System.out.println(" ");
            for (int j = 1; j <= x; j++) // Alustab sellest for tsüklist(for tsükkel for tsükli sees)
                System.out.print(j * i + "\t");
            // \t - tab
        }
    }
    // TODO näiteks x = 3 y = 3


    // TODO väljund
    // 1 2 3 4
    // 2 4 6 8
    // 3 6 9 12
    // 4 8 12 16


    public static int fibonacci(int n) {
        // TODO
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
        // 0, 1, 1, 2, 3, 5, 8, 13, 21
        // Tagasta fibonacci jada n element

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta Fibonacci jada n element");

        n = scanner.nextInt();
        int fib0 = 0;
        int fib1 = 1;
        int result;

        System.out.println("Fibonacci jada on ");
        for (int i = 0; i < n; i++) {
            if (i <= 1)
                result = i;
            else {
                result = fib0 + fib1;
                fib0 = fib1;
                fib1 = result;
            }
            System.out.println(result);
        }



   /*e    int fib2 = fib1 + fib0;
        int fib3 = fib2 + fib1;
        int fib4 = fib3 + fib2;

        System.out.println(fib0);
        System.out.println(fib1);
        System.out.println(fib2);
        System.out.println(fib3);
        System.out.println(fib4);

        for (int i = 0; i >= n-1; i++)

     e*/

        return 0;
    }

    public static void exercise5() {
        // https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=36
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta 2 arvu: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Sisestasid: " + x + " ja " + y);

        int maxpikkus = 0; // maksimaalne jada pikkus
        int maxpikkusfinal = 0;

        for (int i = x; i <= y; i++) {
            int pikkus = 1; // jada pikkus 1-ni jõudmiseks
            int i1 = i; // Võrdsustame i1 väärtuse i-ga ehk number mida vaatleme

            while (i1 != 1) {

                if (i1 % 2 == 0) {
                    i1 = i1 / 2;
                } else {
                    i1 = 3 * i1 + 1;
                }
                pikkus++;
            }

            if (maxpikkus < pikkus) { // Võrdleb hetkel olevat maksimumpikkust leitud pikkusega
                maxpikkus = pikkus; // Võrdsustab maksimumpikkuse antud while loop pikkusega
            }
        }
        System.out.println(x + " " + y + " " + maxpikkus);
    }

    public static void exercise6() {
        /*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */


    }

    public static void exercise7() {
        // TODO arvuta kasutades BigDecimali 1.89 * ((394486820340 / 15 ) - 4 )
        BigDecimal a = new BigDecimal(1.89);
        BigDecimal b = new BigDecimal("394486820345");
        BigDecimal c = new BigDecimal("15");
        BigDecimal d = new BigDecimal("4");
    }

    public static void exercise8() {
        /*
        Failis nums.txt on üksteise all 150 60-kohalist numbrit.

        Kirjuta programm, mis loeks antud numbrid failist sisse ja liidaks need arvud kokku ning kuvaks ekraanil summa.
        Faili nimi tuleb programmile ette anda käsurea parameetrina.

        VASTUS:
        Õige summa: 77378062799264987173249634924670947389130820063105651135266574
         */
    }

    public static void exercise9() {
        /* TODO
        Sama mis eelmises ülesandes aga ära kasuta BigInt ega BigDecimal klassi
         */
    }

}
