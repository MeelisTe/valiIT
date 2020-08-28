package ee.bcs.valiit;

public class Lesson1MathUtil {

    public static void main(String[] args) {
        System.out.println(min(1, 5));
        System.out.println(max(2, 6));
        System.out.println(abs(-4));
        System.out.println(isEven(6));
        System.out.println(min2(3, 5, -5));
        System.out.println(max2(4, 6, -5));
    }

    public static int min(int a, int b) {
        // TODO tagasta a ja b väikseim väärtus
        if (a > b) {
            return b;
        } else {
            return a;
        }
    }

    public static int max(int a, int b) {

        // TODO tagasta a ja b suurim väärtus
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int abs(int a) {
        // TODO tagasta a absoluut arv
        if (a > 0) {
            return a;
        } else {
            return (-a);
        }
    }

    public static boolean isEven(int a) {
        // TODO tagasta true, kui a on paaris arv
        if (a % 2 == 0) {
            return true;
        } else {
            // tagasta false kui a on paaritu arv
            return false;
        }
    }

    public static int min2(int a, int b, int c) {
        // TODO tagasta a, b ja c väikseim väärtus
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    public static int max2(int a, int b, int c) {
        // TODO tagasta a, b ja c suurim väärtus
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}


