package Backtracking;

public class Principal {

    /**
     * @param cadena1 cadena de virus inicial
     * @param cadena2 cadena de virus que queremos copiar
     * @return numero minimo de cambios que tenemos que realizar para que la cadena1 se transforme en la cadena2
     */

    public static int numMinMutaciones(String cadena1, String cadena2) {
        return mejorNumMutaciones(cadena1, cadena2, 0,0, Integer.MAX_VALUE);
    }

    private static int mejorNumMutaciones(String s1, String s2, int pointer,int numMov, int mejorMov ){
        if (s1.equals(s2))
            mejorMov = Math.min(mejorMov, numMov);

        else if (numMov < mejorMov){
            if((pointer < s2.length() && pointer < s1.length()) && s1.charAt(pointer) == s2.charAt(pointer)) //dejar elemento como esta
                mejorMov = Math.min(mejorNumMutaciones(s1,s2,pointer+1,numMov,mejorMov), mejorMov);
            else if (pointer < s1.length() && pointer < s2.length()) { //cambiar elem
                String aux = "";
                if(pointer == s1.length()-1) aux = s1.substring(0, pointer) + s2.charAt(pointer);
                else aux = s1.substring(0, pointer) + s2.charAt(pointer) + s1.substring(pointer + 1);
                mejorMov = Math.min(mejorNumMutaciones(aux, s2, pointer + 1, numMov + 1, mejorMov), mejorMov);
            }

            if (s1.length() < s2.length()){ //inserta elem
                String aux = s1.substring(0, pointer) + s2.charAt(pointer) + s1.substring(pointer);
                mejorMov = Math.min(mejorNumMutaciones(aux, s2, pointer + 1, numMov + 1, mejorMov), mejorMov);
            }
           else{ //elimina elem
                String aux = s1.substring(0, pointer) + s1.substring(pointer + 1);
                mejorMov = Math.min(mejorNumMutaciones(aux, s2, pointer, numMov + 1, mejorMov),mejorMov);
            }
        }
        return mejorMov;
    }
}