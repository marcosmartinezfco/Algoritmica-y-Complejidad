package PracticaExDyV;

public class ejercicio1 {

    /**
     * ejercicio para calcular el numero de veces que un ha sido desplazado un vector ordenado
     * dando como resultado un array circular
     * @param arr array ordenado
     * @return numero de veces que el array ha sido desplazado a la derecha
     */

    public static int howManyTimesRoteted(int[] arr){
        return howManyTimesRotetedAux(arr,0,0,arr.length-1);
    }

    private static int howManyTimesRotetedAux(int[] arr, int times, int i0, int in){
        if (i0 == in)
            return times;
        else {
            int k = (i0 + in) / 2;

            if (arr[i0] < arr[k] && arr[k] < arr[in]) //el array no es circular por lo que no ha sido desplazado
                return 0;
            else if(arr[i0] >arr[k]) //el minimo esta a la izquierda
                return  howManyTimesRotetedAux(arr,times,i0,k); //no incrementamos el numero de veces que ha sido desplazado
            else //el minimo esta a la derecha
                return howManyTimesRotetedAux(arr,k+1,k+1,in); //el numero de veces que ha sido desplazado es el numero de elementos antes del minimo

        }
    }

    public static void main(String[] args){
        int[] arr = {9,10,2,5,6,8};
        System.out.println(howManyTimesRoteted(arr));
    }
}
