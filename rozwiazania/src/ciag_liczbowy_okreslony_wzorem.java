// kolokwium1v3z1


/*Dany jest pewien ciąg liczbowy (f(n)), którego kolejne elementy określone są wzorem:
  f(n) =
  1 dla n=1 lub n=2
  2*f(n-1) dla n>2  i n%3=0
  f(n-2)^2 dla n>2 i n%3=1
  2^f(n-2) dla n>2 i n%3=2
Utwórz projekt, a w nim metodę (funkcję) wykorzystującą metodę programowania dynamicznego. Za pomocą wywołania utworzonej metody wyznacz dziesiąty element tego ciągu.

*/

































public class ciag_liczbowy_okreslony_wzorem {

    // Metoda wykorzystująca programowanie dynamiczne do obliczenia n-tego wyrazu ciągu
    public static int wyrazCiągu(int n) {
        if (n == 1 || n == 2) return 1;

        int[] f = new int[n + 1];
        f[1] = f[2] = 1;

        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0) {
                f[i] = 2 * f[i-1];
            } else if (i % 3 == 1) {
                f[i] = f[i-2] * f[i-2];
            } else if (i%3==2){
                f[i] = (int) Math.pow(2, f[i-2]); // Używamy Math.pow() do obliczenia potęgi
            }
        }

        return f[n];
    }

    public static void main(String[] args) {
        System.out.println("Dziesiąty wyraz ciągu wynosi: " + wyrazCiągu(10));
    }
}
