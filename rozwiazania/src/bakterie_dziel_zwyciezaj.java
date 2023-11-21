/*Pewien rodzaj bakterii charakteryzuje się poniższymi cechami:

Bakterie rozmnażają się przez podział, w którego wyniku z jednej bakterii powstaje 2 nowe.
Podział ten następuje co 2 minuty.
Wszystkie bakterie dzielą się w tych samych chwilach.
Co 10 minut wymiera 50% bakterii.
Pytanie: Czy i po jakim czasie (ile minut) liczba bakterii zwiększy się 1000 razy? Przyjąć, że początkowa liczba bakterii wynosi 12.

Utwórz projekt, a w nim metodę (funkcję) umożliwiającą wyznaczanie liczby bakterii po upływie danego czasu (w minutach)
wykorzystując metodę dziel i zwyciężaj. Następnie wywołaj utworzoną metodę w funkcji głównej w
celu znalezienia odpowiedzi na pytanie zawarte w treści tego zadania.

Uwaga: do obliczeń należy wykorzystać zmienną typu double.*/
























public class bakterie_dziel_zwyciezaj {

    public static void main(String[] args) {
        double poczatkowaIlosc = 12.0;
        double docelowaIlosc = poczatkowaIlosc * 1000; // 1000-krotność ilości początkowej
        double czas = obliczCzasDoOsiagnieciaIlosci(poczatkowaIlosc, docelowaIlosc, 0);
        System.out.println("Czas potrzebny do osiągnięcia " + docelowaIlosc + " bakterii wynosi: " + czas + " minut.");
    }

    public static double obliczCzasDoOsiagnieciaIlosci(double obecnaIlosc, double docelowaIlosc, double czas) {
        // Jeśli obecna ilość bakterii przekroczyła już docelową, zwróć obecny czas
        if (obecnaIlosc >= docelowaIlosc) {
            return czas;
        } else {
            // Oblicz, czy jesteśmy w punkcie, w którym bakterie umierają (co 10 minut)
            if (czas > 0 && czas % 10 == 0) {
                obecnaIlosc *= 0.5; // Wymiera 50% bakterii
            }
            // Podwajamy liczbę bakterii co 2 minuty i zwiększamy czas o 2
            return obliczCzasDoOsiagnieciaIlosci(obecnaIlosc * 2, docelowaIlosc, czas + 2);
        }
    }
}
