package Backtracking;

public class Principal {

    /**
     * funcion para calcular el numero de movimientos para dados dos strings, convertir el primero en el segundo
     * @param cadena1 cadena de virus inicial
     * @param cadena2 cadena de virus que queremos copiar
     * @return numero minimo de cambios que tenemos que realizar para que la cadena1 se transforme en la cadena2
     */

    public static int numMinMutaciones(String cadena1, String cadena2) {
        return mejorNumMutaciones(cadena1, cadena2, 0, Integer.MAX_VALUE);
    }

    /**
     * funcion auxiliar para calcular el numero de movimientos para dados dos strings, convertir el primero en el segundo
     * @param s1 cadena que queremos transformar
     * @param s2 cadena objetivo a la que queremos llegar
     * @param numMov numero movimientos que llevamos en la rama del arbol que estamos explorando
     * @param mejorMov mejor marca del algoritmo en lo que llevamos explorado del arbol
     * @return menor numero de movimientos necesarios para transformar la cadena 1 en la cadena 2
     */


    private static int mejorNumMutaciones(String s1, String s2, int numMov, int mejorMov){
        if ( s2.length() == 0 &&  s1.length() == 0) // Para ser solucion se tiene que haber recorrido ambos strings
            mejorMov = Math.min(mejorMov, numMov);

        else if (s2.length() == 0 || s1.length() == 0) //Si hemos recorrido al completo uno de los strings el numero de movimientos que nos queda es el de insertar o eliminar los caracteres restantes
            mejorMov = Math.min(mejorMov, numMov + Math.abs(s1.length()-s2.length()));

        else if (numMov < mejorMov){ //Poda para evitar ramas del arbol en la que le numero de movimientos es mayor al mejor resultado que tengamos de otra rama

            /* En cada nodo tenemos dos ramas, o bien los caracteres son iguales y lo unico que hacemos es pasar al siguiente nodo o bien probamos
               a realizar alguno de los tres movimientos posibles (cambiar, insertar o eliminar). Para que una opcion sea considerada aceptable es necesario
                que estemos dentro del rango de ambas cadenas, es decir que ninguna de las dos este vacia*/

            if(s1.charAt(0) == s2.charAt(0)) //pasar de carácter si coindicen en ambas cadenas
                mejorMov = Math.min(mejorNumMutaciones(s1.substring(1),s2.substring(1),numMov,mejorMov), mejorMov);
            
            else{ //Posibles movimientos a realizar

                //No es necesario anotar ni desanotar por la forma en la que esta implementado el codigo, ya que anotamos directamente en las llamadas recursivas

                //cambiar elem
                if(s1.length() == 1) mejorMov = Math.min(mejorNumMutaciones( s2.substring(0,1), s2,numMov + 1, mejorMov), mejorMov);
                else mejorMov = Math.min(mejorNumMutaciones(s2.charAt(0) + s1.substring(1), s2, numMov + 1, mejorMov), mejorMov);

                //insertar elem
                mejorMov = Math.min(mejorNumMutaciones( s2.charAt(0) + s1.substring(0), s2,numMov + 1, mejorMov), mejorMov);

                //eliminar elem
                mejorMov = Math.min(mejorNumMutaciones( s1.substring(1), s2,numMov + 1, mejorMov),mejorMov);
            }
        }
        return mejorMov;
    }
}
