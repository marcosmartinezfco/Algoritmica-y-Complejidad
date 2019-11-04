package laberinto;

public class laberinto {

    /**
     *
     * @param tablero en el que esta representado un laberinto con posibles estados 0: libre, 1: camino, 2: pasado, 3:pared
     * @return boolean que indica la existencia de un camino entre entre la casilla (0,0) y la casilla (-1,-1)
     */
    public static boolean existeCamino(int[][] tablero){
        int[] df = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        return existeCaminoAUx(tablero, 0, 0, df, dc);
    }
    private static boolean existeCaminoAUx(int[][] tablero, int f, int c, int[] df, int[] dc){
        if (f == tablero.length-1 && c == tablero[c].length-1 )
            return true;
        else{
            for (int i = 0; i < 4 ; i++) {
                int f2 = f + df[i]; //probamos un nuevo estado
                int c2 = c + dc[i]; //que puede ser una casilla ariba, abajo, derecha o izquierda
                if(esAceptable(tablero,f2,c2)){
                    tablero[f2][c2] = 1; //anotamos
                    if (existeCaminoAUx(tablero, f2, c2, df, dc))
                        return true;
                    else
                        tablero[f2][c2] = 2; //lo marcamos como pasado para obviar esta casilla
                }
            }
            return false;
        }
    }

    private static boolean esAceptable(int[][] tablero, int f, int c){
        if (f>= 0 && c >=0 && f <tablero.length && c <tablero.length) //si esta dentro de rango
            return tablero[f][c] == 0;
        else
            return false;
    }

    public static void main(String[] args){
        int[][] tablero ={
                {0,3,3,0,3},
                {0,0,0,0,3},
                {3,3,0,0,3},
                {3,3,0,0,3},
                {3,3,3,0,0}
        };
        System.out.println(existeCamino(tablero));
    }
}
