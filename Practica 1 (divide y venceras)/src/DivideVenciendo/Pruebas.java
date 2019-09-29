package DivideVenciendo;

public class Pruebas {
    private static int[][] vectores = {
            {-1 ,0, 2, 3, 10, 12, -23, -14, -7},
            {-3, 1, 2, -4},
            {5, 8, 8, 12, 14, 18, 22, 26, -20, -19, -19, -18, -18, -14, -13, -11, -10, -10, -10, -6, -5, -1, 1, 2},
            {-15, -12, -10, -7, -3, -2, -2, 0, 1, -19, -15, -15},
            {-3, 1, -13, -9, -6, -5, -5},
            {12, 14, 16, 19, -23, -22, -20, -18, -14, -12, -9, -9, -5, -1, 1, 3, 6, 9},
            {-27, -23, -23, -21, -17, -14, -13, -10, -7, -4, 1, 4, 5, -55, -55, -53, -50, -47, -46, -44, -43, -39, -35, -34, -33, -32, -29, -29},
            {-16, -14, -13, -13, -9, -7, -5, -4, -2, 1, -57, -57, -55, -52, -49, -47, -46, -44, -40, -38, -35, -35, -33, -29, -25, -23, -22, -22, -18},
            {11, 11, 14, -43, -40, -36, -36, -34, -32, -32, -31, -27, -24, -20, -17, -15, -15, -15, -13, -10, -7, -3, -3, 1, 1, 4, 7, 9, 11},
            {1, 3, -4},
            {4, 6, 6, 10, -3, 1},
            {1, 3, 4, 8, -41, -41, -41, -41, -37, -33, -29, -26, -22, -22, -18, -16, -14, -10, -10, -6, -5, -4, 1},
            {-17, -17, -14, -12, -11, -10, -7, -3, -2, 1, 3, 3, 7, 8, 11, 12, 16, 20, 24, -42, -39, -36, -34, -32, -29, -26, -25, -23, -20},
            {-4, -4, 1, 1},
            {1, 0},
            {8, 9, 13, -24, -23, -21, -17, -17, -16, -13, -9, -6, -5, -1, 1, 5},
            {-55, -55, -52, -48, -47, -44, -41, -38, -34, -30, -26, -24, -22, -21, -17, -13, -12, -11, -11, -8, -5, -3, 1, 3, 6, 7, 9},
            {4, -4, -1, 1, 1, 3},
            {-3, 1, 3, 7, 7, 11, 12, 12},
            {5, 5, 9, 10, 13, 16, 17, 20, -17, -15, -14, -14, -12, -11, -7, -3, -3, 1},
            {2, -7, -7, -6, -3, 1, 2}
    };

    private static int[] resul={27,3, 116, 1, 1, 80, 10, 1, 69, 4, 27, 17, 105, 2, 1, 36, 26, 9, 53, 96, 5};

    private static void imprimirVector(int[] vector) {
        for (int f = 0; f < vector.length-1; f++)
            System.out.print(vector[f]+ ", ");
        System.out.println(vector[vector.length-1]);
    }

    private static void probarTest(int apartado, int[][] vectores, int[]resul){
        boolean exito=true;
        for (int i=0;i<vectores.length;i++) {
            int suma=sumaPositivosDyV(apartado,vectores[i]);
            if (suma!=resul[i]) {
                System.out.println("NO FUNCIONA TU ALGORITMO EN ESTE CASO");
                imprimirVector(vectores[i]);
                System.out.println("La suma de los elementos positivos es " + resul[i] + ". Tu algoritmo devuelve " + suma);
                System.out.println();
                exito=false;
            }
        }
        if (exito)
            System.out.println("HAN TENIDO ÉXITO TODOS LOS TESTS. DISEÑA NUEVOS TESTS Y ASEGÚRATE QUE FUNCIONA TU ALGORITMO CORRECTAMENTE");
    }

    private static int sumaPositivosDyV(int apartado, int[] vector){
        if (apartado==1)
            return Principal.sumaPositivos1(vector);
        else
            return Principal.sumaPositivos2(vector);
    }

    public static void main(String[] args){
        System.out.println("TEST APARTADO 1");
        System.out.println("==========================");
        probarTest(1,vectores, resul);
        System.out.println();
        System.out.println("TEST APARTADO 2");
        System.out.println("==========================");
        probarTest(2,vectores, resul);
    }
}