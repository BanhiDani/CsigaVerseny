package csigaverseny;

public class Program {
    public static void main(String[] args) {

        // Minden kör kiírása
         CsigaVerseny jatek = new CsigaVerseny(5);

        // Csak a 3. kör kiírása
        //CsigaVerseny jatek = new CsigaVerseny(5, 3);

        // Csak az utolsó kör kiírása
        //CsigaVerseny jatek = new CsigaVerseny(5, KiirasMod.UTOLSO);

        for (int i = 1; i <= jatek.getKorokSzama(); i++) {
            jatek.start(i);
        }

        System.out.println(jatek.eredmenyHirdetes());
    }
}
