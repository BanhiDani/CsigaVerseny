package csigaverseny;

import java.util.Scanner;

public class Jatekos {
    private Szin tippeltSzin;
    private Scanner scan = new Scanner(System.in);

    public Jatekos(String nev) {
    }

    public void tippel() {
        System.out.println("Tippelj melyik csiga fog nyerni (piros, kek, zold):");
        String tipp = scan.nextLine();

        while (!(tipp.equals("piros") || tipp.equals("kek") || tipp.equals("zold"))) {
            System.out.println("Hibas tipp. Add meg ujra (piros, kek, zold):");
            tipp = scan.nextLine();
        }

        tippeltSzin = switch (tipp) {
            case "piros" -> Szin.PIROS;
            case "kek" -> Szin.KEK;
            default -> Szin.ZOLD;
        };
    }

    public String getTippeltSzin() {
        if (tippeltSzin == Szin.KEK) return "kek";
        if (tippeltSzin == Szin.PIROS) return "piros";
        return "zold";
    }
}
