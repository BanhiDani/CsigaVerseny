package csigaverseny;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Csiga {
    private Szin szin;
    private int tav;
    private boolean gyorsito;
    private Random rnd;
    private int korLepes;
    private List<Boolean> lepesTipusok;

    public Csiga(Szin szin) {
        this.szin = szin;
        this.tav = 0;
        this.gyorsito = false;
        this.rnd = new Random();
        this.lepesTipusok = new ArrayList<>();
    }

    public int megy() {
        int lepesSzam = rnd.nextInt(4);

        boolean gyors = vanEGyorsito();

        if (gyors) {
            if (lepesSzam == 0) {
                lepesSzam++;
            } else {
                lepesSzam *= 2;
            }
        }

        korLepes = lepesSzam;

        for (int i = 0; i < lepesSzam; i++) {
            lepesTipusok.add(gyors);
        }

        tav += lepesSzam;
        return lepesSzam;
    }

    public boolean vanEGyorsito() {
        return gyorsito;
    }

    public void setGyorsito(boolean gyorsito) {
        this.gyorsito = gyorsito;
    }

    public int getKorLepes() {
        return korLepes;
    }

    public int getTav() {
        return tav;
    }

    public List<Boolean> getLepesTipusok() {
        return lepesTipusok;
    }

    public String csigaSzinek() {
        return switch (this.szin) {
            case KEK -> "\u001B[34m";
            case PIROS -> "\u001B[31m";
            default -> "\u001B[32m";
        };
    }
}
