public class Lody {
    final static int N = 6;
    static int[][] czas = {
            {0, 7, 20, 21, 12, 23},
            {27, 0, 13, 16, 46, 5},
            {53, 15, 0, 25, 27, 6},
            {16, 2, 35, 0, 47, 10},
            {31, 29, 5, 18, 0, 4},
            {28, 24, 1, 17, 5, 0}
    };
    static int minCzas = Integer.MAX_VALUE;
    static int[] lodyNajlepsze;

    public static void main(String[] args) {
        generuj();
        wypisz();
    }

    private static void generuj() {
        for (int start = 0; start < N; start++) {
            int obecnyCzas = 0;
            boolean[] uzyteLody = new boolean[N];
            int[] lody = new int[N];

            int obecnaMaszyna = start;
            uzyteLody[obecnaMaszyna] = true;
            lody[0] = obecnaMaszyna + 1;

            for (int i = 1; i < N; i++) {
                int najlepszyCzas = Integer.MAX_VALUE;
                int najlepszaMaszyna = -1;
                for (int j = 0; j < N; j++) {
                    if (!uzyteLody[j] && czas[obecnaMaszyna][j] < najlepszyCzas) {
                        najlepszyCzas = czas[obecnaMaszyna][j];
                        najlepszaMaszyna = j;
                    }
                }
                obecnyCzas += najlepszyCzas;
                obecnaMaszyna = najlepszaMaszyna;
                uzyteLody[najlepszaMaszyna] = true;
                lody[i] = najlepszaMaszyna + 1;
            }
            obecnyCzas += czas[obecnaMaszyna][start];

            if (obecnyCzas < minCzas) {
                minCzas = obecnyCzas;
                lodyNajlepsze = lody.clone();
            }
        }
    }

    private static void wypisz() {
        System.out.println("Minimalny czas produkcji: " + minCzas);
        System.out.print("Użyte lody: ");
        for (int lod : lodyNajlepsze) {
            System.out.print(lod + " ");
        }
    }
}
