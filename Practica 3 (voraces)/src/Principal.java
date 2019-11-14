import java.util.*;

public class Principal {

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

    private static Objeto seleccionarCandidato(ArrayList<Objeto> candidatos) {
        Objeto aux = candidatos.get(0);
        candidatos.remove(0);
        return aux;
    }


    /**
     * Ordenar solo por valor
     * @param candidatos lista de objetos que queremos considerar para insertar en el inventario
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
            if(candidatos.get(i).getValor() >= candidatos.get(d).getValor()){
                aux.add(candidatos.get(i));
                i++;
            }
            else{
                aux.add(candidatos.get(d));
                d++;
            }
        for (int a = i; a <= k ; a++) { aux.add(candidatos.get(a)); }
        for (int b = d; b <= in ; b++) { aux.add(candidatos.get(b)); }
        for (int c = 0; c < aux.size() ; c++) candidatos.set(c + i0, aux.get(c));
    }

	private static boolean esCandidatoFactible(Objeto candidato, Inventario inventario) {
        int [] celdasPosibles = posicion(inventario);
        for (int i = 0; i < inventario.getN(); i++) {
            for (int j = celdasPosibles[i]; j < inventario.getN(); j++) {
                if(inventario.getCelda(j,i) == -1 && celdaAceptable(i,j,candidato,inventario)){
                    insertarObjeto(inventario, candidato, i,j);
                    return true;
                }
            }
        }
		return false;
	}

    /**
     * Devulve un array con la celda libre mas a la izquierda de cada
     * fila del inventario
     */
	private static int[] posicion(Inventario inventario){
	    int[] celdasPosibles = new int[inventario.getN()];
        for (int f = 0; f < inventario.getN(); f++)
            for (int c = 0; c < inventario.getN() ; c++)
                if(inventario.getCelda(c, f) == -1)
                    celdasPosibles[f] = c;
        return celdasPosibles;
    }

    private static boolean celdaAceptable(int fil, int col, Objeto objeto, Inventario inventario) {
        int largo = 0;
        int ancho = 0;

        for (int i = fil; i < inventario.getN(); i++) {
            if (inventario.getCelda(col, i) == -1)
                ancho ++;
            else
                break;
        }
        for (int i = col; i < inventario.getN(); i++) {
            if (inventario.getCelda(i, fil) == -1)
                largo ++;
            else
                break;
        }
        return objeto.getAlto() <= largo && objeto.getAncho() <= ancho;
    }

    private static void insertarObjeto(Inventario inventario, Objeto objeto, int fil, int col){
        for (int i = fil; i < objeto.getAlto()+fil-1 ; i++)
            for (int j = col; j < objeto.getAncho()+col-1; j++)
                inventario.setCelda(j,i,objeto.getId());
    }
}
