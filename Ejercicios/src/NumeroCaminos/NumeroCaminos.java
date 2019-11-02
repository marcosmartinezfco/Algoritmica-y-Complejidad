package NumeroCaminos;

public class NumeroCaminos {
    public  static int numeroCaminos(int[][] grafo, int origen, int destino){
        boolean[] visitados = new boolean[grafo.length];
        visitados[origen] = true;
        return numeroCaminosAux(grafo, origen, destino, visitados);
    }

    private static int numeroCaminosAux(int[][] grafo, int nodo, int destino, boolean[] visitados){
        if(nodo == destino)
            return 1;
        else{
            int numCaminosAux = 0;
            for (int i = 0; i < visitados.length ; i++) {
                if(!visitados[i] && grafo[nodo][i] != Integer.MAX_VALUE){
                    visitados[i] = true;
                     numCaminosAux += numeroCaminosAux(grafo, i, destino, visitados);
                    visitados[i] = false;
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
