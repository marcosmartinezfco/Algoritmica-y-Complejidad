package PracticaExDyV;

public class ejercicio2 {

    /**
     * Encontrar la posicion de un elemento que se pasa por parametro en un array ordenado
     */

    public static int elementInArray(int[] arr, int element){
        return elementInArrayAux(arr,element,0,arr.length-1);
    }

    private static int elementInArrayAux(int[] arr, int element, int i0, int in){
        if(i0==in)
            return i0;
        else{
            int k = (i0+in)/2;
            if(arr[k] == element)
                return k;
            else if (arr[k] > arr[i0] && arr[k] < arr[in])  //el array esta ordenado y no esta rotado
                if (arr[k] > element) //el elemento que buscamos esta a la izquierda de k
                    return elementInArrayAux(arr, element, i0, k - 1);
                else //el elemento que buscamso esta a la derecha de k
                    return elementInArrayAux(arr, element, k + 1, in);
            else //el arr esta rotado
                if (element < arr[k])
                    return elementInArrayAux(arr,element,i0,k-1);
                else if (element <= arr[in])
                    return elementInArrayAux(arr, element,k+1, in);
                else
                    return elementInArrayAux(arr,element,i0,k-1);
        }
    }

    public static void main(String[] args){
        int[] arr = {9,10,2,5,6,8};
        System.out.println(elementInArray(arr,10));
    }
}

