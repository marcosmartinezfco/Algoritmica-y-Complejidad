import java.util.*;

public class Principal {

    /**
     * Funcion que partiendo de una lista de candidatos y un inventario rellena el mismo con
     * el mayor numero de objetos posibles maximizando el valor total de los objetos insertados
     * @param candidatos Array List con los posibles objetos a insertar en el inventario
     * @param inventario Inventario donde se intentan insertar los objetos maximizando el valor total
     * @return Array List (ordenado por valor) con los objetos que se han ordenado
     */
    public static ArrayList<Objeto> llenarInventario(ArrayList<Objeto> candidatos, Inventario inventario) {
        ArrayList<Objeto> solucion = new ArrayList<>();
        mergeSort(candidatos);
        
        while (0 < candidatos.size()){
            Objeto candidato = seleccionarCandidato(candidatos);
            if(esCandidatoFactible(candidato, inventario))
                solucion.add(candidato);
        }
        return solucion;
    }

    /**
     * Funcion que selecciona el objeto con mas valor de un Array list, ordenado
     * por valo,r de Objetos
     * @param candidatos Array list ordenado de objetos segun su valor
     * @return El objeto con mayor valor
     */
    private static Objeto seleccionarCandidato(ArrayList<Objeto> candidatos) {
        Objeto aux = candidatos.get(0);
        candidatos.remove(0);
        return aux;
    }

    /**
     * Comprueba si el objeto se puede insertar en el inventario
     * en caso de que asi sea lo inserta
     * @param candidato Objeto que intentamos insertar en el inventario
     * @param inventario Inventario donde intentamos insertar los objetos
     * @return boolean para indicar si el candidato se puede insertar o no
     */
    private static boolean esCandidatoFactible(Objeto candidato, Inventario inventario) {
        for (int j = 0; j < inventario.getN(); j++) {
            for (int i = 0; i < inventario.getN(); i++) {
                if (inventario.getCelda(i,j) == -1 && celdaAceptable(i,j,candidato,inventario)){
                    insertarObjeto(inventario, i , j , candidato);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Funcion que determina si el objeto se puede introducir a partir de la celda indicada
     * @param fil fila del inventario en el que nos encontramos
     * @param col columna del inventario en el que nos encontramos
     * @param objeto el objeto que queremos intentar insertar
     * @param inventario el inventario donde queremos insertar el objeto
     * @return boolean que indica si se puede insertar el objeto o no
     */
    private static boolean celdaAceptable(int fil, int col, Objeto objeto, Inventario inventario) {
        int ancho = 0;
        int largo = 0;

        for (int i = fil; i < inventario.getN(); i++) {
            if (inventario.getCelda(i, col) == -1)
                ancho ++;
            else
                break;
        }
        for (int i = col; i < inventario.getN(); i++) {
            if (inventario.getCelda(fil, i) == -1)
                largo ++;
            else
                break;
        }
        return objeto.getAlto() <= largo && objeto.getAncho() <= ancho;
    }

    private static void insertarObjeto(Inventario inventario, int fil ,int col, Objeto candidato){
        int auxCol = col;
        int auxFil = fil;

        while (auxFil < candidato.getAncho() + fil){
            while (auxCol < candidato.getAlto() + col){
                inventario.setCelda(auxFil, auxCol, candidato.getId());
                auxCol++;
            }
            auxCol = col;
            auxFil++;
        }
    }

    /**
     * Algortimo de ordenacion Merge Sort
     * Ordenamos en funcion del valor del objeto (a igual valor nos quedamos con el de menor tamaño)
     * @param candidatos Array list con los objetos que queremos ordenar
     */
    private static void mergeSort(ArrayList<Objeto> candidatos){
        mergeSortAux(candidatos, 0, candidatos.size()-1);
    }

    private static void mergeSortAux(ArrayList<Objeto> candidatos, int i0, int in){
        if (i0==in)
            return;
        else{
            int k = (i0+in)/2;
            mergeSortAux(candidatos, i0,k);
            mergeSortAux(candidatos, k+1, in);
            merge(candidatos, i0, k, in);
        }
    }

    private static void merge(ArrayList<Objeto> candidatos, int i0, int k, int in){
        int i = i0;
        int d = k+1;
        ArrayList<Objeto> aux = new ArrayList<Objeto>(in-i0+1);
        while(i<=k && d <= in)
            if(candidatos.get(i).getValor() > candidatos.get(d).getValor()){
                if(candidatos.get(i).getValor() == candidatos.get(d).getValor() && (candidatos.get(i).getAncho()*candidatos.get(i).getAlto()) > (candidatos.get(d).getAncho()*candidatos.get(d).getAlto())){
                    aux.add(candidatos.get(d));
                    d++;
                }
                else{
                    aux.add(candidatos.get(i));
                    i++;
                }
            }
            else{
                aux.add(candidatos.get(d));
                d++;
            }
        for (int a = i; a <= k ; a++) aux.add(candidatos.get(a));
        for (int b = d; b <= in ; b++) aux.add(candidatos.get(b));
        for (int c = 0; c < aux.size() ; c++) candidatos.set(c + i0, aux.get(c));
    }
}
