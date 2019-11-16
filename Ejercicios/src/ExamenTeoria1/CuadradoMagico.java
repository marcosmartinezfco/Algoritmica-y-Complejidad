package ExamenTeoria1;

public class CuadradoMagico {
    public static int[][] cuadradoMagico(int N, int suma){
        int [][] tablero = new int[N][N];
        int[] sumaFil = new int[N];
        int[] sumaCol = new int[N];
        for (int i = 0; i < N; i++) {
            sumaCol[i] = 0;
            sumaFil[i] = 0;
        }
        boolean[] numUsados = new boolean[N*N];
        if (hayCuadradoMagico(tablero, 0, sumaFil, sumaCol,0,0,suma, numUsados))
            return tablero;
        else
            return null;
    }

    private static boolean hayCuadradoMagico(int[][] tablero, int n, int[] sumaFil, int[] sumaCol,int sumaDiagonal1, int sumaDiagonal2, int suma , boolean[] numUsados){
        if(n == numUsados.length)
            return true;
        else{
            int fil = n/tablero.length;
            int col = n%tablero.length;
            boolean solucion = false;
            for (int i = 1; i <= numUsados.length && !solucion; i++) {
                if(esAceptable(sumaFil, sumaCol, sumaDiagonal1, sumaDiagonal2, numUsados, fil, col, i, suma)){
                    tablero[fil][col] = i; //anotamos
                    numUsados[i-1] = true;
                    sumaFil[fil] += i;
                    sumaCol[col] += i;
                    if (fil==col) sumaDiagonal1 += i;
                    if (fil+col == sumaCol.length-1) sumaDiagonal2 += i;
                    if(hayCuadradoMagico(tablero,n+1,sumaFil,sumaCol,sumaDiagonal1,sumaDiagonal2,suma, numUsados))
                        solucion = true;
                    else{
                        tablero[fil][col] = 0; //anotamos
                        numUsados[i-1] = false;
                        sumaFil[fil] -= i;
                        sumaCol[col] -= i;
                        if (fil==col) sumaDiagonal1 -= i;
                        if (fil+col == sumaCol.length-1) sumaDiagonal2 -= i;
                    }
                }
            }
            return solucion;
        }
    }

    private static boolean esAceptable(int[] sumaFil, int[] sumaCol, int sumaDiagonal1, int sumaDiagonal2, boolean[] numUsados, int fil, int col, int num, int suma){
        if (numUsados[num-1])
            return false;
        else if (col == sumaFil.length-1 && sumaFil[fil]+num != suma)
            return false;
        else if (fil == sumaFil.length-1 && sumaCol[col]+num != suma)
            return false;
        else if (fil+col == sumaFil.length-1 && fil == sumaFil.length-1 && sumaDiagonal2+num != suma)
            return false;
        else if (fil == col &&  fil == sumaFil.length-1 && sumaDiagonal1+num != suma)
            return false;
        else if (col < sumaFil.length-1 && sumaFil[fil]+num >= suma)
            return false;
        else if (fil < sumaFil.length-1 && sumaCol[col]+num >= suma)
            return false;
        else if (fil == col && fil < sumaFil.length-1 && sumaDiagonal1+num>= suma)
            return false;
        else if (fil+col == sumaFil.length-1 && fil < sumaFil.length-1 && sumaDiagonal2>= suma)
            return false;
        else
            return true;
    }

    public static void main(String[] args){
        int[][] cuadradoMagico = cuadradoMagico(3, 15 );
        if (cuadradoMagico != null)
            for (int i = 0; i < cuadradoMagico.length; i++) {
                for (int j = 0; j < cuadradoMagico.length ; j++) {
                    System.out.print(cuadradoMagico[i][j]+" ");
                }
                System.out.println("");
            }
        else
            System.out.println("Nada");
    }
}
