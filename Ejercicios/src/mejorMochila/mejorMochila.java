package mejorMochila;

/**
 * Ejercicio para practicar el esquema de seleccion optima aplicando backtracking
 */

public final class mejorMochila {

    /**
     * funcion diseñada para devolvernos la configuracion de elementos que podremos tener en la mochila de forma que no nos pasemos del peso maximo con un valor maximo
     * @param peso array con el peso asociado a cada uno de los elementos de los que disponemos
     * @param valor array con el valor asociado a cada uno de los elementos de los que disponemos
     * @param pesoMax valor numerico que como se puede apreciar nos da el peso maximo que soporta la mochila
     * @return vector de booleanos en la que true indica que el elemento ha sido incluido y false que no lo ha sido
     */

    public static boolean[] mejorMochilaFuncion(int[] peso, int[] valor, int pesoMax){
        boolean[] mochila = new boolean[peso.length]; //para almacenar el estado de que elementos hemos añadido
        boolean[] mejorMochila = new boolean[peso.length];
        int v = mejorMochilaAux(peso, valor, pesoMax, 0, mochila, mejorMochila, 0, 0,0);
        System.out.println("El mejor valor de la mochila es: " + v);
       // imprimirArrayBool(mochila);
        return  mejorMochila;
    }

    private static int mejorMochilaAux(int[] peso, int[] valor, int pesoMax,int pesoActual, boolean[] mochila, boolean[] mejorMochila, int numElem, int mejorValor, int valorActual){
        if (numElem == peso.length)
            if (valorActual > mejorValor){
                System.arraycopy(mochila, 0, mejorMochila, 0, mochila.length);
                return valorActual;
            }
            else
                return mejorValor;
        else{
            if(pesoActual + peso[numElem] <= pesoMax){ //meter objeto
                mochila[numElem] = true;
                int v1 = mejorMochilaAux(peso, valor, pesoMax,pesoActual+peso[numElem], mochila, mejorMochila, numElem+1, mejorValor, valorActual + valor[numElem]);
                if (v1 > mejorValor)
                    mejorValor = v1;
                //no hace falta desanotar por como se ha implementado
            }
            //no meter objeto
            mochila[numElem] = false;
            int v2 = mejorMochilaAux(peso, valor, pesoMax,pesoActual, mochila, mejorMochila, numElem+1, mejorValor, valorActual);
            if (v2 > mejorValor)
                mejorValor = v2;
            //no hace falta desanotar al igual que en el caso anterior
            }
            return mejorValor;
    }

    public static void imprimirArrayBool(boolean[] array){
        for (int i = 0; i < array.length; i++) {
            if (array[i])
                System.out.print(" 1 ");
            else
                System.out.print(" 0 ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args){
        int[] peso = {1,2,3,4,5};
        int[] valor = {15,2,16,17,3};
        boolean[] mochilaOptimizada = mejorMochilaFuncion(peso, valor, 8);
        imprimirArrayBool(mochilaOptimizada);
    }
}
