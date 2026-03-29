package csigaverseny;

import java.util.Random;

public class CsigaVerseny {

    private Csiga[] csigak;
    private Jatekos j1;
    private Random RND;
    private int korokSzama;

    public CsigaVerseny(int korokSzama) {
        csigak = new Csiga[]{
            new Csiga(Szin.PIROS),
            new Csiga(Szin.KEK),
            new Csiga(Szin.ZOLD)
        };
        this.j1 = new Jatekos("Klari");
        this.korokSzama = korokSzama;
        this.RND = new Random();
    }

    public void gyorsitoSorsolas() {
        boolean vanE = RND.nextDouble() < 0.20;

        int sors = RND.nextInt(3);
        csigak[sors].setGyorsito(vanE);
    }

    public String korStatisztikaKiirasa(int korokSzama) {
        String szoveg;

        szoveg = korokSzama + ". kor\n";
        szoveg += "piros csiga lepesei a korben: " + csigak[0].getKorLepes();
        szoveg += "\nkek csiga lepesei a korben: " + csigak[1].getKorLepes();
        szoveg += "\nzold csiga lepesei a korben: " + csigak[2].getKorLepes();
        return szoveg;
    }

    public String csigaKiiras() {
        String szoveg;
        String reset = "\u001B[0m";

        szoveg = "________________________________\n";
        for (int i = 0; i < csigak.length; i++) {

            for (boolean gyors : csigak[i].getLepesTipusok()) {
                String jel = gyors ? "=" : "_";
                szoveg += csigak[i].csigaSzinek() + jel;
            }

            szoveg += "🐌\n" + reset;

            if (i < csigak.length - 1) {
                szoveg += "    ____    ____    ____    ____   \n";
            }
        }
        szoveg += "________________________________";

        return szoveg;
    }

    public void start(int korSzama) {
        gyorsitoSorsolas();

        for (Csiga csiga : csigak) {
            csiga.megy();
        }

        System.out.println(korStatisztikaKiirasa(korSzama));
        System.out.println(csigaKiiras());

        for (Csiga csiga : csigak) {
            csiga.setGyorsito(false);
        }
    }

    public int getKorokSzama() {
        return korokSzama;
    }

    public String eredmenyHirdetes() {
        String kiiras;

        if (csigak[0].getTav() > csigak[1].getTav() && csigak[0].getTav() > csigak[2].getTav()) {
            kiiras = "A piros csiga nyert!\n";
        } else if (csigak[1].getTav() > csigak[2].getTav()) {
            kiiras = "A kek csiga nyert!\n";
        } else {
            kiiras = "A zold csiga nyert!\n";
        }

        return kiiras;
    }
}
