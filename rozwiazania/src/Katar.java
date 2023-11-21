public class Katar {
    private static int wielkoscPopulacji = 100000;

    private static void przebiegEpidemii() {
        int[] chorzy = new int[wielkoscPopulacji];
        chorzy[1] = 10;

        for (int dzien = 1; dzien < wielkoscPopulacji; dzien++) {
            if (dzien >= 2) {
                int nowiChorzy = (int) Math.floor(chorzy[dzien - 1] * 0.5 * 2);
                chorzy[dzien] = chorzy[dzien - 1] + nowiChorzy;

                if (dzien >= 8) {
                    chorzy[dzien] -= chorzy[dzien - 7];
                }
            }

            System.out.println("Dzień: " + dzien + ", licz:" + chorzy[dzien]);

            if (chorzy[dzien] >= wielkoscPopulacji / 2) {
                System.out.println("\n\tLiczba chorych mieszkańców.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Przebieg epidemii kataru:");
        przebiegEpidemii();
    }
}
