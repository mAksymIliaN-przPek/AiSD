/*Dana jest tabela nominałów monet i ich ilość:
1gr	2gr	5gr	10gr	20gr	50gr	1zł	2zł	5zł
5	7	4	1	     5	     3	    0	2	5
Uwzględniając powyższe dane skonstruuj metodę (funkcję), do której na wejście podajemy pewną kwotę pieniędzy, czyli resztę,
jaką trzeba wydawać; natomiast na wyjściu wypisywane są monety za pomocą których należy tę kwotę wydać.
Program powinien wydawać resztę za pomocą możliwie najmniejszej liczby monet,
a w przypadku braku możliwości wydania reszty informować o tym użytkownika.*/









































public class monety {

    public static void main(String[] args) {
        int kwota = 197; // Przykładowa kwota w groszach do wydania
        wydajReszte(kwota);
    }

    public static void wydajReszte(int kwota) {
        int[] nominaly = {1, 2, 5, 10, 20, 50, 100, 200, 500}; // Nominały monet w groszach
        int[] dostepneMonety = {5, 7, 4, 1, 5, 3, 0, 2, 5}; // Dostępna liczba monet dla każdego nominału


        for (int i = nominaly.length - 1; i >= 0; i--) {
            int liczbaWykorzystanychMonet = Math.min(kwota / nominaly[i], dostepneMonety[i]);
            kwota -= liczbaWykorzystanychMonet * nominaly[i];
            if (liczbaWykorzystanychMonet > 0) {
                System.out.println("Nominał " + nominaly[i] + "gr: " + liczbaWykorzystanychMonet);
            }
        }

        if (kwota > 0) {
            System.out.println("Nie można wydać dokładnej reszty.");
        }
    }
}
