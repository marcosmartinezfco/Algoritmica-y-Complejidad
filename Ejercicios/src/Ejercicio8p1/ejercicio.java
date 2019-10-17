package Ejercicio8p1;

/**
 * Algortimo de backtracking en el que se nos pide calcular si en un conjunto de numeros enteros existe un subconjunto
 * cuya suma de elementos valga X
 */

public class ejercicio {

    public static boolean existeSubConjunto(int[] conjunto, int suma) {
        boolean[] conjuntoAux = new boolean[conjunto.length];
        boolean exist = existeSubConjuntoAux(conjunto, conjuntoAux, suma, 0, 0);
        if (exist)
            imprimirArr(conjuntoAux);
        return  exist;
    }

    private static boolean existeSubConjuntoAux(int[] conjunto, boolean[] conjuntoAux, int suma, int sumaSub, int pointer) {
        if (sumaSub == suma)
            return true;
        else if (sumaSub > suma)
            return false;
        else {
            for (int i = 0; i < conjunto.length; i++)
                if (sumaSub + conjunto[i] <= suma && i >= pointer) {
                    conjuntoAux[i] = true; //anotar
                    if (existeSubConjuntoAux(conjunto, conjuntoAux, suma, sumaSub + conjunto[i], i + 1))
                        return true;
                    else {
                        conjuntoAux[i] = false; //desanotar
                        pointer++;
                    }
                }
            return false;
        }
    }

    private static void imprimirArr(boolean[] arr){
        System.out.print("El sub array que resuleve el ejercicio es : ");
        for (boolean x: arr) {
            if (x)
                System.out.print(" 1 ");
            else
                System.out.print(" 0 ");
        }
        System.out.println("");
    }

    public static void main(String[] args){
        int[] arr = {1,3,4,7,2,3};
        if(!existeSubConjunto(arr,10))
            System.out.println("No existe solcuion al problema");
    }
}
