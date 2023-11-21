/*Dany jest pewien ciąg liczbowy f(n), którego dwa pierwsze elementy równe są 1 (f(1)=f(2)=1),
 każdy następny element równy jest potrojenemu iloczynowi dwóch poprzednich elementów ciągu.

Utwórz funkcję umożliwiającą wyznaczenie n-tego wyrazu ciągu f(n) wykorzystując metodę dziel i zwyciężaj.
 Za pomocą wywołania utworzonej metody wyznacz piąty wyraz tego ciągu. (9 pkt)*/


public class ciag_liczbowy {

    public static int wyrazciagu(int n){
        if(n==1 || n == 2) {
            return 1;
        }
        int n_minus_jeden = wyrazciagu(n-1);
        int n_minus_dwa = wyrazciagu(n-2);
        return 3*n_minus_jeden*n_minus_dwa;

    }

    public static void main(String[] args) {
        System.out.println("Piąty wyraz ciągu wynosi : " + wyrazciagu(5));
    }
}
