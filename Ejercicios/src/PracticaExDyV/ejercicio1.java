package PracticaExDyV;

public class ejercicio1 {

    /**
     * ejercicio para calcular el numero de veces que un ha sido desplazado un vector ordenado
     * dando como resultado un array circular
     * @param arr array ordenado
     * @return numero de veces que el array ha sido desplazado a la derecha
     */

    public static int howManyTimesRoteted(int[] arr){
        int posMax = howManyTimesRotetedAux(arr,0,arr.length-1);
        if (posMax == arr.length-1)
            return 0;
        else
            return posMax+1;
    }

    private static int howManyTimesRotetedAux(int[] arr, int i0, int in){ //funcion que devuelve la posicion del mayor elemento del vector
        if (i0 == in)
            return i0;
        else {
            int k = (i0 + in) / 2;

            if(arr[k]<arr[i0])
                return howManyTimesRotetedAux(arr, i0, k-1);
            else if(arr[k]<arr[k+1])
                return howManyTimesRotetedAux(arr, k+1, in);
            else
                return k;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,4,5,2};
        System.out.println(howManyTimesRoteted(arr));
    }
}
