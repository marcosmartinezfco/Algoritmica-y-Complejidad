package CaminoMasLargo;

public class CaminoMasLargo {
    public  static int caminoMasLargo(int[][] grafo, int origen, int destino){
        return caminoMasLargoAux(grafo, destino, origen,0,0);
    }

    private static int caminoMasLargoAux(int[][] grafo, int destino, int nodo, int coste, int costeMax){
        if(nodo == destino)
            return  Math.max(coste, costeMax);
        else {
            int i = 0;
            while (i < grafo.length){
                if (grafo[nodo][i] != Integer.MAX_VALUE) {
                    int costeAux = caminoMasLargoAux(grafo, destino, i, coste + grafo[nodo][i], costeMax);
                    costeMax = Math.max(costeAux, costeMax);
                }
                i++;
            }
            return costeMax;
        }
    }

    public static void main(String[] args){
        int[][] grafo = {
                {Integer.MAX_VALUE,1,Integer.MAX_VALUE,10,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,7,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1,5},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        System.out.println("El camino mas largo se tarda: " + caminoMasLargo(grafo,0,4));
    }
}
