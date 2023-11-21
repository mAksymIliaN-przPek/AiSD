/*W układzie współrzędnych dana jest figura ograniczona dwiema prostymi: y = 0, x = 1 oraz krzywą y = x^2 (zobacz rys.).

Pole tej figury wyrazić można jako stosunek liczby punktów należących do
figury do liczby wszystkich punktów z obszaru zaznaczonego na rysunku (x∈[0,1] i y∈[0,1]).
Napisz program zawierający metodę do obliczania pola tej figury za pomocą metody Monte Carlo.
Za pomocą wywołania utworzonej metody wyznacz pole tej figury (dla 100 losowych punktów należących do zaznaczonego obszaru).
Wykorzystaj wzór:

Pole = (liczba losowych punktów należących do figury) / (całkowita liczba losowych punktów) (9 pkt)*/

import java.util.Random;

public class pole_figury_monte_carlo {
    public static void main(String[] args) {
        int liczba_punktow = 100;
        double pole = oblicz_pole(liczba_punktow);
        System.out.println("Przybliżenie pola wynosi: "+ pole);

    }
    public static double oblicz_pole(int liczba_punktow){
        Random losowa_liczba = new Random();
        int punkty_w_polu = 0;
        for (int i=0; i < liczba_punktow;i++){
            double x = losowa_liczba.nextInt(101)/100.0;
            double y = losowa_liczba.nextInt(101)/100.0;


            if(y < Math.pow(x,2)){
                punkty_w_polu++;
            }
        }
        double aproksymacja_pola = (double) punkty_w_polu / liczba_punktow;
        return aproksymacja_pola;
    }
}