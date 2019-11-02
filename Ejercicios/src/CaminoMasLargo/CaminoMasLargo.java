package CaminoMasLargo;

public class CaminoMasLargo {
    public  static int caminoMasLargo(int[][] grafo, int origen, int destino){
        boolean[] visitados = new boolean[grafo.length];
        visitados[origen] = true;
        return caminoMasLargoAux(grafo, destino, visitados, origen,0,0);
    }

    private static int caminoMasLargoAux(int[][] grafo, int destino, boolean[] visitados, int nodo, int coste, int costeMax){
        if(nodo == destino)
            return  Math.max(coste, costeMax);
        else {
            int i = 0;
            while (i < grafo.length){
                if (!visitados[i] && grafo[nodo][i] != Integer.MAX_VALUE) { //si no se ha visitado el nodo y hay camino es aceptable
                    visitados[i] = true;//anotar
                    int costeAux = caminoMasLargoAux(grafo, destino, visitados, i, coste + grafo[nodo][i], costeMax);
                    costeMax = Math.max(costeAux, costeMax);
                    visitados[i] = false;//desanotar
                }
                i++;
            }
            return costeMax;
        }
    }

    public static void main(String[] args){
        int[][] grafo = {
                {Integer.MAX_VALUE,1,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,1,7,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1,2},
                {7,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}
        };
        System.out.println("El camino mas largo se tarda: " + caminoMasLargo(grafo,0,4));
    }
}
