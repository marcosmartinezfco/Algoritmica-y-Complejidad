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
     * @param vector
     * @return
     */
    public static int sumaPositivos2(int[] vector){
        return sumaPositivos2Aux(vector, 0, vector.length-1);
    }
    private static int sumaPositivos2Aux(int[] vector, int i0, int in){
        if(i0 == in)
            if (vector[i0] > 0)
                return vector[i0];
            else
                return 0;
        else{
            int m = sumaPositivos2Aux(vector, i0+1, in);
            if (vector[i0] > 0)
                return vector[i0] + m;
            else
                return m;
        }
    }
}