package Backtracking;

public class Principal {

    /**
     * funcion para calcular el numero de movimientos para dados dos strings, convertir el primero en el segundo
     * @param cadena1 cadena de virus inicial
     * @param cadena2 cadena de virus que queremos copiar
     * @return numero minimo de cambios que tenemos que realizar para que la cadena1 se transforme en la cadena2
     */

    public static int numMinMutaciones(String cadena1, String cadena2) {
        return mejorNumMutaciones(cadena1, cadena2, 0,0, Integer.MAX_VALUE);
    }

    /**
     * funcion auxiliar para calcular el numero de movimientos para dados dos strings, convertir el primero en el segundo
     * @param s1 cadena que queremos transformar
     * @param s2 cadena objetivo a la que queremos llegar
     * @param index index de la posicion en la que nos encontramos en los strings
     * @param numMov numero movimientos que llevamos en la rama del arbol que estamos explorando
     * @param mejorMov mejor marca del algoritmo en lo que llevamos explorado del arbol
     * @return menor numero de movimientos necesarios para transformar la cadena 1 en la cadena 2
     */
    private static int mejorNumMutaciones(String s1, String s2, int index,int numMov, int mejorMov ){
        if (index == s2,length() && index == s1,length())
            mejorMov = Math.min(mejorMov, numMov);

        else if (numMov < mejorMov){
            if((index < s2.length() && index < s1.length()) && s1.charAt(index) == s2.charAt(index)) //dejar elemento como esta
                mejorMov = Math.min(mejorNumMutaciones(s1,s2,index+1,numMov,mejorMov), mejorMov); //si ha encontrado un menor numero de mov lo devulve
            else if (index < s1.length() && index < s2.length()) { //cambiar elem
                String aux = "";
                if(index == s1.length()-1) aux = s1.substring(0, index) + s2.charAt(index);     //creamos un string auxiliar con la modificacion que nos interesa
                else aux = s1.substring(0, index) + s2.charAt(index) + s1.substring(index + 1); //dependiendo de si estamos dentro de rango en ambas cadenas
                mejorMov = Math.min(mejorNumMutaciones(aux, s2, index + 1, numMov + 1, mejorMov), mejorMov);
            }
            if (s1.length() < s2.length()){ //inserta elem
                String aux = s1.substring(0, index) + s2.charAt(index) + s1.substring(index);
                mejorMov = Math.min(mejorNumMutaciones(aux, s2, index + 1, numMov + 1, mejorMov), mejorMov);
            }
           else{ //elimina elem
                String aux = s1.substring(0, index) + s1.substring(index + 1);
                mejorMov = Math.min(mejorNumMutaciones(aux, s2, index, numMov + 1, mejorMov),mejorMov);
            }
        }
        return mejorMov;
    }
}