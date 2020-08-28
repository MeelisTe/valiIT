package ee.bcs.valiit;

import java.util.Scanner;

public class Lesson1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sisesta soovitud funktsioon");
        String funktsioon = scanner.nextLine();

        excersie1();
        excersie2();
        excersie3();
        excersie4();
    }

    public static void excersie1(){
        // TODO
        // defineeri 3 muutujat a = 1, b = 1, c = 3
        // Prindi välja a==b ja a==c
        // Lisa rida a = c
        // Prindi välja a==b ja a==c, mis muutus???

        int a = 1;
        int b = 1;
        int c = 3;

        System.out.println(a==b && a==c);

        a = c;

        System.out.println(a==b && a==c);
    }

    public static void excersie2(){
        // TODO
        // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
        // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
        // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
        // Analüüsi tulemusi

        int x1 = 10;
        int x2 = 20;

        int y1 = ++x1;

        System.out.println(x1);
        System.out.println(y1);

        int y2 = x2++;

        System.out.println(x2);
        System.out.println(y2);

    }

    public static void excersie3(){
        // TODO
        // Loo arvulised muutujad
        // a = 18 % 3
        // b = 19 % 3
        // c = 20 % 3
        // d = 21 % 3
        // Prindi välja kõigi muutujate väärtused

        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;

        System.out.println(a+ "\n"+b+ "\n" +c+"\n" +d);

    }

    public static void excersie4(){
        // TODO
        // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
        // Trüki muutuja sisu välja

        String a = "\"\\\"\\\\\"\"";
        System.out.println(a);


    }

}
