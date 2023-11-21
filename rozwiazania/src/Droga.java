public class Droga {

    final static int N = 9;
    static int[][] polaczenia = {
            {0, 300, 402, 356, -1, -1, -1, -1, -1},
            {300, 0, -1, -1, 440, 474, -1, -1, -1},
            {402, -1, 0, -1, -1, 330, -1, -1, -1},
            {356, -1, -1, 0, -1, -1, 823, -1, -1},
            {-1, 440, -1, -1, 0, -1, -1, 430, -1},
            {-1, 474, 330, -1, -1, 0, 813, 365, 774},
            {-1, -1, -1, 823, -1, 813, 0, -1, 403},
            {-1, -1, -1, -1, 430, 365, -1, 0, 768},
            {-1, -1, -1, -1, -1, 774, 403, 768, 0} };
    static String[] miasta = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt", "Bukareszt", "Zagrzeb", "Sofia"};


    private static int znajdzMiastoZNajwiekszaIlosciaPolaczen() {
        int miastoZNajwiekszaIloscia = -1;
        int maksymalnaIloscPolaczen = -1;

        for (int i = 0; i < N; i++) {
            int iloscPolaczen = 0;
            for (int j = 0; j < N; j++) {
                if (polaczenia[i][j] > 0) {
                    iloscPolaczen++;
                }
            }

            if (iloscPolaczen > maksymalnaIloscPolaczen) {
                maksymalnaIloscPolaczen = iloscPolaczen;
                miastoZNajwiekszaIloscia = i;
            }
        }
        return miastoZNajwiekszaIloscia;
    }

    // r

    public static void main(String[] args) {
        int start = znajdzMiastoZNajwiekszaIlosciaPolaczen();
        int cel = 8; // Sofia
        boolean[] odwiedzone = new boolean[N];
        int dlugoscTrasy = 0;
        StringBuilder trasa = new StringBuilder(miasta[start]);

        while (start != cel) {
            int nastepneMiasto = znajdzNastepneMiasto(start, odwiedzone);
            if (nastepneMiasto == -1) {
                System.out.println("Nie znaleziono trasy.");
                return;
            }

            odwiedzone[nastepneMiasto] = true;
            dlugoscTrasy += polaczenia[start][nastepneMiasto];
            trasa.append(" -> ").append(miasta[nastepneMiasto]);
            start = nastepneMiasto;
        }

        System.out.println("Najkrótsza trasa ma długość: " + dlugoscTrasy + " km.");
        System.out.println("Trasa prowadzi przez: " + trasa);
    }
    private static int znajdzNastepneMiasto(int aktualneMiasto, boolean[] odwiedzone) {
        int nastepneMiasto = -1;
        int najkrotszaOdleglosc = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            if (polaczenia[aktualneMiasto][i] > 0 && polaczenia[aktualneMiasto][i] < najkrotszaOdleglosc && !odwiedzone[i]) {
                najkrotszaOdleglosc = polaczenia[aktualneMiasto][i];
                nastepneMiasto = i;
            }
        }
        return nastepneMiasto;
    }


}