package NumeroCaminos;

public class NumeroCaminos {
    /**
     * Funcion para calcular el mayor numero de caminos simples que existe en un grafo no dirigido y ponderado
     * @param grafo no dirigido y ponderado
     * @param origen nodo desde el que partimos
     * @param destino nodo al que queremos llegar
     * @return numero de caminos simples distintos que existen entre el nodo origen y destino
     */
    public  static int numeroCaminos(int[][] grafo, int origen, int destino){
        boolean[] visitados = new boolean[grafo.length];
        visitados[origen] = true;
        return numeroCaminosAux(grafo, origen, destino, visitados);
    }

    /**
     * Algortimo backtracking que resuelve el problema del mayor descrito
     * @param grafo no dirigido y ponderado
     * @param nodo nodo en el que nos encontramos actualmente
     * @param destino nodo al que queremos llegar
     * @param visitados array de booleanos que representan el camino que estamos siguiendo
     * @return numero de caminos simples distintos que existen entre el nodo origen y destino
     */
    private static int numeroCaminosAux(int[][] grafo, int nodo, int destino, boolean[] visitados){
        if(nodo == destino)
            return 1; //cada vez que llegamos al final de un posible camino devolvemos 1
        else{
            int numCaminosAux = 0;
            for (int i = 0; i < visitados.length ; i++) {
                if(!visitados[i] && grafo[nodo][i] != Integer.MAX_VALUE){ //si el nodo no se ha visitado y existe camino es aceptable
                    visitados[i] = true; //anotar
                    numCaminosAux += numeroCaminosAux(grafo, i, destino, visitados);
                    visitados[i] = false; //desanotar
                }
            }
            return  numCaminosAux;
        }
    }

    public static void main(String[] args){
        int[][] grafo = {
                {Integer.MAX_VALUE,1,Integer.MAX_VALUE,1,Integer.MAX_VALUE}, //0
                {1,Integer.MAX_VALUE,1,1,Integer.MAX_VALUE}, //1
                {Integer.MAX_VALUE,1,Integer.MAX_VALUE,1,1}, //2
                {1,1,1,Integer.MAX_VALUE,1}, //3
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,1,Integer.MAX_VALUE} //4
        };
        System.out.println("Existen " + numeroCaminos(grafo,0,4) + " caminos");
    }
}