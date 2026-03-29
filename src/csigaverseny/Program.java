package csigaverseny;

public class Program {
    public static void main(String[] args) {

        CsigaVerseny jatek = new CsigaVerseny(5);

        for (int i = 1; i <= jatek.getKorokSzama(); i++) {
            jatek.start(i);
        }

        System.out.println(jatek.eredmenyHirdetes());
    }
}
