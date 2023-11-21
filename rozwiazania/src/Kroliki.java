public class Kroliki {
    public static void main(String[] args) {
        kroliki(1, 0, 1);
    }

    public static void kroliki(int mlode, int stare, int miesiac) {
        int populacja = mlode + stare;

        // Sprawdzanie, czy populacja przekroczyła 100 par
        if (populacja >= 100) {
            System.out.println("\nPo " + miesiac + " 100 par");
            return; // Kończenie działania programu
        }

        // Obliczanie nowej populacji
        int noweMlode = stare;
        stare += mlode;

        // Rekurencyjne wywołanie funkcji dla następnego miesiąca
        kroliki(noweMlode, stare, miesiac + 1);
    }
}