package ee.bcs.valiit;

import java.io.*;

/*
            Kirjutada Java programm, mis loeb failist visits.txt sisse looduspargi külastajad erinevatel jaanuari päevadel ning
            a) sorteerib külastuspäevad külastajate arvu järgi kasvavalt ning prindib tulemuse konsoolile;
            b) prindib konsoolile päeva, mil külastajaid oli kõige rohkem.
            Faili asukoht tuleb programmile ette anda käsurea parameetrina.
         */

public class exercise6 {
    public static void main(String[] args) throws Exception {
        // pass the path to the file as a parameter
        try (FileReader fr = new FileReader("C:\\Users\\Meelis\\Desktop\\Java\\visits.txt")) {

            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
        }
    }
}
