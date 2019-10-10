package DivideVenciendo;

public class Principal {
    /**
     * algoritmo implementado en divide y venceras con complejidad O(N) en el peor de los casos
     * @param vector de 10 numeros a lo sumo
     * @return la suma de todos los elementos positivos del array
     */
    public static int sumaPositivos1(int[] vector){
        return sumaPositivos1Aux(vector, 0, vector.length-1);
    }
    private static int sumaPositivos1Aux(int[] vector, int i0, int in){
        if (i0 == in){
            if (vector[i0] > 0)
                return vector[i0];
            else
                return 0;
        }
        else{
            int k = (i0 + in) / 2;
            int m1 = sumaPositivos1Aux(vector, i0, k);
            int m2 = sumaPositivos1Aux(vector, k+1, in);
            return m1 + m2;
        }
    }

    /**
     * algoritmo implementado en divide y venceras con complejidad O(log n) en el peor de los casos
     * @param vector de 10 numeros a lo sumo
     * @return la suma de todos los elementos positivos del array
     */
    public static int sumaPositivos2(int[] vector) {
        int max = mayorEnArray(vector, 0, vector.length-1);
        if (max == -1) // Esto significa que no hay ningun elemento positivo en el vector
            return 0;
        else
            return sumaPositivos2Aux(vector, max);
    }

    private static int mayorEnArray(int[] vector, int i0, int in){ //Esta funcion nos devuelve la posicion del mayor elemento del array
        if(i0 == in)
            if (vector[i0] > 0)
                return  i0; //Si el elemento maximo es positivo devolvemos su posicion
            else
                return -1; //Si el elemento maximo es negativo devolvemos -1
        else{
            int k = (i0+in)/2;

            if(vector[k]<vector[i0])
                return mayorEnArray(vector, 0, k-1);
            else if(vector[k]<vector[k+1])
                return mayorEnArray(vector, k+1, in);
            else
                return k;
        }
    }

    private static int sumaPositivos2Aux(int[] vector, int k){ //Esta funcion suma todos los elementos positivos que hay en el vector desde la posicion que le pasamos
        int suma= 0; int i = 0;
        while(vector[k] > 0 && i < 10 && i < vector.length){ //Suma hasta que encuentra un elemento no sumable, hasta que ha sumado los 10 positivos o todo el array
            suma += vector[k];
            if(k == 0)
                k = vector.length;
            k--;
            i++;
        }
        return suma;
    }
}