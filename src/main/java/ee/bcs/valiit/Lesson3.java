package ee.bcs.valiit;

import java.util.Arrays;
import java.util.Scanner;

public class Lesson3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta soovitud funktsioon");
        String funktsioon = scanner.nextLine();

        if (funktsioon.equalsIgnoreCase("sum")) {
            System.out.println("Sisesta x ja y");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println("Summa on:" + sum(x, y));

        } else if (funktsioon.equalsIgnoreCase("summas")) {
            System.out.println("Sisesta x");
            int x = scanner.nextInt();
            System.out.println("Sisesta " + x + " täisarvu");
            int[] array = new int[x];

            for (int i = 0; i < x; i++) {
                array[i] = scanner.nextInt();
            }
            System.out.println("Summa on:" + summas(array));

        } else if (funktsioon.equalsIgnoreCase("factorial")) {
            System.out.println("Sisesta x");
            int x = scanner.nextInt();
            System.out.println(x + " faktoriaal on: " + factorial(x));

        } else if (funktsioon.equalsIgnoreCase("sort")) {
            System.out.println("Sisesta massiivi pikkus(arv)");
            int a = scanner.nextInt();
            System.out.println("Sisesta " + a + " täisarvu");
            int[] array = new int[a];

            for (int i = 0; i < a; i++) {
                array[i] = scanner.nextInt();
            }

            System.out.println("Massiiv suuruse järgi: " + (Arrays.toString(sort(array))));

        } else if (funktsioon.equalsIgnoreCase("reverseString")) {
            System.out.println("Sisesta sõna");
            String str = scanner.nextLine();

            System.out.println("Sisestatud sõna: " + str);

            System.out.println("Sisestatud sõna " + str + " tagurpidi on: " + reverseString(str));
        } else if (funktsioon.equalsIgnoreCase("isPrime")) {
            System.out.println("Sisesta arv");
            int x = scanner.nextInt();

            System.out.println(isPrime(x));
        }
    }

    public static int sum(int x, int y) {
        // TODO liida kokku ja tagasta x ja y väärtus
        int a = x + y;
        return a;

    }

    public static int summas(int[] x) {
        // Todo liida kokku kõik numbrid massivis x
        int summas = 0;
        for (int i = 0; i < x.length; i++) {
            summas = summas + x[i];
        }
        return summas;
    }

    public static int factorial(int x) {
        // TODO tagasta x faktoriaal.
        // Näiteks
        // x = 5
        // return 5*4*3*2*1 = 120
        int factorial = 1;
        for (int i = 1; i <= x; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int[] sort(int[] a) {
        // TODO sorteeri massiiv suuruse järgi
        // Näiteks {2, 6, 8, 1}
        // Väljund {1, 2, 6, 8}


        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {

                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;

                }
            }
        }
        return a;
    }

    public static String reverseString(String a) {
        // TODO tagasta string tagurpidi
        char[] in = a.toCharArray();
        int begin = 0;
        int end = in.length - 1;
        char temp;
        while (end > begin) {
            temp = in[begin];
            in[begin] = in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        // Näiteks:
        // a = "Test";
        // return tseT";
        return new String(in);
    }

    public static boolean isPrime(int x) {
        // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
        for (int i = 2; i < x; i++) {
            if (x % i == 0 && i != x) {
                return false;
            }
        } return true;

        }
    }





