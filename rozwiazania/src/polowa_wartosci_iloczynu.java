/*Dany jest pewien ciąg liczbowy (fn), której dwa pierwsze wyrazy równe są odpowiednio 2 i 4.
Następny element ciągu równy jest połowie wartości iloczynu dwóch poprzednich wyrazów ciągu.

Utwórz klasę, a w niej metodę umożliwiającą wyznaczenie n-tego wyrazu ciągu (fn).
Używając tej metody, wyznacz osmy wyraz tego ciągu. (9 pkt)
*/


public class polowa_wartosci_iloczynu {
    public static int ciag_liczbowy(int n) {
        if(n == 1){
            return 2;
        }
        if(n == 2){
            return 4;
        }
        return ciag_liczbowy(n-1)*ciag_liczbowy(n-2);
    }
    public static void main(String[] args) {
        System.out.println(ciag_liczbowy(6));
    }
}
