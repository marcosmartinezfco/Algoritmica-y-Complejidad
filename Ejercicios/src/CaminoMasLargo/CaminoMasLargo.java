package CaminoMasLargo;

public class CaminoMasLargo {
    public  static int caminoMasLargo(int[][] grafo, int origen, int destino){
        boolean[] visitados = new  boolean[grafo.length];
        return caminoMasLargoAux(grafo, destino, visitados, origen,0,0);
    }

    private static int caminoMasLargoAux(int[][] grafo, int destino, boolean[] visitados, int nodo, int coste, int costeMax){
        if(nodo == destino)
            return  Math.max(coste, costeMax);
        else{
            for (int i = 0; i < visitados.length; i++)
                if (grafo[nodo][i] != Integer.MAX_VALUE){
                    int costeAux = caminoMasLargoAux(grafo,destino, visitados, i, coste+grafo[nodo][i], costeMax);
                    costeMax = Math.max(costeAux, costeMax);
                }
            return costeMax;
        }
    }

    public static void main(String[] args){
        int[][] grafo = {
                {Integer.MAX_VALUE,1,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,7,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        System.out.println("El camino mas largo se tarda: " + caminoMasLargo(grafo,0,4));
    }
}
